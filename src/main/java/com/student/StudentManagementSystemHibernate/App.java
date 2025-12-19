package com.student.StudentManagementSystemHibernate;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentService service = new StudentService();

		while (true) {

			System.out.println("\n----- MENU -----");
			System.out.println("1. Insert Student"); // CREATE
			System.out.println("2. Get All Students"); // READ
			System.out.println("3. Get Top N Students"); // READ
			System.out.println("4. Sort Students by Name"); // READ
			System.out.println("5. Sort Students by Marks"); // READ
			System.out.println("6. Get Students by Branch"); // READ
			System.out.println("7. Update Student / Marks"); // UPDATE
			System.out.println("8. Delete Student"); // DELETE
			System.out.println("Any other number → Exit");

			System.out.print("Enter choice: ");
			int ch = sc.nextInt();

			switch (ch) {

			case 1: // CREATE
				service.insertStudent();
				break;

			case 2: // READ
				service.getAllStudents();
				break;

			case 3: // READ
				System.out.print("Enter N value: ");
				int n = sc.nextInt();
				service.getTopNStudents(n);
				break;

			case 4: // READ
				service.sortByName();
				break;

			case 5: // READ
				service.sortByMarksDesc();
				break;

			case 6: // READ
				System.out.println("Available branches are CSE, ECE");
				service.getStudentsByBranch();
				break;

			case 7: // UPDATE
				service.updateMenu();
				break;

			case 8: // DELETE
				System.out.print("Enter student id to delete: ");
				int id = sc.nextInt();
				service.deleteStudentById(id);
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
