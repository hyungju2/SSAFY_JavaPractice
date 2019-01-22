package com.exception;

import java.util.Scanner;

public class MemberTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력");
		String name = sc.next();
		MemberTest m = new MemberTest();
		try {
			m.findMemer(name);
			} catch (NoSuchMember e)
		{
				e.printStackTrace();
		} catch (Exception e2)
		{
			e2.printStackTrace();
		}
	}
private void findMemer(String names) throws NoSuchMember
{
	if(names.equals("tom")||names.equals("jane"))
		System.out.println("welecome");
	else {
		throw new NoSuchMember();
	}
}
	
}
