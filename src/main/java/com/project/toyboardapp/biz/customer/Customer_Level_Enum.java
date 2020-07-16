package com.project.toyboardapp.biz.customer;

import java.util.Random;

public enum Customer_Level_Enum {
    GUEST, ADMIN, USER;

    public static Customer_Level_Enum getCustomer_Level_Enum() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
