package com.dj.applite.fund.service;


import com.dj.applite.fund.model.Fund;
import com.dj.applite.fund.service.impl.FundServiceImpl;
import com.google.inject.ImplementedBy;

import java.util.List;

/**
 * Service for managing fund related services.
 *
 * @author Deepak Jacob
 */
@ImplementedBy(FundServiceImpl.class)
public interface FundService {

    
    /**
     * Gets details of fund collection of a specific year.
     *
     * @param year the year for which the collection is made.
     * @return details of fund collection.
     */
     public List<Fund> getFundsForTheYear(int year);
}
