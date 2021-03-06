package com.suhang.layoutfinder;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Created by 苏杭 on 2017/5/31 20:54.
 */

public class SharedPreferencesFinder {
	private static Context sContext;
	public static void init(Context context) {
		sContext = context;
	}

	public static <T> String  toJson(T t) {
		Gson gson = new Gson();
		return gson.toJson(t);
	}

	public static <T> T fromJson(String json,Class<T> aClass) {
		Gson gson = new Gson();
		return gson.fromJson(json, aClass);
	}

	public static Context getContext() {
		return sContext;
	}
}
