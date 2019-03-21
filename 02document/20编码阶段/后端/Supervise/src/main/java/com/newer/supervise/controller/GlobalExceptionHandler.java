package com.newer.supervise.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.newer.supervise.pojo.ErrorInfo;





/**
 * 
 * 牛耳教育:全局的异常处理类<br>
 *
 * @author QuanLijian
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value = Exception.class)
	public ErrorInfo<String> error(HttpServletRequest req, Exception e) throws Exception {
		ErrorInfo<String> r = new ErrorInfo<>();
		r.setMessage(e.getMessage());
		r.setCode(ErrorInfo.ERROR);
		r.setData("错误!!");
		r.setUrl(req.getRequestURL().toString());
		return r;
	}
}
