package com.gym.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;
	
	
	public String save(MultipartFile multipartFile, String path)throws Exception{
		
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		File file = new File(realPath);
		
		if(!file.exists()) {
			//file.mkdir(); //중간 폴더가 없으면 에러
			file.mkdirs(); //중간폴더가 없으면 중간폴더도 생성해줌,그래서 더 안전함
			
		}
		//1. 시간
//		Calendar ca = Calendar.getInstance();
//		long l = ca.getTimeInMillis(); //현재시간을 밀리세컨으로 변환, 중복될일 X
//		System.out.println("time : "+l);
//		String oriName= multipartFile.getOriginalFilename(); //iu.jfif가 나올것 파일명
//		String fileName = l +"_"+oriName;
//		System.out.println("fileName : "+fileName);
		
		//2. UUID   이름 만들어주는 얘
		String oriName= multipartFile.getOriginalFilename(); //iu.jfif가 나올것 파일명
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+oriName;
		System.out.println("UUID : " +fileName);
		

				
		//2. FileCopyUtils   저장하는 얘 HDD에
		file = new File(file,fileName);
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		
		return fileName;
		
	}
}
