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
	//插入时不要学号，让数据库自动分配---等待实现

	/**  
     * POI:解析Excel文件中的数据并把每行数据封装成一个实体  
     * @param fis 文件输入流  
     * @return List<EmployeeInfo> Excel中数据封装实体的集合  
     */  
	@Autowired
	private ExamUserMapper esm;
	@Override
	public List<ExamUser> importExamUserByPoi(InputStream fis) {
	        List<ExamUser> examUsers = new ArrayList<ExamUser>();   
	        ExamUser examUser = null;   
	           
	        try {   
	            //创建Excel工作薄   
	            XSSFWorkbook xwb = new XSSFWorkbook(fis);   
	            //得到第一个工作表   
	            XSSFSheet sheet = xwb.getSheetAt(0);   
	            XSSFRow row = null;   
	            //日期格式化   
	            DateFormat ft = new SimpleDateFormat("yyyy-MM-dd");   
	            //遍历该表格中所有的工作表，i表示工作表的数量 getNumberOfSheets表示工作表的总数    
	            for(int i = 0; i < xwb.getNumberOfSheets(); i++) {   
	                sheet = xwb.getSheetAt(i);   
	                //遍历该行所有的行,j表示行数 getPhysicalNumberOfRows行的总数   
	                for(int j = 0; j < sheet.getPhysicalNumberOfRows(); j++) {   
	                    row = sheet.getRow(j);   
	                    examUser = new ExamUser(); 	                       
	                    //此方法调用getCellValue(HSSFCell cell)对解析出来的数据进行判断，并做相应的处理   
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
	                    //生日
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
	        System.out.println( "批量插入影响的行数：" +  i + "\n" );
	        return examUsers;   
	    }   
	    //判断从Excel文件中解析出来数据的格式   
	    private static String getCellValue(XSSFCell cell){   
	        String value = null;   
	        //简单的查检列类型   
	        switch(cell.getCellType())   
	        {   
	            case XSSFCell.CELL_TYPE_STRING://字符串   
	                value = cell.getRichStringCellValue().getString();   
	                break;   
	            case XSSFCell.CELL_TYPE_NUMERIC://数字   
	                long dd = (long)cell.getNumericCellValue();   
	                value = dd+"";   
	                break;   
	            case XSSFCell.CELL_TYPE_BLANK:   
	                value = "";   
	                break;      
	            case XSSFCell.CELL_TYPE_FORMULA:   
	                value = String.valueOf(cell.getCellFormula());   
	                break;   
	            case XSSFCell.CELL_TYPE_BOOLEAN://boolean型值   
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
