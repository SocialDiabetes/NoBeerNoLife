package com.nbnl.nobeernolife;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import omron.HVC.BleDeviceSearch;
import omron.HVC.HVC;
import omron.HVC.HVC_BLE;
import omron.HVC.HVC_PRM;
import omron.HVC.HVC_RES;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
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
		SearchBluetooth();
	}

	private void SearchBluetooth(){
		BluetoothBroadcastReceiver receiver = new BluetoothBroadcastReceiver();
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		IntentFilter filter = new IntentFilter();
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		filter.addAction(BluetoothDevice.ACTION_FOUND);
		filter.addAction(BluetoothDevice.ACTION_NAME_CHANGED);
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		this.registerReceiver(receiver, filter);
		if(bluetoothAdapter.isDiscovering()){
			//検索中の場合は検出をキャンセルする
			bluetoothAdapter.cancelDiscovery();
		}
		//デバイスを検索する
		//一定時間の間検出を行う
		bluetoothAdapter.startDiscovery();
		Log.d(Config.TAG, "hogehoge");
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
