package com.modesty.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
* @author Modesty
* @Version 2020年4月4日 下午4:34:18
*/

@RestController
@Api("文件上传测试程序")
public class FileUploadController {
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
	
	@PostMapping("/upload")
	@ApiOperation(value = "测试文件上传",notes="测试单文件上传")
	public String upload(MultipartFile uploadFile,HttpServletRequest req) {
		String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
		String format = sdf.format(new Date());
		File folder = new File(realPath + format);
		if(!folder.isDirectory())	folder.mkdirs();
		String oldName = uploadFile.getOriginalFilename();
		String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
		
		try {
			uploadFile.transferTo(new File(folder,newName));
			String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
			return filePath;
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		return "上传失败";
	}
	
	@PostMapping("/uploads")
	@ApiOperation(value = "测试文件上传",notes="测试多文件上传")
	public String uploads(MultipartFile[] uploadFile,HttpServletRequest req) {
		String filePaths = "";
		
		for (int i = 0; i < uploadFile.length; i++) {
			String realPath = req.getSession().getServletContext().getRealPath("/uploadFile/");
			String format = sdf.format(new Date());
			File folder = new File(realPath + format);
			if(!folder.isDirectory())	folder.mkdirs();
			String oldName = uploadFile[i].getOriginalFilename();
			String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."),oldName.length());
			
			try {
				uploadFile[i].transferTo(new File(folder,newName));
				String filePath = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + "/uploadFile/" + format + newName;
				filePaths += filePath + "\n";
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
				return "上传失败";
			}
		}
		return filePaths;
	}
}


/**
* Notes
*/
