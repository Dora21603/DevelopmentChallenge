package com.oracle.devops.dropwizard.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FibonacciResponse {
    private int memberCount;

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public void setSequence(List sequence) {
        this.sequence = sequence;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private List sequence;
    private int total;

    public FibonacciResponse()
    {

    }
    public FibonacciResponse(int memberCount, List sequence, int total) {
        this.memberCount = memberCount;
        this.sequence = sequence;
        this.total = total;
    }

    @JsonProperty
    public int getMemberCount() {
        return memberCount;
    }

    @JsonProperty
    public List getSequence() {
        return sequence;
    }

    @JsonProperty
    public int getTotal() {
        return total;
    }

}