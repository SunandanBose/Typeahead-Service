package com.search.practice.search.model;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    List<String> country = new ArrayList<>();
    List<String> jobName = new ArrayList<>();
    List<String> city = new ArrayList<>();

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getJobName() {
        return jobName;
    }

    public void setJobName(List<String> jobName) {
        this.jobName = jobName;
    }

    public List<String> getCity() {
        return city;
    }

    public void setCity(List<String> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Filter{" +
                "country=" + country +
                ", jobName=" + jobName +
                ", city=" + city +
                '}';
    }
}
