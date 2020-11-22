package com.intercop.fullstack.intercopapi.pojo;

public class ResponseGet {

    private Double average;

    private Double standardDeviation;

    public ResponseGet(Double average, Double standardDeviation) {
        this.average = average;
        this.standardDeviation = standardDeviation;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getStandardDeviation() {
        return standardDeviation;
    }

    public void setStandardDeviation(Double standardDeviation) {
        this.standardDeviation = standardDeviation;
    }
}