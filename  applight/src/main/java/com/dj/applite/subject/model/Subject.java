package com.dj.applite.subject.model;

/**
 * @author Deepak Jacob
 */
public class Subject {
    private Long id;
    private String name;
    private SubjectGroup group;

    public Subject() {

    }

    public Subject(final Long id, final String name, final SubjectGroup group) {
	super();
	this.id = id;
	this.name = name;
	this.group = group;
    }

    public Long getId() {
	return id;
    }

    private void setId(final Long id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(final String name) {
	this.name = name;
    }

    public SubjectGroup getGroup() {
	return group;
    }

    public void setGroup(final SubjectGroup group) {
	this.group = group;
    }

}
