package com.student.StudentManagementSystemHibernate;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "stu_name", nullable = false)
    private String name;

    @Column(name = "stu_branch", nullable = false)
    private String branch;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marks_id")
    Marks marks;

    public Student(int id, String name, String branch, Marks marks) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", branch=" + branch + ", marks=" + marks;
	}

	public Marks getMarks() {
		return marks;
	}

	public Student(String name, Marks marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public void setMarks(Marks marks_id) {
		this.marks = marks_id;
	}

	public Student() {
    }

    public Student(String name, String branch) {
        this.name = name;
        this.branch = branch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
