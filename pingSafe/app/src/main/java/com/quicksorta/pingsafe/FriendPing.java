package com.quicksorta.pingsafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.util.HashMap;
import java.util.Map;


public class FriendPing extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_ping);
        Bundle extras = getIntent().getExtras();
        Double longitude = extras.getDouble("longitude");
        Double latitude = extras.getDouble("latitude");
        String name = extras.getString("name");

        TextView longOut = (TextView) findViewById(R.id.longOut);
        longOut.setText(String.valueOf(longitude));

        TextView latOut = (TextView) findViewById(R.id.latOut);
        latOut.setText(String.valueOf(latitude));

        TextView pingerName = (TextView) findViewById(R.id.pingerName);
        pingerName.setText(name);
    }

    public void helpConfirmed(View view){
            Map<String, Object> coordinates = new HashMap<String, Object>();
            Firebase pingList = new Firebase("https://dazzling-fire-2743.firebaseio.com/pingList");
            coordinates.put("longitude", 160);
            coordinates.put("latitude", 0);
            coordinates.put("name", "qQqQ");
            pingList.setValue(coordinates);
            //eraseFriend = false;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(this, "Help confirmed.", Toast.LENGTH_LONG).show();

    }
    public void helpUnconfirmed(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_friend_ping, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
