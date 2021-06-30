package com.hotel.bean;

public enum Gender {
	MALE(0),FEMALE(1),NONIDENTIFIED(2);
	
	private int code;
	
	Gender(int code){
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}

}
