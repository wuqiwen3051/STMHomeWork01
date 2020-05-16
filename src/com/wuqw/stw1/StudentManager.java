package com.wuqw.stw1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//CHECK : 2.1
/**
 * 
 * @author wuqiwen
 *
 */
public class StudentManager {
	    /**
	     * 
	     * @param list
	     */
	   	public static void deleteStudent(ArrayList<Student> list) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入你要删除信息的学生姓名：");
	        String name = sc.nextLine();
	        int index = -1;
	        //CHECK : 6.1 
	        if (list != null) {
		        for (int x = 0; x < list.size(); x++) {
		            Student s = list.get(x);
		            if (s.getName().equals(name)) {
		                index = x;
		                break;
		            }
		        }
		        if (index == -1) {
		            System.out.println("你要删除的学生信息不存在！");
		        } else {
		            list.remove(index);
		            System.out.println("删除成功");
		        }
	        }
	    }
	    /**
	     * 
	     * @param list
	     */
	    public static void addStudent(ArrayList<Student> list) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入学生学号：");
            String id = sc.nextLine();
	        System.out.println("请输入学生姓名：");
	        String name = sc.nextLine();
	        System.out.println("请输入学生生日：");
	        String birDate = sc.nextLine();
	        System.out.println("请输入学生性别：");
	        String gender1 = sc.nextLine();
	        Boolean gender;
//			CHECK : 3.5, 4.2 	
//	        if(gender1.equals("男"))
//	        	gender = true;
//	        else
//	        	gender = false;       
	        if (gender1.equals("男")) {
	        	gender = true;
	        } else {
	        	gender = false;
	        }
	        Student s = new Student();
	        s.setId(Integer.parseInt(id));
	        s.setName(name);
	        s.setBirDate(birDate);
	        s.setGender(gender);
	        list.add(s);
	        System.out.println("添加成功");
	    }
	    /**
	     * 
	     * @param list
	     */
	    public static void findStudent(ArrayList<Student> list) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入查找的学生的姓名：");
	        String name = sc.nextLine();
	        int index = -1;
	        for (int x = 0; x < list.size(); x++) {
	            Student s = list.get(x);
	            if (s.getName().equals(name)) {
	                index = x;
	                String gender1;
//	    			CHECK : 3.5, 4.2 	
//		            if(s.getGender())
//		            	gender1 = "男";
//		            else
//		            	gender1 = "女";
		            if (s.getGender()) {
		            	gender1 = "男";
		            } else {
		            	gender1 = "女";
		            }
		            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getBirDate() + "\t" + gender1 );
	                break; 
	            }
	        }
	        if (index == -1) {
	            System.out.println("学生信息不存在！");
	        }
	    }
	    /**
	     * 
	     * @param list
	     */
	    private static void orderById(ArrayList<Student> list ) {
	        if (list.size() <= 0) {
	            System.out.println("没有学生信息，请添加!");
	            return;
	        }
	        Collections.sort(list, new Comparator<Student>() {

	            public int compare(Student s1, Student s2) {
	                int id1 = s1.getId();
	                int id2 = s2.getId();
	                Integer result = id1 > id2 ? 1 : id1 < id2 ? -1 : 0;
	                return result;
	            }
	        });
	        System.out.println("学号\t姓名\t生日\t\t性别 ");
	        for (int i = 0; i < list.size(); i++) {
	            Student s = list.get(i);
	            String gender1;
	            if(s.getGender()==true)
	            	gender1 = "男";
	            else
	            	gender1 = "女";
	            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getBirDate() + "\t" + gender1 );
	        }
	    }
	    /**
	     * 
	     */
	    public static void app() {
	        ArrayList<Student> list = new ArrayList<Student>();
	        while (true) {
	            System.out.println("请选择操作：");
	            System.out.println("**********************");
	            System.out.println("*       1 添加                    *");
	            System.out.println("*       2 删除                    *");
	            System.out.println("*       3 修改                    *");
	            System.out.println("*       4 查找                    *");
	            System.out.println("*       5 输出                    *");
	            System.out.println("*       6 退出                    *");
	            System.out.println("**********************");
	            System.out.println("请输入你的选择：");
	            Scanner sc = new Scanner(System.in);
	            String input = sc.nextLine();
	            switch (input) {
	                case "1":
	                    addStudent(list);
	                    break;
	                case "2":
	                    deleteStudent(list);
	                    break;
	                case "3":
	                    updateStudent(list);
	                    break;
	                case "4":
	                    findStudent(list);
	                    break;
	                case "5":
	                    orderById(list);
	                    break;
	                case "6":
	                     System.out.println("谢谢使用，再见！");
		                 System.exit(0); 
	                     break;
	                default:
	                    System.out.println("按键错误，请重新输入！");
	                    break;
	            }
	        }
	    }
	    /**
	     * 
	     * @param list
	     */
	    public static void updateStudent(ArrayList<Student> list) {
	        Scanner sc = new Scanner(System.in);
	        System.out.println("请输入你要修改的学生的姓名：");
	        String name = sc.nextLine();
	        int index = -1;
	        for (int x = 0; x < list.size(); x++) {
	            Student s = list.get(x);
	            if (s.getName().equals(name)) {
	                index = x;
	                break;
	            }
	        }
	        if (index == -1) {
	            System.out.println("你要修改的学生信息不存在！");
	        }
	        else {
	            System.out.println("请输入学生新学号：");
	            String id = sc.nextLine();
	            System.out.println("请输入学生新生日：");
	            String birDate = sc.nextLine();
	            System.out.println("请输入学生新性别：");
	            String gender1 = sc.nextLine();
		        Boolean gender;
//				CHECK : 3.5, 4.2 	
//		        if(gender1.equals("男"))
//		        	gender = true;
//		        else
//		        	gender = false;	
		        if (gender1.equals("男")) {
		        	gender = true;
		        } else {
		        	gender = false;
		        }
	            Student s = new Student();
	            s.setId(Integer.parseInt(id));
		        s.setName(name);
		        s.setBirDate(birDate);
		        s.setGender(gender);
	            list.set(index, s);
	            System.out.println("修改成功");
	        }
	    }

}
