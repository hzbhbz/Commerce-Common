package com.digital.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.digital.schema.ErrorMsg;

public class ExceptionUtils {

	public static ResponseEntity<ErrorMsg> setException(ErrorMsg errors, int code, String msg,
			MultiValueMap<String, String> header) {

		errors.setErrorCode(code);
		errors.setErrorMsg(msg);

		return new ResponseEntity<ErrorMsg>(errors, header, HttpStatus.valueOf(code));

	}
	
}
