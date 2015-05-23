package com.nbnl.nobeernolife;

import java.util.ArrayList;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class SoundController{

	private ArrayList<VoiceAudioModel> mVoiceAudioList;
	private ArrayList<MediaPlayer> mSoundList;
	private MediaPlayer mSound;
	private Context mContext;

	public SoundController(Context context){
		mContext = context;
		mVoiceAudioList = new ArrayList<VoiceAudioModel>();
		mSoundList = new ArrayList<MediaPlayer>();
	}

	public int addSound(String fileName){
		mSound = new MediaPlayer();
		try {
			AssetFileDescriptor afd = mContext.getAssets().openFd(fileName);
			mSound.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
			afd.close();
			mSound.prepare();
			mSoundList.add(mSound);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mSoundList.size();
	}

	public void playCurrentSound(){
		mSound.start();
	}

	public void pauseCurrentSound(){
		mSound.pause();
	}

	public void stopCurrentSound(){
		mSound.stop();
	}

	public void release(){
		for(MediaPlayer sound : mSoundList){
			sound.stop();
			sound.release();
		}
		mSoundList.clear();
		mSound = null;
	}
}
