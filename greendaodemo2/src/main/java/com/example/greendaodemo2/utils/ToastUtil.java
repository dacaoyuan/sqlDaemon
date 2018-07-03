package com.example.greendaodemo2.utils;

import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.greendaodemo2.MyApplication;


/**
 * toast显示类，可以在子线程直接调用
 * 封装的Toast类
 */
public class ToastUtil {
    private static Toast toast;

    public static Handler mHandler = new Handler(Looper.getMainLooper());

    public static void showToast(String text) {
        showToast(text, Toast.LENGTH_LONG);
    }

    public static void showToast(final String text, final int duration) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            show(text, duration);
        } else {
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    show(text, duration);
                }
            });
        }
    }

    public static void show(String text) {
        show(text, Toast.LENGTH_LONG);
    }

    public static void show(String text, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(MyApplication.mContext, text, duration);
        toast.show();
    }

}
