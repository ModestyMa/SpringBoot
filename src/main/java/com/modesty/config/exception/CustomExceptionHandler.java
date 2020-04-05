package com.modesty.config.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

/**
* @author Modesty
* @Version 2020年4月4日 下午5:03:56
*/

@ControllerAdvice
public class CustomExceptionHandler {
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public void uploadException(MaxUploadSizeExceededException e,HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.write("上传文件大小超过限制");
		out.flush();
		out.close();
	}
}


/**
* Notes
*/
