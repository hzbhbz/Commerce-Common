package com.digital.schema;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;

@ArraySchema
public class Phone {

	@ApiModelProperty(required = false, position = 1, example = "2001", dataType = "long", notes = "전화번호ID")
	private long phoneId;
	@ApiModelProperty(required = true, position = 2, example = "010-3192-0379", dataType = "string", notes = "전화번호 상세")
	private String phoneNumber;

	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
