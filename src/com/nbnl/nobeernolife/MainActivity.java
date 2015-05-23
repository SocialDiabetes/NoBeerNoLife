package com.nbnl.nobeernolife;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nbnl.nobeernolife.BluetoothBroadcastReceiver.ReceiveCallback;
import com.nbnl.nobeernolife.BluetoothDeviceSelectController.ConnectableDeviceCallback;

import omron.HVC.BleDeviceSearch;
import omron.HVC.HVC;
import omron.HVC.HVCBleCallback;
import omron.HVC.HVC_BLE;
import omron.HVC.HVC_PRM;
import omron.HVC.HVC_RES;
import omron.HVC.HVC_RES.DetectionResult;
import omron.HVC.HVC_RES.FaceResult;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	private SoundController mSoundController;
	private BluetoothAdapter mBluetoothAdapter;
	private BluetoothDeviceSelectController mBDSController;
    private HVC_BLE hvcBle = null;
    private HVC_PRM hvcPrm = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mSoundController = new SoundController(this);
		mSoundController.addSound("4476a36f9a7baf193d9284962c6b07a5.mp3");
		mBDSController = new BluetoothDeviceSelectController(this);
		mBDSController.setConnectableDeviceCallback(deviceCallback);
		mBDSController.startDiscovery();

		/*
		hvcPrm = new HVC_PRM();
		hvcRes = new HVC_RES();
		hvcBle.setCallBack(hvcCallback);
		*/
	}

	private ConnectableDeviceCallback deviceCallback = new ConnectableDeviceCallback(){
		@Override
		public void devices(ArrayList<BluetoothDevice> deviceList) {
			Log.d(Config.TAG, deviceList.toString());
			for(BluetoothDevice d : deviceList){
				//ここ、もうちょっとなんとかしたい
				if(d.getAddress().equals(Config.ConnectionDeviceAddress)){
					Log.d(Config.TAG, d.toString());
					break;
				}
			}
		}
	};

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
