package com.api.taylor.modules;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Module {
    public static java.sql.Date createDate(String date) {
        try {
            java.util.Date dt = new SimpleDateFormat("yyyy-MM-dd")
                    .parse(date);
            return new java.sql.Date(dt.getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
