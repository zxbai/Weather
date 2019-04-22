package com.zx.weather.mvp.model.impl;

import android.util.ArrayMap;

import com.zx.weather.mvp.model.IAbsModel;
import com.zx.weather.mvp.model.entity.Weather1;
import com.zx.weather.mvp.presenter.listener.OnWeatherListener;
import com.zx.weather.util.retrofit.RxUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/20 19:47
 * 修改人：ZX
 * 修改时间：2019/4/20 19:47
 * 修改备注：
 */
public class WeatherModelImpl implements IAbsModel<OnWeatherListener> {
    @Override
    public void loadData(CompositeDisposable disposable, ArrayMap<String, Object> map, final OnWeatherListener listener) {
        Observable<Weather1> observable = RxUtils.getWtApi().getRecentweathers(map);
        Consumer<Weather1> consumer = new Consumer<Weather1>() {
            @Override
            public void accept(Weather1 weather1) throws Exception {
                if(weather1 != null){
                    listener.onWeathersResult(weather1, "获取数据成功");
                }else {
                    listener.onWeatherError("获取数据失败");
                }
            }
        };
        Consumer<Throwable> throwableConsumer = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                listener.onWeatherError("获取数据异常");
            }
        };
        disposable.add(observable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer, throwableConsumer));
    }
}
