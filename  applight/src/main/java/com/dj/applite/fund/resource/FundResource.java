package com.dj.applite.fund.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dj.applite.core.http.AppliteResponse;
import com.dj.applite.core.http.ResponseGenerator;
import com.dj.applite.fund.model.Fund;
import com.dj.applite.fund.service.FundService;
import com.google.inject.Inject;

/**
 * REST resource for managing fund relates resources.
 * 
 * @author Deepak Jacob
 */
@Path("/fund")
public class FundResource {

    private static Logger logger = LoggerFactory.getLogger(FundResource.class);

    private final FundService fundService;

    @Inject
    public FundResource(final FundService fundService) {
	logger.debug("Inside c'ntr FundResource : {}", fundService.toString());
	this.fundService = fundService;
    }

    @GET
    @Path("/year/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public AppliteResponse<List<Fund>> getFundsForTheYear(@PathParam("year") final String year) {
	validate(year);

	// List<Fund> fundList = new ArrayList<Fund>();
	List<Fund> fundList =
	        fundService.getFundsForTheYear(Integer.valueOf(year));
	return ResponseGenerator.getResponse(fundList);
    }

    private void validate(final String year) {
	Integer integer = Integer.valueOf(year);
    }

}
