package com.example.androidtest;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Object mObject = new Object();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button1);  
//        btn.setOnClickListener(new View.OnClickListener() {  
//  
//            @Override  
//            public void onClick(View v) {  
//                WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);  
//                WifiInfo info = wifi.getConnectionInfo();  
//                System.out.println("Wifi mac :" + info.getMacAddress());  
//                Log.d("DEMO", "Wifi mac:"+info.getMacAddress());  
//            }  
//        });  
        
        btn.setOnClickListener(new View.OnClickListener() {
            @Override  
          public void onClick(View v) {  
        Thread mThread = new Thread(new Runnable() {
            
            @Override
            public void run() {
                // TODO Auto-generated method stub
                synchronized (mObject) {
                    
                
                try {
                    mObject.wait(4000);
                    Log.d("chenlong", "good");
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                }
            }
        });
        mThread.start();
            }
        });
    }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//        if (id == R.id.action_settings) {
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
