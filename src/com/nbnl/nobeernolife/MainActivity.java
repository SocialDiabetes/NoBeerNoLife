package com.nbnl.nobeernolife;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {
	private SoundController mSoundController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSoundController = new SoundController(this);
		mSoundController.addSound("4476a36f9a7baf193d9284962c6b07a5.mp3");
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSoundController.playCurrentSound();
	}

	@Override
	protected void onPause() {
		super.onPause();
		mSoundController.pauseCurrentSound();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mSoundController.release();
	}
}
