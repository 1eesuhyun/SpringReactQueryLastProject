package com.sist.web.commons;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// 공통 예외처리
public class ExceptionCommons {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex)
	{
		ex.printStackTrace();
	}
}
