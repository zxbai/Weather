package com.zx.weather.mvp.model;

import android.util.ArrayMap;

import io.reactivex.disposables.CompositeDisposable;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：2019/4/20 19:01
 * 修改人：ZX
 * 修改时间：2019/4/20 19:01
 * 修改备注：
 */
public interface IAbsModel<K> {
    void loadData(CompositeDisposable disposable, ArrayMap<String, Object> map, K listener);
}
