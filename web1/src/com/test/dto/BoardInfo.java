package com.test.dto;

public class BoardInfo {
	private int bINum;
	private String bITitle;
	private String bIContent;
	private String bIPwd;
	private String creUsr;
	private String creDat;
	
	public int getBINum(){
		return bINum;
	}
	public void setBINum(int bINum){
		this.bINum = bINum;
	}
	public String getBITitle(){
		return bITitle;
	}
	public void setBITitle(String bITitle){
		this.bITitle = bITitle;
	}
	public String getBIContent(){
		return bIContent;
	}
	public void setBIContent(String bIContent){
		this.bIContent = bIContent;
	}
	public String getBIPwd(){
		return bIPwd;
	}
	public void setBIPwd(String bIPwd){
		this.bIPwd = bIPwd;
	}
	public String getCreUsr(){
		return creUsr;
	}
	public void setCreUsr(String creUsr){
		this.creUsr = creUsr;
	}
	public String getCreDat(){
		return creDat;
	}
	public void setCreDat(String creDat){
		this.creDat = creDat;
	}
}
