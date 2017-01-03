package com.oes.service;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oes.mapper.ExamUserMapper;
import com.oes.pojo.ExamUser;
@Service
public class ExamFileService implements IExamFileService {
	//����ʱ��Ҫѧ�ţ������ݿ��Զ�����---�ȴ�ʵ��

	/**  
     * POI:����Excel�ļ��е����ݲ���ÿ�����ݷ�װ��һ��ʵ��  
     * @param fis �ļ�������  
     * @return List<EmployeeInfo> Excel�����ݷ�װʵ��ļ���  
     */  
	@Autowired
	private ExamUserMapper esm;
	@Override
	public List<ExamUser> importExamUserByPoi(InputStream fis) {
	        List<ExamUser> examUsers = new ArrayList<ExamUser>();   
	        ExamUser examUser = null;   
	           
	        try {   
	            //����Excel������   
	            XSSFWorkbook xwb = new XSSFWorkbook(fis);   
	            //�õ���һ��������   
	            XSSFSheet sheet = xwb.getSheetAt(0);   
	            XSSFRow row = null;   
	            //���ڸ�ʽ��   
	            DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");   
	            //�����ñ�������еĹ�����i��ʾ����������� getNumberOfSheets��ʾ�����������    
	            for(int i = 0; i < xwb.getNumberOfSheets(); i++) {   
	                sheet = xwb.getSheetAt(i);   
	                //�����������е���,j��ʾ���� getPhysicalNumberOfRows�е�����   
	                for(int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {   
	                    row = sheet.getRow(j);   
	                    examUser = new ExamUser(); 	                       
	                    //�˷�������getCellValue(HSSFCell cell)�Խ������������ݽ����жϣ�������Ӧ�Ĵ���   
	                    if(ExamFileService.getCellValue(row.getCell(0)) != null && !"".equals(ExamFileService.getCellValue(row.getCell(0)))) {   
	                    	examUser.setExamUserId(Integer.valueOf(ExamFileService.getCellValue(row.getCell(0))));   
	                    }   
	                    
	                    examUser.setExamUserName(ExamFileService.getCellValue(row.getCell(1)));
	                    
	                    if(ExamFileService.getCellValue(row.getCell(2)) != null && !"".equals(ExamFileService.getCellValue(row.getCell(2)))) {  
	                    examUser.setExamUserNumber(ExamFileService.getCellValue(row.getCell(2)));   
	                    }
	                    
	                    if(ExamFileService.getCellValue(row.getCell(3)) != null && !"".equals(ExamFileService.getCellValue(row.getCell(3)))) {  
		                    examUser.setExamUserPassword(ExamFileService.getCellValue(row.getCell(3)));   
		                    }
	                    if(ExamFileService.getCellValue(row.getCell(4)) != null && !"".equals(ExamFileService.getCellValue(row.getCell(4)))) {  
		                    examUser.setExamUserTeacher(ExamFileService.getCellValue(row.getCell(4)));   
		                    }
	                    
	                    examUser.setExamUserSex(ExamFileService.getCellValue(row.getCell(5))); 
	                    //����
	                    if(ExamFileService.getCellValue(row.getCell(6)) != null && !"".equals(ExamFileService.getCellValue(row.getCell(6)))) {   
                        examUser.setExamUserBirthday(ft.parse(ExamFileService.getCellValue(row.getCell(6))));
                       }   
	                    examUser.setExamUserTel(ExamFileService.getCellValue(row.getCell(7))); 
	                    examUser.setExamUserAddress(ExamFileService.getCellValue(row.getCell(8)));
	                    examUser.setExamUserDone(Integer.valueOf(ExamFileService.getCellValue(row.getCell(9))));
	                    
	                    examUsers.add(examUser);   
	                }   
	                   
	            }   
	        } catch (IOException e) {   
	            e.printStackTrace();   
	        } 
	        catch (java.text.ParseException e) {
				e.printStackTrace();
			}   
	        int i = 0;
	        for(ExamUser examUser1 : examUsers){
	        	
	        	i = i + (esm.insert(examUser1));
	        }
	        System.out.println( "��������Ӱ���������" +  i + "\n" );
	        return examUsers;   
	    }   
	    //�жϴ�Excel�ļ��н����������ݵĸ�ʽ   
	    private static String getCellValue(XSSFCell cell){   
	        String value = null;   
	        //�򵥵Ĳ��������   
	        switch(cell.getCellType())   
	        {   
	            case XSSFCell.CELL_TYPE_STRING://�ַ���   
	                value = cell.getRichStringCellValue().getString();   
	                break;   
	            case XSSFCell.CELL_TYPE_NUMERIC://����   
	                long dd = (long)cell.getNumericCellValue();   
	                value = dd+"";   
	                break;   
	            case XSSFCell.CELL_TYPE_BLANK:   
	                value = "";   
	                break;      
	            case XSSFCell.CELL_TYPE_FORMULA:   
	                value = String.valueOf(cell.getCellFormula());   
	                break;   
	            case XSSFCell.CELL_TYPE_BOOLEAN://boolean��ֵ   
	                value = String.valueOf(cell.getBooleanCellValue());   
	                break;   
	            case XSSFCell.CELL_TYPE_ERROR:   
	                value = String.valueOf(cell.getErrorCellValue());   
	                break;   
	            default:   
	                break;   
	        }   
	        return value;   
	    }  
}
