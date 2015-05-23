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
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;

public class ApplicationHelper{

	public static long downloadAndSaveLocal(Context context, String urlString){
		long total = 0;
		try {
			URL url = new URL(urlString);
			URLConnection con = url.openConnection();
			OutputStream out = context.openFileOutput("sample.mp3", Context.MODE_PRIVATE);
			InputStream is = con.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			int len = 0;
			byte buf[] = new byte[256];
			while((len = bis.read(buf)) != -1){
				out.write(buf, 0, len);
				total += len;
			}
			out.flush();
			out.close();
			bis.close();
			is.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return total;
	}
}
