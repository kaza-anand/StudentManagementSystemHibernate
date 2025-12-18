package com.student.StudentManagementSystemHibernate;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();

		while (true) {

			System.out.println();
			
			System.out.println("\n----- MENU -----");
			System.out.println("1. Insert Student");
			System.out.println("2. Delete Student");
			System.out.println("3. Get All Students");
			System.out.println("4. Get Top N Students");
			System.out.println("5. Sort Students by Name");
			System.out.println("6. Sort Students by Marks");
			System.out.println("7. Get Students by Branch");
			System.out.println("Any other number → Exit");
			System.out.print("Enter choice: ");

			System.out.println();
			
			int ch = sc.nextInt();

			switch (ch) {

			case 1:
				service.insertStudent();
				break;

			case 2:
				System.out.print("Enter student id to delete: ");
				int id = sc.nextInt();
				service.deleteStudentById(id);
				break;

			case 3:
				service.getAllStudents();
				break;

			case 4:
				System.out.print("Enter N value: ");
				int n = sc.nextInt();
				service.getTopNStudents(n);
				break;

			case 5:
				service.sortByName();
				break;

			case 6:
				service.sortByMarksDesc();
				break;

			case 7:
				System.out.print("Enter branch: ");
				System.out.println("Available brances are CSE, ECE");
				service.getStudentsByBranch();
				break;

			default:
				HibernateUtil.getSessionFactory().close();
				sc.close();
				System.out.println("Application exited");
				return;
			}
		}
	}
}
