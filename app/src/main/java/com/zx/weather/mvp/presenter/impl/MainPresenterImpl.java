package com.zx.weather.mvp.presenter.impl;

import android.util.ArrayMap;

import com.zx.weather.mvp.model.entity.Weather1;
import com.zx.weather.mvp.model.impl.WeatherModelImpl;
import com.zx.weather.mvp.presenter.IMainPresenter;
import com.zx.weather.mvp.presenter.listener.OnWeatherListener;
import com.zx.weather.mvp.view.IMainView;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 项目名称：Weather
 * 类描述： Presenter作为中间层，持有View和Model的引用
 * 创建人：ZX
 * 创建时间：2019/4/21 10:19
 * 修改人：ZX
 * 修改时间：2019/4/21 10:19
 * 修改备注：
 */
public class MainPresenterImpl implements IMainPresenter, OnWeatherListener {

    private IMainView iMainView;
    private WeatherModelImpl weatherModel;

    public MainPresenterImpl(IMainView mainView){
        iMainView = mainView;
        weatherModel = new WeatherModelImpl();
    }

    @Override
    public void getRecentWeather(CompositeDisposable subscription, String cityid) {
        //发起天气请求
        ArrayMap<String, Object> map = new ArrayMap<>();
        map.put("appid","1001");
        map.put("appsecret","1002");
        map.put("version","v5");
        map.put("cityid",cityid);
        weatherModel.loadData(subscription, map, this);
    }


    @Override
    public void onWeathersResult(Weather1 weathers, String msg) {
        // 处理天气数据后 调用V层接口将数据给到V层
        Weather1.DataBean dataBean = weathers.getData().get(0);
        List<String> winlist = dataBean.getWin();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(weathers.getCity()).append("\n")
                .append(dataBean.getWea()).append("\t")
                .append(dataBean.getTem2())
                .append("--")
                .append(dataBean.getTem1())
                .append("°C").append("\t");
        for (String win : winlist){
            stringBuilder.append(win);
        }
        stringBuilder.append("\t").append(dataBean.getWin_speed());

        iMainView.setWeathers(stringBuilder.toString());
    }

    @Override
    public void onWeatherError(String msg) {

    }
}
