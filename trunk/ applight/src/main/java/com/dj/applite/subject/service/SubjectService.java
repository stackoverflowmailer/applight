package com.dj.applite.subject.service;

import com.dj.applite.subject.model.Subject;
import com.dj.applite.subject.model.SubjectGroup;

public interface SubjectService {

    /**
     * Get a subject for the provided id;
     * 
     * @param id
     *            the id of the subject
     * @return the Subject having the specified id.
     */
    public Subject getSubject(final Long id);

    /**
     * Get the group of the Subject.
     * 
     * @param id
     *            the id of the subject.
     * @return the SubjectGroup of the Subject having the specified id.
     */
    public SubjectGroup getSubjectGroup(final Long id);
}
