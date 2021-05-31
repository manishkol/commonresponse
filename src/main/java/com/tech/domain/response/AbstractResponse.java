package com.tech.domain.response;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tech.model.CommonResponseModel;

public abstract class AbstractResponse {

	public static <T> ResponseEntity<CommonResponseModel<T>> successResponse(T data) {
		CommonResponseModel<T> model = new CommonResponseModel<T>();
		model.setData(data);
		model.setMessage("Succcesssssss");
		model.setResponseCode(HttpStatus.OK.toString());
		model.setStatus(Boolean.TRUE);
		return new ResponseEntity<CommonResponseModel<T>>(model, HttpStatus.OK);
	}

	public static <T> ResponseEntity<CommonResponseModel<T>> successResponse(T data, HttpHeaders headers) {
		CommonResponseModel<T> model = new CommonResponseModel<T>();
		model.setData(data);
		model.setMessage("Succcesssssss");
		model.setResponseCode(HttpStatus.OK.toString());
		model.setStatus(Boolean.TRUE);
		return new ResponseEntity<CommonResponseModel<T>>(model, headers, HttpStatus.OK);
	}
}
