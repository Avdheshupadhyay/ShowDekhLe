package com.project.showdekhle.CommonUtils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse <T>{
    private String messege;
    private int status;
    private T data;
    public ApiResponse(String messege, int status, T data){
        this.messege=messege;
        this.status=status;
        this.data=data;
    }
}
