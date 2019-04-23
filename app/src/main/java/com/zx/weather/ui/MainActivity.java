package com.zx.weather.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.ArrayMap;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zx.weather.R;
import com.zx.weather.mvp.model.entity.Weather1;
import com.zx.weather.mvp.presenter.IMainPresenter;
import com.zx.weather.mvp.presenter.impl.MainPresenterImpl;
import com.zx.weather.mvp.view.IMainView;
import com.zx.weather.ui.adapder.WeatherAdapter;
import com.zx.weather.util.common.Commons;

import java.util.ArrayList;
import java.util.List;

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
    private RecyclerView recyclerView;
    private Button btn;

    /**
     *  记录城市对应ID
     */
    private ArrayMap<String, String> cityIdMap = new ArrayMap<>();

    private List<String> citys = new ArrayList<>();

    private int type = 0;

    private WeatherAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBin();
        initData();
        queryWeather( type);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mainPresenterImpl = new MainPresenterImpl(this);
        cityIdMap.put(getString(R.string.new_york),getString(R.string.new_york_id));
        cityIdMap.put(getString(R.string.chicago), getString(R.string.chicago_id));
        cityIdMap.put(getString(R.string.miami),getString(R.string.miami_id));
        cityIdMap.put(getString(R.string.san_francisco),getString(R.string.san_francisco_id));

        citys.add(getString(R.string.new_york));
        citys.add(getString(R.string.chicago));
        citys.add(getString(R.string.miami));
        citys.add(getString(R.string.san_francisco));


    }

    /**
     * 查询目标城市天气
     * @param type
     */
    private void queryWeather(int type) {
        this.type = type;
        mainPresenterImpl.getRecentWeather(disposables,cityIdMap.get(citys.get(type)));
    }

    /**
     * 初始化控件并绑定监听事件
     */
    private void initBin() {
        tvTest = (TextView)findViewById(R.id.tv_test);
        btn = (Button)findViewById(R.id.btn);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);

        adapter = new WeatherAdapter(MainActivity.this, citys);
        recyclerView.setAdapter(adapter);

        //设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //设置adapter
        recyclerView.setAdapter(adapter);
        //添加分割线
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this, DividerItemDecoration.HORIZONTAL));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MapActivity.class);
                intent.putExtra(Commons.CITY_KEY, citys.get(type));
                startActivity(intent);
            }
        });

        adapter.setOnItemClickLitener(new WeatherAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                queryWeather(position);
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
