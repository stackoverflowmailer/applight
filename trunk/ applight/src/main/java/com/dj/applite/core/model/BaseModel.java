package com.dj.applite.core.model;

import java.io.Serializable;

/**
 * Superclass for all model objects.
 */
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

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
}
