package com.zx.weather.util.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/21 10:30
 * 修改人：ZX
 * 修改时间：2019/4/21 10:30
 * 修改备注：
 */
public class RetrofitManager {
    private static Retrofit.Builder sInstance;

    public static Retrofit.Builder getInstance() {
        if (sInstance == null) {
            synchronized (RetrofitManager.class) {
                if (sInstance == null) {
                    sInstance = new Retrofit.Builder();
                }
            }
        }
        return sInstance;
    }
}
