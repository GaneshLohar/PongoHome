package com.pongo.bo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Request implements Serializable {
	private String sessionToken;
	private Object data;
	private String time;

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}