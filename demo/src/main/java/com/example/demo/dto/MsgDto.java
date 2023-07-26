package com.example.demo.dto;

import lombok.Getter;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MsgDto {
    private String msg;
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
