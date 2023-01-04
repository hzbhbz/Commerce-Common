package com.digital.schema;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;

@ArraySchema
public class Address {

	@ApiModelProperty(required = false, position = 1, example = "2001", dataType = "long", notes = "주소ID")
	private long addressId;
	@ApiModelProperty(required = true, position = 2, example = "경기도 성남시", dataType = "string", notes = "주소상세")
	private String addressDetail;
	public long getAddressId() {
		return addressId;
	}
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

}
