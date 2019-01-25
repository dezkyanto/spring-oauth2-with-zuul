package com.example.eurekaclient.entities;

public class Image {
	private String name;
	private String author;
	private String src;
	
	public Image(String name, String author, String src){
		this.name = name;
		this.author = author;
		this.src = src;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setAuthor(String author){
		this.author = author;
	}
	
	public void setSrc(String src){
		this.src = src;
	}
	
	public String getName(){
		return name;
	}
	
	public String getAuthor(){
		return author;
	}
	
	public String getSrc(){
		return src;
	}
}
