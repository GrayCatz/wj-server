package com.wj.demo.utils;

import java.text.SimpleDateFormat;

public class DateUtil {


    public static String formatNormal(Long time) {
        if (time == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sdf.format(time);
    }

}
