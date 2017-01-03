package com.oes.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.oes.pojo.ExamUser;
import com.oes.service.ExamFileService;



@Controller
public class FileUploadController {
	
	@Autowired
	private ExamFileService efs;
	
	@RequestMapping(value = "/file")
	public String file(){	
		return "fileUpload";		
	}
	
	
	@RequestMapping(value = "/upload")  
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session, ModelMap model) throws IOException {  
  
		String path = session.getServletContext().getRealPath("upload");
		String fileName = file.getOriginalFilename();
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
  
        //±£´æ  
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		InputStream fis = new FileInputStream(targetFile);
		List<ExamUser> examUsers = efs.importExamUserByPoi(fis);
		for(ExamUser examUser : examUsers){
			System.out.println( examUser );
		}
		fis.close();
		//model.addAttribute("message", "Upload successfully.");
  
        return "redirect:/stuma/list";  
    }  
}
