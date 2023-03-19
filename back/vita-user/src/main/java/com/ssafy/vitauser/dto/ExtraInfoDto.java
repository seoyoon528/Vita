package com.ssafy.vitauser.dto;

import lombok.Data;

@Data
public class ExtraInfoDto {
    private String nickname;
    private int age;
    private String gender;
    private float height;
    private float weight;
    private String phoneType;

    public ExtraInfoDto(String nickname, int age, String gender, float height, float weight, String phoneType) {
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.phoneType = phoneType;
    }
}