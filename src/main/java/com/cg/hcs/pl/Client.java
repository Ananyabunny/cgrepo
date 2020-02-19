package com.cg.hcs.pl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.hcs.bean.Test;
import com.cg.hcs.exception.HealthException;
import com.cg.hcs.service.HealthService;
import com.cg.hcs.service.HealthServiceImpl;

public class Client {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		HealthService healthservice=new HealthServiceImpl();
		int choice=0;
		Test test=new Test();
		//List<Test> list = new ArrayList<Test>();
		ArrayList<Test>listofTests =new ArrayList<Test>();
		while(choice!=4)
		{
		System.out.println("1.Add Center");
		System.out.println("2.Remove Center");
		System.out.println("3.Add Test");
		System.out.println("4.Remove Test");
		System.out.println("Enter choice");
		choice = scanner.nextInt();
		switch(choice)
		{
		case 3:
		System.out.println("Select center name");
		scanner.nextLine();
		System.out.println(listofTests);
		String TestId=scanner.nextLine();
		System.out.println("Enter test name");
		test.setTestName(TestId);
		try {
		String sid= healthservice.addTest(test);
		System.out.println("Test Id = "+sid);
		}
		catch (HealthException e) {
		System.err.println(e.getMessage());
		}
		break;
		case 4:
		System.out.println("Enter Employee Id");
		scanner.nextLine();
		TestId=scanner.nextLine();
		test.setTestName(TestId);
		try {
		boolean sid= healthservice.removeTest(test);
		System.out.println("Test Id = "+sid);
		}
		catch (HealthException e) {
		System.err.println(e.getMessage());
		}
		return;  
		}
		}
		}
	}


