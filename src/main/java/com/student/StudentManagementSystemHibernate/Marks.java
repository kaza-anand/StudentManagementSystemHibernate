package com.student.StudentManagementSystemHibernate;

import javax.persistence.*;

@Entity
@Table(name = "studentMarks")
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "marks_id")
	private int id;

	@Column(name = "java")
	private int java;

	@Column(name = "python")
	private int python;

	@Column(name = "mysql")
	private int mysql;

	@Column(name = "js")
	private int js;

	public Marks() {
	}

	public Marks(int java, int python, int mysql, int js) {
		this.java = java;
		this.python = python;
		this.mysql = mysql;
		this.js = js;
	}

	public int getId() {
		return id;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getPython() {
		return python;
	}

	@Override
	public String toString() {
		return "id=" + id + ", java=" + java + ", python=" + python + ", mysql=" + mysql + ", js=" + js;
	}

	public void setPython(int python) {
		this.python = python;
	}

	public int getMysql() {
		return mysql;
	}

	public void setMysql(int mysql) {
		this.mysql = mysql;
	}

	public int getJs() {
		return js;
	}

	public void setJs(int js) {
		this.js = js;
	}

}
