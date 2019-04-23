package com.zx.weather;

import android.app.Application;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

/**
 * 项目名称：Weather
 * 类描述：这里是APP的入口， 里面会做一些初始化的事
 * 创建人：ZX
 * 创建时间：2019/4/23 13:40
 * 修改人：ZX
 * 修改时间：2019/4/23 13:40
 * 修改备注：
 */
public class WeatherApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }
}
