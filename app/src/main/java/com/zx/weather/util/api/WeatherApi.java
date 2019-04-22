package com.zx.weather.util.api;

import android.util.ArrayMap;

import com.zx.weather.mvp.model.entity.Weather1;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/21 11:05
 * 修改人：ZX
 * 修改时间：2019/4/21 11:05
 * 修改备注：
 */
public interface WeatherApi {
    @GET(Config.RECENT_WEATHERS)
    Observable<Weather1> getRecentweathers(@QueryMap ArrayMap<String, Object> map);
}
