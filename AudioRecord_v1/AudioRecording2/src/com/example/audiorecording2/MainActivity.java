package com.example.audiorecording2;


import java.io.IOException;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Message;
import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends Activity {

	Button btnCancel,btnDone,btnRecord;
	private MediaRecorder myAudioRecorder;
   	private String outputFile = null;
   	
   	Chronometer chrWatch;
   	long timeWhenStopped = 0;
   	boolean isRecording = false;
   	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnCancel=(Button)findViewById(R.id.btnCancel);
        btnDone=(Button)findViewById(R.id.btnDone);
        btnRecord=(Button)findViewById(R.id.btnRecord);
        chrWatch=(Chronometer)findViewById(R.id.chrWatch);
        //watch.setFormat("HH:MM:SS");
        
        btnDone.setVisibility(View.INVISIBLE);
        btnCancel.setVisibility(View.INVISIBLE);
        //btnDone.setEnabled(false);
        //btnCancel.setEnabled(false);
        //outputFile = Environment.getExternalStorageDirectory().getAbsolutePath() + "/recording.3gp";
        outputFile = Environment.getExternalStorageDirectory() + "/test_" + System.currentTimeMillis() + ".3gp";
        
        
        myAudioRecorder=new MediaRecorder();
        myAudioRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        myAudioRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        
        
        
        //myAudioRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        //myAudioRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);
        
        
        myAudioRecorder.setOutputFile(outputFile);
        
        btnRecord.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              
              
              /*record.setEnabled(false);
              stop.setEnabled(true);
              
              Toast.makeText(getApplicationContext(), "Recording started", Toast.LENGTH_LONG).show();
              */
        	   btnRecord.setSelected(!btnRecord.isSelected());
        	  
        	  if(btnRecord.isSelected())
        	  {
	    		  btnCancel.setVisibility(View.INVISIBLE);
	    		  btnDone.setVisibility(View.INVISIBLE);
	    		  chrWatch.setBase(SystemClock.elapsedRealtime() + timeWhenStopped);    		  
	    		  chrWatch.start();
	    		  
	    		  try {
					myAudioRecorder.prepare();
					myAudioRecorder.start();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		  
        	  }
        	  else
        	  {     		  
	    		  btnCancel.setVisibility(View.VISIBLE);
	    		  btnDone.setVisibility(View.VISIBLE);
	    		  timeWhenStopped = chrWatch.getBase() - SystemClock.elapsedRealtime();
	    		  chrWatch.stop();    		 
        	  }
        	  
        	  
           }
        });
        
        btnDone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
        	   
              myAudioRecorder.stop();
              myAudioRecorder.release();
              myAudioRecorder  = null;
                         
              Toast.makeText(getApplicationContext(), "Audio recorded successfully!",Toast.LENGTH_LONG).show();
              
           }
        });
        
        btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				myAudioRecorder.reset();
				myAudioRecorder = null;
				
				Toast.makeText(getApplicationContext(), "Cancel! ",Toast.LENGTH_LONG).show();
				
			}
		});
        
        /*btnCancel.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) throws IllegalArgumentException,SecurityException,IllegalStateException {
              MediaPlayer m = new MediaPlayer();
              
              try {
                 m.setDataSource(outputFile);
              }
              
              catch (IOException e) {
                 e.printStackTrace();
              }
              
              try {
                 m.prepare();
              }
              
              catch (IOException e) {
                 e.printStackTrace();
              }
              
              m.start();
              Toast.makeText(getApplicationContext(), "Playing audio", Toast.LENGTH_LONG).show();
           }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
