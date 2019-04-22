package com.zx.weather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zx.weather.R;
import com.zx.weather.mvp.model.entity.Weather1;
import com.zx.weather.mvp.presenter.IMainPresenter;
import com.zx.weather.mvp.presenter.impl.MainPresenterImpl;
import com.zx.weather.mvp.view.IMainView;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

/**
 * 项目名称：Weather
 * 类描述：
 * 创建人：ZX
 * 创建时间：${DATE} ${TIME}
 * 修改人：ZX
 * 修改时间：${DATE} ${TIME}
 * 修改备注：
 */
public class MainActivity extends AppCompatActivity implements IMainView {
    private CompositeDisposable disposables = new CompositeDisposable();
    private MainPresenterImpl mainPresenterImpl;
    private TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = (TextView)findViewById(R.id.tv_test);
        mainPresenterImpl = new MainPresenterImpl(this);
        mainPresenterImpl.getRecentWeather(disposables,"401640100");
    }

    @Override
    public void setWeathers(String weathers) {
        tvTest.setText(weathers);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
