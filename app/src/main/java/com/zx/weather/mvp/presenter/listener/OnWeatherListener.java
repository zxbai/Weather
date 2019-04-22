package com.zx.weather.mvp.presenter.listener;

import com.zx.weather.mvp.model.entity.Weather1;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/20 19:53
 * 修改人：ZX
 * 修改时间：2019/4/20 19:53
 * 修改备注：
 */
public interface OnWeatherListener {
    void onWeathersResult(Weather1 weathers, final String msg);
    void onWeatherError(final String msg);
}
