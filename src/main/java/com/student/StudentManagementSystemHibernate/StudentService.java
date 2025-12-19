package com.student.StudentManagementSystemHibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentService {

	public void getAllStudents() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<Student> list = session.createQuery("from Student", Student.class).getResultList();

		for (Student s : list) {
			System.out.println(s.getId() + " " + s.getName() + " " + s.getBranch());
		}

		session.getTransaction().commit();
		session.close();
	}

	public void getTopNStudents(int n) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();

			String hql = "from Student s "
					+ "order by (s.marks.java + s.marks.python + s.marks.mysql + s.marks.js) desc";

			List<Student> list = session.createQuery(hql, Student.class).setMaxResults(n).getResultList();

			for (Student s : list) {
				Marks m = s.getMarks();
				int total = m.getJava() + m.getPython() + m.getMysql() + m.getJs();

				System.out.println(s.getId() + " " + s.getName() + " " + s.getBranch() + " Total=" + total);
			}

			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void sortByName() {

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			s.beginTransaction();

			List<Student> list = s.createQuery("from Student order by name asc", Student.class).getResultList();

			for (Student st : list) {
				System.out.println(st.getId() + " " + st.getName() + " " + st.getBranch());
			}

			s.getTransaction().commit();
		} finally {
			s.close();
		}
	}

	public void sortByMarksDesc() {

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			s.beginTransaction();

			String hql = "from Student s order by "
					+ "(s.marks.java + s.marks.python + s.marks.mysql + s.marks.js) desc";

			List<Student> list = s.createQuery(hql, Student.class).getResultList();

			for (Student st : list) {
				Marks m = st.getMarks();
				int tot = m.getJava() + m.getPython() + m.getMysql() + m.getJs();

				System.out.println(st.getId() + " " + st.getName() + " Total=" + tot);
			}

			s.getTransaction().commit();
		} finally {
			s.close();
		}
	}

	public void getStudentsByBranch() {

		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter branch: ");
			String br = sc.nextLine().toLowerCase(); // convert input to lowercase

			Session s = HibernateUtil.getSessionFactory().openSession();

			try {
				s.beginTransaction();

				List<Student> list = s.createQuery("from Student where lower(branch) = :b", Student.class)
						.setParameter("b", br).getResultList();

				if (list.isEmpty()) {
					System.out.println("No such branch found");
				} else {
					for (Student st : list) {
						System.out.println(st.getId() + " " + st.getName() + " " + st.getBranch());
					}
				}

				s.getTransaction().commit();

			} finally {
				s.close();
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertStudent() {

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter marks for java, python, mysql, js");
		int java = sc.nextInt();
		int python = sc.nextInt();
		int mysql = sc.nextInt();
		int js = sc.nextInt();

		Marks marks = new Marks(java, python, mysql, js);

		System.out.println("Enter student name and branch");
		sc.nextLine();
		String name = sc.nextLine();
		String branch = sc.nextLine();

		Student student = new Student(name, branch);
		student.setMarks(marks);

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		session.persist(student);

		tx.commit();
		session.close();
		sc.close();
	}

	public void deleteStudentById(int id) {

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			s.beginTransaction();

			Student st = s.get(Student.class, id);

			if (st != null) {
				s.delete(st); // deletes student + marks
				System.out.println("Student deleted successfully");
			} else {
				System.out.println("Student not found");
			}

			s.getTransaction().commit();

		} catch (Exception e) {
			s.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			s.close();
		}
	}

	public void updateMenu() {

		Scanner sc = new Scanner(System.in);

		System.out.println("1. Update Student Details");
		System.out.println("2. Update Marks");
		System.out.print("Enter choice: ");

		int up = sc.nextInt();

		switch (up) {

		case 1:
			updateStudentDetails();
			break;

		case 2:
			updateStudentMarks();
			break;

		default:
			System.out.println("Invalid update option");
		}
	}

	private void updateStudentDetails() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter student id: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter new name: ");
		String name = sc.nextLine();

		System.out.print("Enter new branch: ");
		String branch = sc.nextLine();

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			s.beginTransaction();

			Student st = s.get(Student.class, id);

			if (st != null) {
				st.setName(name);
				st.setBranch(branch);
				System.out.println("Student updated successfully");
			} else {
				System.out.println("Student not found");
			}

			s.getTransaction().commit();
		} finally {
			s.close();
		}
	}

	private void updateStudentMarks() {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter student id: ");
		int id = sc.nextInt();

		System.out.println("Enter new marks (java python mysql js):");
		int java = sc.nextInt();
		int python = sc.nextInt();
		int mysql = sc.nextInt();
		int js = sc.nextInt();

		Session s = HibernateUtil.getSessionFactory().openSession();

		try {
			s.beginTransaction();

			Student st = s.get(Student.class, id);

			if (st != null) {
				Marks m = st.getMarks();
				m.setJava(java);
				m.setPython(python);
				m.setMysql(mysql);
				m.setJs(js);
				System.out.println("Marks updated successfully");
			} else {
				System.out.println("Student not found");
			}

			s.getTransaction().commit();
		} finally {
			s.close();
		}
	}

}
