package com.nbnl.nobeernolife;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.Buffer;
import java.util.Random;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

public class AudioFileDownLoaderService extends IntentService {

	public AudioFileDownLoaderService(String name) {
		super(name);
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		ApplicationHelper.downloadAndSaveLocal(this, "http://tts.exaitalk.net/webtts/tts/ttsget.php?username=hack0522&password=P2k1a8HN&text=%E3%83%86%E3%82%B9%E3%83%88%E3%83%86%E3%82%B9%E3%83%88");
		//DownloadManager downLoadManager = (DownloadManager)getSystemService(DOWNLOAD_SERVICE);
		//Request request = new Request(Uri.parse("http://tts.exaitalk.net/webtts/tts/ttsget.php?username=hack0522&password=P2k1a8HN&text=%E3%83%86%E3%82%B9%E3%83%88%E3%83%86%E3%82%B9%E3%83%88"));
		//request.setDestinationInExternalFilesDir(getApplicationContext(), Environment.DIRECTORY_DOWNLOADS, "/temp.pdf");
		//request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
		//downLoadManager.enqueue(request);
	}
}
