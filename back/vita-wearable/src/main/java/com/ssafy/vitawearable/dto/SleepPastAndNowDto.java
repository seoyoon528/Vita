package com.ssafy.vitawearable.dto;

import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.time.LocalTime;

@Getter
@Setter
// 최근 export일 기준으로 해당 주와 저번 주, 해당 달과 저번 달, 해당 연도와 저번 연도 평균 Dto
public class SleepPastAndNowDto {
    private LocalTime weekNowWearableSleep;
    private LocalTime weekPastWearableSleep;
    private LocalTime monthNowWearableSleep;
    private LocalTime monthPastWearableSleep;
    private LocalTime yearNowWearableSleep;
    private LocalTime yearPastWearableSleep;
}
