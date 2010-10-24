package com.dj.applite.core.http;

import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

/**
 * All http responses should be in a format Sencha can understand.
 */
@JsonAutoDetect
public class AppliteResponse<T> {
    private final boolean success;
    private final int totalResults;
    private final T model;

    public boolean isSuccess() {
	return success;
    }

    public int getTotalResults() {
	return totalResults;
    }

    public T getModel() {
	return model;
    }

    public static class ResponseBuilder<T> {
	private final boolean success;
	private int totalResults;
	private final T model;

	public ResponseBuilder(final boolean success, final T model) {
	    this.success = success;
	    this.model = model;
	}

	public ResponseBuilder<T> totalResults(final int totalResults) {
	    this.totalResults = totalResults;
	    return this;
	}

	private void validate() {
	    if (this.model instanceof List) {
		this.totalResults = ((List) this.model).size();
	    }
	}

	public AppliteResponse<T> build() {
	    this.validate();
	    return new AppliteResponse<T>(this);
	}

    }

    public AppliteResponse(final ResponseBuilder<T> responseBuilder) {
	this.success = responseBuilder.success;
	this.model = responseBuilder.model;
	this.totalResults = responseBuilder.totalResults;
    }

    @Override
    public String toString() {
	final StringBuilder sb = new StringBuilder();
	sb.append("WrappedResponse");
	sb.append("{success=").append(success);
	sb.append(", totalResults=").append(totalResults);
	sb.append(", model=").append(model);
	sb.append('}');
	return sb.toString();
    }

}
