package com.nbnl.nobeernolife;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

public class NBNLApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		Configuration.Builder activeAndroidBuilder = new Configuration.Builder(getBaseContext());
		activeAndroidBuilder.setDatabaseName("nbnl.db");
		activeAndroidBuilder.setDatabaseVersion(1);
		ActiveAndroid.initialize(activeAndroidBuilder.create(), true);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}
