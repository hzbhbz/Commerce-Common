package com.digital.schema;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SuccessMsg {
	
	@ApiModelProperty(required = true, position = 1, example = "1", dataType = "long", notes = "코드")
	private long successCode;
	
	@ApiModelProperty(required = true, position = 2, example = "성공 메세지", dataType = "string")
	private String successMsg;

	public long getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(long successCode) {
		this.successCode = successCode;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
	
	
}