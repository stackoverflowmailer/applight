package com.dj.applite.core.servlet;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

import com.dj.applite.core.http.AppliteResponse;

public class AppliteResponseDeserializer extends JsonDeserializer<AppliteResponse> {

    @Override
    public AppliteResponse deserialize(final JsonParser jp, final DeserializationContext ctxt)
	    throws IOException,
	    JsonProcessingException {

	return deserializeInternal(jp, ctxt);
    }

    private AppliteResponse deserializeInternal(final JsonParser jp, final DeserializationContext ctxt) {
	try {
	    String text = jp.getText();
	    System.out.println("Text : " + text);
	} catch (JsonParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	return null;
    }

}
