package com.exception;

public class NoSuchMember extends Exception{

	NoSuchMember()
	{
		System.out.println("검색하는 사람이 없습니다!");
	}
	
}
