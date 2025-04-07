package com.nativelocalstorage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;

public class NativeLocalStorageModule extends NativeLocalStorageSpec {

    public static final String NAME = "NativeLocalStorage";

    public NativeLocalStorageModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void setItem(String key,String value) {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, value);
        Log.d("11111", "走了啊");
        editor.apply();
    }

    @Override
    public String getItem(String key) {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String username = sharedPref.getString(key, null);
        return username;
    }

    @Override
    public void removeItem(String key) {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        sharedPref.edit().remove(key).apply();
    }

    @Override
    public void clear() {
        SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        sharedPref.edit().clear().apply();
    }
}