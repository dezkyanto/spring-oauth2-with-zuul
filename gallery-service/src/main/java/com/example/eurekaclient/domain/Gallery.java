package com.example.eurekaclient.domain;

import java.util.List;

public class Gallery {
	private int id;
	private List images;

	public Gallery(int id){
		this.id = id;
	}

	public Gallery(){

	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getImages() {
		return images;
	}

	public void setImages(List images) {
		this.images = images;
	}
}
