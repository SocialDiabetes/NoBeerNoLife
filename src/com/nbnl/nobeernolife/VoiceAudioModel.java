package com.nbnl.nobeernolife;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

public class VoiceAudioModel extends Model {
	@Column(name = "item_id", notNull = true)
	public long id;
	@Column(name = "category", notNull = true)
	public int category = 0;
	@Column(name = "filepath", notNull = true)
	public String filepath;
	@Column(name = "voice_text", notNull = true)
	public String voice_text;
	@Column(name = "updated_at", notNull = true)
	public long updated_at = System.currentTimeMillis();
	@Column(name = "created_at", notNull = true)
	public long created_at = System.currentTimeMillis();
}
