package com.example.audiorecording2;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import myclass.AudioFile;

public class ListFile_Activity extends Activity {

	ListView listview;
	ArrayList<AudioFile> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_file_);
		
		listview = (ListView) findViewById(R.id.listView);
		list = new ArrayList<AudioFile>();
		
		CustomAdapter aa = new CustomAdapter(this, R.layout.item_layout, list);
		listview.setAdapter(aa);
	}

	
}
