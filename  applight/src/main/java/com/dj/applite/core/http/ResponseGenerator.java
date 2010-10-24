package com.dj.applite.core.http;


/**
 * Factory class for generating WrappedResponse instances.
 * 
 * @author Deepak Jacob
 */
public class ResponseGenerator {
    /**
     * Generate and return wrapped response according to the types passed.
     * <p/>
     * Note that if a <quote>java.util.List</quote> is passed, the totalResults
     * property will be automatically set.
     * 
     * @param t
     *            the model entity that needs to be converted to the
     *            <quote>WrappedResponse</quote> instance.
     * @param <T>
     *            the type, the WrappedEntity holds.
     * @return WrappedResponse instance for the passed model.
     */
    /*
     * public static <T> AppliteResponse<T> getResponse(final T t) {
     * AppliteResponse<T> wr = new AppliteResponse<T>(); if (t instanceof List)
     * {
     * @SuppressWarnings("rawtypes") List list = (List) t;
     * wr.setTotalResults(list.size()); } wr.setModel(t); wr.setSuccess(true);
     * return wr; }
     */
}
