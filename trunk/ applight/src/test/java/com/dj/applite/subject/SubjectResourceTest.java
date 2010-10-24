package com.dj.applite.subject;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dj.applite.AbstractAppliteTest;
import com.dj.applite.core.http.AppliteResponse;
import com.dj.applite.subject.model.Subject;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class SubjectResourceTest extends AbstractAppliteTest {

    private static final String ID_TO_BE_TESTED = "100";

    private final Logger logger = LoggerFactory.getLogger(SubjectResourceTest.class);

    @Test
    public void testGetSubjectHavingTheId() throws Exception {
	logger.debug("About to test subjects having id...");
	GenericType<AppliteResponse<Subject>> genericType = new GenericType<AppliteResponse<Subject>>() {
	};
	WebResource wr = getWebResource();
	WebResource.Builder wrb = wr.path("subject").path("id").path(ID_TO_BE_TESTED).type(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON);
	AppliteResponse<Subject> subject = wrb.get(genericType);
	logger.debug("Resulting subject : {}", subject);
	String expectedSubjectName = "Mathematics Paper 1";
	assertTrue(expectedSubjectName.equals(subject.getModel().getName()));
    }
}
