package com.udr013.resources.beans;

import javax.ws.rs.QueryParam;

public class MessageFilterBean {

	@QueryParam("year") private int year;
	@QueryParam("size") private int size;
	@QueryParam("index") private int index;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
