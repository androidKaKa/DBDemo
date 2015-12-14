package com.example.dbdemo;

public class Data {

	private String dataOne="";
	private String dataTwo="";
	private String dataThree="";
	
	public Data(String dataOne,String dataTwo,String dataThree)
	{
		this.dataOne=dataOne;
		this.dataTwo=dataTwo;
		this.dataThree=dataThree;
		
	}
	public String getDataOne() {
		return dataOne;
	}
	public void setDataOne(String dataOne) {
		this.dataOne = dataOne;
	}
	public String getDataTwo() {
		return dataTwo;
	}
	public void setDataTwo(String dataTwo) {
		this.dataTwo = dataTwo;
	}
	public String getDataThree() {
		return dataThree;
	}
	public void setDataThree(String dataThree) {
		this.dataThree = dataThree;
	}
	
	
}
