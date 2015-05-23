package com.nbnl.nobeernolife;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BluetoothBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		BluetoothDevice foundDevice;
		if(BluetoothDevice.ACTION_FOUND.equals(action)){
			//デバイスが検出された
			foundDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			Log.d(Config.TAG, "found device:" + foundDevice.getName() + " address:" + foundDevice.getAddress());
		}
		if(BluetoothDevice.ACTION_NAME_CHANGED.equals(action)){
			//名前が検出された
			foundDevice = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
			Log.d(Config.TAG, "changed device:" + foundDevice.getName() + " address:" + foundDevice.getAddress());
		}
		if(BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)){
			Log.d(Config.TAG, "finish");
		}
	}

	//---------------------------------------------------------------------------------------------------------------------------------------------------------------
}
