package com.zx.weather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;

import com.zx.weather.R;
import com.zx.weather.mvp.model.entity.Weather1;
import com.zx.weather.mvp.presenter.IMainPresenter;
import com.zx.weather.mvp.presenter.impl.MainPresenterImpl;
import com.zx.weather.mvp.view.IMainView;
import com.zx.weather.ui.adapder.MyAdapter;

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
    private ArrayMap<String, String> arrayMap = new ArrayMap<>();
    private String[] strings = {"迈阿密", "纽约", "芝加哥", "旧金山"};

    private RecyclerView mRecyclerView;

    private RecyclerView.Adapter mAdapter;

    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mainPresenterImpl = new MainPresenterImpl(this);

    }

    private void initData() {
        arrayMap.put("迈阿密","401020101");
        arrayMap.put("纽约","401110101");
        arrayMap.put("芝加哥","401070101");
        arrayMap.put("旧金山","401640100");
    }


    private void initView() {
        tvTest = (TextView)findViewById(R.id.tv_test);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new MyAdapter(strings);

        // 设置布局管理器
        mRecyclerView.setLayoutManager(mLayoutManager);
        // 设置adapter
        mRecyclerView.setAdapter(mAdapter);

        ((MyAdapter) mAdapter).setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mainPresenterImpl.getRecentWeather(disposables,arrayMap.get(strings[position]));
            }
        });
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
