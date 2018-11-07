package com.example.greendaodemo2.utils;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mac on 16/3/21.
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String strParam) {
        if (strParam == null || strParam.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    public static boolean emailFormat(String emailString) {//邮箱判断正则表达式
        Pattern pattern = Pattern
                .compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher mc = pattern.matcher(emailString);
        return mc.matches();
    }


    public static boolean mobileFormat(String mobileString) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9])|(14[5,7])|(17[0-9])|(147))\\d{8}$");
        Matcher m = p.matcher(mobileString);
        return m.matches();
    }

    /**
     * 验证密码
     */
    public static final boolean isRightPwd(String pwd) {
        Pattern p = Pattern.compile("^(?![^a-zA-Z]+$)(?!\\D+$)[0-9a-zA-Z]{6,16}$");
        Matcher m = p.matcher(pwd);
        return m.matches();
    }

    /**
     * 判断邮编
     */
    public static boolean isZipNO(String zipString) {
        String str = "^[1-9][0-9]{5}$";
        return Pattern.compile(str).matcher(zipString).matches();
    }

    //生成32位的唯一值，用来做主键 例如：9fb5c2ef-2248-4940-9262-d50b2680cb0f
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String uuidStr = uuid.toString();
        System.out.println("StringUtils.getUUID uuidStr="+uuidStr);
        return uuidStr;

    }
}
