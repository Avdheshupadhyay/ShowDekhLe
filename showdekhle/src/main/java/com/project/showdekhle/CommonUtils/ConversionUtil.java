package com.project.showdekhle.CommonUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ConversionUtil {
    public static String getStringValue(Object inputVal){
        if(inputVal==null){
            return"";
        }else{
            return inputVal.toString();
        }
    }
    public static String getCurrentDateAndTime(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        String formatted = now.format(formatter);
        return formatted;
    }

}
