package com.dj.applite.subject.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.dj.applite.core.http.AppliteResponse;
import com.dj.applite.subject.model.Subject;
import com.dj.applite.subject.model.SubjectGroup;

@Path("/subject")
public class SubjectResource {
    public SubjectResource() {

    }

    @Path("/id/{subjectId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public AppliteResponse<Subject> getSubject(@PathParam("subjectId") final String subjectId) {
	Subject subject = new Subject(100L, "Mathematics Paper 1", SubjectGroup.SCIENCE);
	AppliteResponse<Subject> response = new AppliteResponse.ResponseBuilder(true, subject).build();
	return response;
    }
}
