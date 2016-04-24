package com.example.audiorecording2;

import java.util.ArrayList;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import myclass.AudioFile;

public class CustomAdapter  extends ArrayAdapter<AudioFile> {

	Activity _context;
	ArrayList<AudioFile> _listItem;
	int _layoutid;
	
	public CustomAdapter(Activity context, int resource, ArrayList<AudioFile> objects) {
		super(context, resource, objects);
		
		this._context = context;
		this._layoutid = resource;
		this._listItem = objects;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView==null){
            LayoutInflater inflater = this._context.getLayoutInflater();
            convertView = inflater.inflate(_layoutid, null);
        }
		
		
		TextView filename = (TextView)convertView.findViewById(R.id.filename);
		TextView date_record = (TextView)convertView.findViewById(R.id.date_record);
		TextView time_record = (TextView)convertView.findViewById(R.id.time_record);
		TextView size = (TextView)convertView.findViewById(R.id.size);
		TextView lenght = (TextView)convertView.findViewById(R.id.lenght);
		
		AudioFile item = _listItem.get(position);
		
		filename.setText(item.get_filename());
		date_record.setText(item.get_dateRecord());
		time_record.setText(item.get_timeRecord());
		size.setText(item.getSize());
		lenght.setText(item.getLenght());
		
		return convertView;
	}

}
