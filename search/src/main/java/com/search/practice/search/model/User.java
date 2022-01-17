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
    @Field(type = FieldType.Integer, name = "PersonId")
    private Integer personId;

    @Field(type = FieldType.Text, name = "FirstName")
    private String firstName;

    @Field(type = FieldType.Text, name = "LastName")
    private String lastName;

    @Field(type = FieldType.Text, name = "JobName")
    private String jobName;

    @Field(type = FieldType.Text, name = "City")
    private String city;

    @Field(type = FieldType.Text, name = "State")
    private String state;

    @Field(type = FieldType.Text, name = "Email")
    private String email;

    @Field(type = FieldType.Text, name = "Country")
    private String country;

    @Field(type = FieldType.Text, name = "Company")
    private String company;
}