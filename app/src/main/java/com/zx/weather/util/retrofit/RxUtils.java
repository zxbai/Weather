package com.zx.weather.util.retrofit;

import com.zx.weather.util.api.Config;
import com.zx.weather.util.api.WeatherApi;

import io.reactivex.disposables.Disposable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/21 10:39
 * 修改人：ZX
 * 修改时间：2019/4/21 10:39
 * 修改备注：
 */
public class RxUtils {
    private static final String TAG = "RxUtils";

    private RxUtils() {

    }

    public static void unsubscribeIfNotNull(Disposable disposable) {
        if (disposable != null) {
            disposable.dispose();
        }
    }


    public static <T> T createApi(Class<T> c, String url) {
        OkHttpClient client = OkHttpClientManager.getInstance(); //create OKHTTPClient
        Retrofit retrofit = RetrofitManager.getInstance()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(url)
                .build();
        return retrofit.create(c);

    }


    public static WeatherApi getWtApi(){
        return createApi(WeatherApi.class,Config.WEATHER_BASE_URL);
    }
}
