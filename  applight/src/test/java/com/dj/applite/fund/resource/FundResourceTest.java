package com.dj.applite.fund.resource;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dj.applite.AbstractAppliteTest;
import com.dj.applite.core.http.AppliteResponse;
import com.dj.applite.fund.model.Fund;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

/**
 * Imitating the REST calls for the FundResource class.
 * 
 * @author Deepak Jacob
 */
public class FundResourceTest extends AbstractAppliteTest {

    private static final String YEAR_TO_BE_TESTED = "2010";

    private final Logger logger = LoggerFactory.getLogger(FundResourceTest.class);

    @Test
    public void testGetFundsForTheYear() throws Exception {
	logger.debug("About to test funds for the year...");
	GenericType<AppliteResponse<List<Fund>>> genericType = new GenericType<AppliteResponse<List<Fund>>>() {
	};
	WebResource wr = getWebResource();
	WebResource.Builder wrb = wr.path("fund").path("year").path(YEAR_TO_BE_TESTED).type(MediaType.APPLICATION_JSON)
	        .accept(MediaType.APPLICATION_JSON);
	AppliteResponse<List<Fund>> fund = wrb.get(genericType);
	logger.debug("Resulting fund : {}", fund);
	String expectedRemarks = "For Misc. expenses";
	// assertTrue(expectedRemarks.equals(fund.getModel().get(0).getRemarks()));
    }

}
