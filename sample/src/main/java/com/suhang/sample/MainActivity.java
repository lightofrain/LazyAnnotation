package com.suhang.sample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.suhang.layoutfinder.ContextProvider;
import com.suhang.layoutfinder.MethodFinder;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends BaseActivity<Object> implements ContextProvider{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit.Builder builder = new Retrofit.Builder();
        NetworkService networkService = builder.baseUrl("http://www.huanpeng.com").addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create()).build().create(NetworkService.class);
        MethodFinder.inject(networkService,NetworkService.class);
//        MethodFinder.find(AppMain.URL,new ArrayMap<>());
//        Log.i("啊啊啊啊", MethodFinder.find(AppMain.URL,new ArrayMap<>())+"");
        RetrofitHelper.find(AppMain.URL, new Object[]{new ArrayMap<>()}).subscribeOn(Schedulers.computation()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer() {
            @Override
            public void accept(@NonNull Object o) throws Exception {
                Log.i("啊啊啊啊", o.toString());
            }
        });
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefUtil instance = SharedPrefUtil.getInstance();
                ConfitSpHelper.aIn(111);
                ConfitSpHelper.uidIn("烤鸡翅膀");
                ConfitSpHelper.appmainIn(new AppMain());
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MainActivity", "ConfitSpHelper.appmainOut():" + ConfitSpHelper.appmainOut());
                Log.i("MainActivity", "ConfitSpHelper.aOut():" + ConfitSpHelper.aOut());
                Log.i("MainActivity", ConfitSpHelper.uidOut());
            }
        });
    }

    @Override
    public Context providerContext() {
        return this;
    }
}
