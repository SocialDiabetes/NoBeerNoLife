package com.nbnl.nobeernolife;

import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nbnl.nobeernolife.BluetoothBroadcastReceiver.ReceiveCallback;

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
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class BluetoothDeviceSelectController{
	private BluetoothAdapter mBluetoothAdapter;
	private Context mContext;
	private ConnectableDeviceCallback mCallback;

    public BluetoothDeviceSelectController(Context context){
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		mBluetoothAdapter.enable();
		mContext = context;
	}

	public void setConnectableDeviceCallback(ConnectableDeviceCallback callback){
		mCallback = callback;
	}

	public void startDiscovery(){
		Set<BluetoothDevice> devices = mBluetoothAdapter.getBondedDevices();
		Log.d(Config.TAG, devices.toString());
		SearchBluetoothDevice();
	}

	public interface ConnectableDeviceCallback{
		public void devices(ArrayList<BluetoothDevice> deviceList);
	}

	private void SearchBluetoothDevice(){
		BluetoothBroadcastReceiver receiver = new BluetoothBroadcastReceiver();
		receiver.setOnReceiveCallback(new ReceiveCallback() {
			@Override
			public void onDiscoveryStart() {
				
			}
			
			@Override
			public void onDiscoverFinished(ArrayList<BluetoothDevice> foundDevices) {
				mCallback.devices(foundDevices);
			}
			
			@Override
			public void onDeviceFound(BluetoothDevice device) {
				
			}
			
			@Override
			public void onDeviceChanged(BluetoothDevice device) {
				
			}
		});
		IntentFilter filter = new IntentFilter();
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED);
		filter.addAction(BluetoothDevice.ACTION_FOUND);
		filter.addAction(BluetoothDevice.ACTION_NAME_CHANGED);
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		mContext.registerReceiver(receiver, filter);
		if(mBluetoothAdapter.isDiscovering()){
			//検索中の場合は検出をキャンセルする
			mBluetoothAdapter.cancelDiscovery();
		}
		//デバイスを検索する
		//一定時間の間検出を行う
		mBluetoothAdapter.startDiscovery();
		Log.d(Config.TAG, "hogehoge");
	}
}
