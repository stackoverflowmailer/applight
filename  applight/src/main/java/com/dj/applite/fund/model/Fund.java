package com.dj.applite.fund.model;

import com.dj.applite.core.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 */
public class Fund extends BaseModel {

    private Date startDate;
    private Date endDate;
    private String remarks;
    private BigDecimal minAmt;
    private BigDecimal maxAmt;
    private BigDecimal actAmt;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public BigDecimal getMinAmt() {
        return minAmt;
    }

    public void setMinAmt(BigDecimal minAmt) {
        this.minAmt = minAmt;
    }

    public BigDecimal getMaxAmt() {
        return maxAmt;
    }

    public void setMaxAmt(BigDecimal maxAmt) {
        this.maxAmt = maxAmt;
    }

    public BigDecimal getActAmt() {
        return actAmt;
    }

    public void setActAmt(BigDecimal actAmt) {
        this.actAmt = actAmt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Fund");
        sb.append("{startDate=").append(startDate);
        sb.append(", endDate=").append(endDate);
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append(", minAmt=").append(minAmt);
        sb.append(", maxAmt=").append(maxAmt);
        sb.append(", actAmt=").append(actAmt);
        sb.append('}');
        return sb.toString();
    }
}
