package com.wuqw.stw1;

import com.wuqw.stw1.*;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminM {
	
	public static void adminOp() {
		
			ArrayList<Admin> list = new ArrayList<Admin>();
			System.out.println("请选择操作：");
	        System.out.println("------------------");
	        System.out.println("   1 登录         ");
	        System.out.println("   2 注册         ");
	        System.out.println("------------------");
	        System.out.println("请输入你的选择：");
	        Scanner sc = new Scanner(System.in);
	        String input = sc.nextLine();
	        switch (input) {
	            case "1":
	                login(list);
	                break;
	            case "2":
	                register(list);
	                break;
	        }
		
	}
	
	public static void login(ArrayList<Admin> list) {
		Scanner sc = new Scanner(System.in);
		System.out.println("用户名：");
        String id = sc.nextLine();
        System.out.println("密码：");
        String pwd = sc.nextLine();
		for (int i = 0; i < list.size(); i++) {
            Admin ad = list.get(i);
            if(ad.getId().equals(id)&&ad.getPwd().equals(pwd)) {
            	StudentManager sm = new StudentManager();
            	System.out.println("登录成功");
            	sm.app();
            }else {
            	System.out.println("用户名或密码错误，请重新输入");
            	login(list);
            }
		}
	}

	public static void register(ArrayList<Admin> list) {
		Scanner sc = new Scanner(System.in);
        System.out.println("用户名：");
        String id = sc.nextLine();
        System.out.println("密码：");
        String pwd = sc.nextLine();
        Admin ad = new Admin();
        ad.setId(id);
        ad.setPwd(pwd);
        list.add(ad);
        System.out.println("注册成功");
        System.out.println("可以登录啦：");
        login(list);
	}
}
