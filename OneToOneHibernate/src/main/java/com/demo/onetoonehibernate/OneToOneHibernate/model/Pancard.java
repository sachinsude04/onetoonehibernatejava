package com.demo.onetoonehibernate.OneToOneHibernate.model;
// Generated 20 Feb, 2018 10:14:12 AM by Hibernate Tools 5.2.8.Final

/**
 * Pancard generated by hbm2java
 */
public class Pancard implements java.io.Serializable {

	private Integer id;
	
	private String panNo;
	private Person person;
	public Pancard() {
	}

	public Pancard(Person person, String panNo) {
		this.person = person;
		this.panNo = panNo;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getPerson() {
		return this.person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getPanNo() {
		return this.panNo;
	}

	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

}
