package com.search.practice.search.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "employee")
@Setting(settingPath = "/setting/setting.json")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private Integer personId;

    @Field(type = FieldType.Integer, name = "AssignmentId")
    private Integer assignmentId;

    @Field(type = FieldType.Text, name = "DisplayName")
    private String displayName;

    @Field(type = FieldType.Text, name = "AssignmentName")
    private String assignmentName;

    @Field(type = FieldType.Text, name = "JobName")
    private String jobName;

    @Field(type = FieldType.Text, name = "City")
    private String city;

    @Field(type = FieldType.Text, name = "Email")
    private String email;

    @Field(type = FieldType.Text, name = "CountryCode")
    private String countryCode;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(Integer assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "personId=" + personId +
                ", assignmentId=" + assignmentId +
                ", displayName='" + displayName + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", city='" + city + '\'' +
                ", email='" + email + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}