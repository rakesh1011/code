package com.ust.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;


 @Data
@Entity
public class MyNumbers {
	@Id
	@GeneratedValue
	private int attempt;
	private int firstNumber;
	private int secondNumber;
	private int thirdNumber;
	private int fourNumber;
	private int fiveNumber;
	
	private int result;

//	public int getSecondNumber() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getThirdNumber() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getFourNumber() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getFirstNumber() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public int getFiveNumber() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	public static void setResult(int sum) {
//		// TODO Auto-generated method stub
//		
//	}
}
