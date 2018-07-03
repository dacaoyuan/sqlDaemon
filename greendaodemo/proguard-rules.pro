# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in D:\studio_sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# greendao3.2.0,此是针对3.2.0，如果是之前的，可能需要更换下包名
# 如果不添加该混淆，在debug模式下，app不会报错,
# 但是打包后，会报类似于如下错误（导致app闪退）：Caused by: org.greenrobot.greendao.DaoException: Could not init DAOConfig...
-keep class org.greenrobot.greendao.**{*;}
-keepclassmembers class * extends org.greenrobot.greendao.AbstractDao {
public static java.lang.String TABLENAME;
}
-keep class **$Properties