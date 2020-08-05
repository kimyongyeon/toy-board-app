package com.project.toyboardapp.biz.customer;

import lombok.Getter;

import java.util.Random;

@Getter
public enum Member_Level_Enum {
    GUEST, ADMIN, USER;

    public static Member_Level_Enum getCustomer_Level_Enum() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

    private String value;
}
