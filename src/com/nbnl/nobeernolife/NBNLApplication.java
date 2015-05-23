package com.nbnl.nobeernolife;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;

public class NBNLApplication extends Application {
	@Override
	public void onCreate() {
		super.onCreate();
		ImageLoaderConfiguration.Builder imageLoaderBuilder = new ImageLoaderConfiguration.Builder(getApplicationContext());
		imageLoaderBuilder.memoryCache(new LruMemoryCache(8 * 1024 * 1024));
		imageLoaderBuilder.memoryCacheSize(8 * 1024 * 1024);
		ImageLoaderConfiguration config = imageLoaderBuilder.build();
		ImageLoader.getInstance().init(config);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
}
