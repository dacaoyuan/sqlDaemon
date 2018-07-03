package com.example.greendaodemo2.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @desc 对Sharedpreferences功能的封装
 */
public class SPUtil {
    public static final String SP_FILE_NAME = "config";

    /**
     * Boolean
     */
    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        //添加保存数据
        sp.edit().putBoolean(key, value).commit();

    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);

    }

    public static boolean removeBoolean(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.edit().remove(key).commit();

    }

    /**
     * Boolean
     */

    //把数据保存到指定的 fileName 文件中
    public static void putBoolean(Context context, String fileName, String key, boolean value) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        //添加保存数据
        sp.edit().putBoolean(key, value).commit();

    }

    //从指定的 fileName 文件中获取数据
    public static boolean getBoolean(Context context, String fileName, String key, boolean defValue) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);

    }

    public static boolean removeBoolean(Context context, String fileName, String key) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.edit().remove(key).commit();

    }


    /**
     * String
     */

    //把数据保存到指定的 fileName 文件中
    public static void putString(Context context, String fileName, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        //添加保存数据
        sp.edit().putString(key, value).commit();

    }

    //从指定的 fileName 文件中获取数据
    public static String getString(Context context, String fileName, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);

    }

    public static boolean removeString(Context context, String fileName, String key) {
        SharedPreferences sp = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.edit().remove(key).commit();

    }


    /**
     * String
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        //添加保存数据
        sp.edit().putString(key, value).commit();

    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);

    }

    public static boolean removeString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.edit().remove(key).commit();

    }

    /**
     * Int
     */
    public static void putInt(Context context, String key, int value) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        //添加保存数据
        sp.edit().putInt(key, value).commit();

    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);

    }

    public static boolean removeInt(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.edit().remove(key).commit();

    }


    /**
     * Long
     */
    public static void putLong(Context context, String key, long value) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        //添加保存数据
        sp.edit().putLong(key, value).commit();

    }

    public static long getLong(Context context, String key, Long defValue) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);

    }

    public static boolean removeLong(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SP_FILE_NAME, Context.MODE_PRIVATE);
        return sp.edit().remove(key).commit();

    }
}
