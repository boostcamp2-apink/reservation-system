package org.apink.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaverUser extends User{


	public NaverUser() {
		super.setSnsType("naver");
	}

	@JsonProperty("profile_image")
	public void setSnsProfile(String image) {
		super.setSnsProfile(image);
	}
	@JsonProperty("name")
	public void setUserName(String name) {
		super.setUsername(name);
	}

	@JsonProperty("id")
	public void setSnsId(int snsId) {
		super.setSnsId(snsId);
	}


}
