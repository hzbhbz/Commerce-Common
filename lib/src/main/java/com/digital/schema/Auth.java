package com.digital.schema;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;

@ArraySchema
public class Auth {
	
	@ApiModelProperty(required = false, position = 1, notes = "토큰검증", example = "true", dataType = "boolean")
	private boolean isValidToken;
	@ApiModelProperty(required = false, position = 2, notes = "토큰유효시간검증", example = "true", dataType = "boolean")
	private boolean isExpiredToken;
	@ApiModelProperty(required = false, position = 3, notes = "토큰정보", example = "토큰", dataType = "string")
	private String token;
	@ApiModelProperty(required = false, position = 3, notes = "사용자 ID 정보", example = "12345678", dataType = "long")
	private long personId;
	
	public boolean isValidToken() {
		return isValidToken;
	}
	public void setValidToken(boolean isValidToken) {
		this.isValidToken = isValidToken;
	}
	public boolean isExpiredToken() {
		return isExpiredToken;
	}
	public void setExpiredToken(boolean isExpiredToken) {
		this.isExpiredToken = isExpiredToken;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
}
