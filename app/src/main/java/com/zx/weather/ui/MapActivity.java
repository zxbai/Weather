package com.zx.weather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.ArrayMap;

import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;
import com.zx.weather.R;
import com.zx.weather.util.common.Commons;

/**
 * 项目名称：Weather
 * 类描述：这里是地图页面，用于展示城市地图
 * 创建人：ZX
 * 创建时间：2019/4/23 13:48
 * 修改人：ZX
 * 修改时间：2019/4/23 13:48
 * 修改备注：
 */
public class MapActivity extends AppCompatActivity {

    private ArrayMap<String, LatLng> arrayMap = new ArrayMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        initData(getIntent().getStringExtra(Commons.CITY_KEY));
    }

    /**
     * 初始化数据
     */
    private void initData(String city) {
        //纽约
        LatLng GEO_NEW_YORK = new LatLng(40.748, -73.986);
        //芝加哥
        LatLng GEO_CHICAGO = new LatLng(41.883, -87.633);
        //迈阿密
        LatLng GEO_MIAMI = new LatLng(25.773, -80.189);
        //旧金山
        LatLng GEO_SAN_FRANCISCO = new LatLng(37.668, -122.416);

        arrayMap.put(getString(R.string.new_york),GEO_NEW_YORK);
        arrayMap.put(getString(R.string.chicago), GEO_CHICAGO);
        arrayMap.put(getString(R.string.miami),GEO_MIAMI);
        arrayMap.put(getString(R.string.san_francisco),GEO_SAN_FRANCISCO);

        MapStatusUpdate status = MapStatusUpdateFactory.newLatLng(arrayMap.get(city));
        SupportMapFragment map = (SupportMapFragment) (getSupportFragmentManager()
                .findFragmentById(R.id.map));
        map.getBaiduMap().setMapStatus(status);
    }


}
