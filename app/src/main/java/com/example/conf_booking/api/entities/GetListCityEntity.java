package com.example.conf_booking.api.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetListCityEntity {

    @SerializedName("count")
    private Integer count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private Object previous;

    @SerializedName("results")
    private List<GetListCityEntity> results = null;

    public GetListCityEntity(){}

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrevious() {
        return previous;
    }

    public void setPrevious(Object previous) {
        this.previous = previous;
    }

    public List<GetListCityEntity> getResults() {
        return results;
    }

    public void setResults(List<GetListCityEntity> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "GetListCityEntity{" +
                "count=" + count +
                ", next='" + next + '\'' +
                ", previous=" + previous +
                ", results=" + results +
                '}';
    }
}

