package com.dj.applite.fund.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.dj.applite.fund.model.Fund;
import com.dj.applite.fund.service.FundService;
import com.google.common.collect.Lists;

public class FundServiceImpl implements FundService {
    @Override
    public List<Fund> getFundsForTheYear(final int year) {
	return populateFunds(year);
    }

    private List<Fund> populateFunds(final int year) {
	List<Fund> fundList = Lists.newArrayList();
	Fund fund = new Fund();
	fund.setName("GreatCollectionFunds");
	fund.setStartDate(new Date());
	fund.setEndDate(new Date());
	fund.setMinAmt(new BigDecimal("10"));
	fund.setMinAmt(new BigDecimal("100"));
	fund.setRemarks("For Misc. expenses");
	fundList.add(fund);
	return fundList;
    }
}
