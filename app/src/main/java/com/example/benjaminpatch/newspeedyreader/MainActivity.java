package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {

    TextView welcomePhrase;
    static String userName;
    static ArrayList<User> users;
    String welcome;

    //Load User Data
    SharedPreferences savedData;
    String filename = "userNameData";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcomePhrase = (TextView)findViewById(R.id.welcomePhrase);
        userName = "BT Halpatch";
        welcome = "Welcome Back " + userName;
        welcomePhrase.setText(welcome);

        //Load User Data
        loadData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Hcome/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void levelsClick(View v){
        startActivity(new Intent(this, levels.class));
    }

    public void usersClick(View v) {

        startActivity(new Intent(this, userList.class));
    }

    public void saveData(View v){
        SharedPreferences.Editor editStuff = savedData.edit();
        String data = new String();
        for(int i = 0; i < users.size(); i++) {
            if(i == 0)
                data += users.get(i).toString();
            else
                data += "`" + users.get(i).toString();
        }
        editStuff.putString("userData", data);
        editStuff.commit();
    }

    public void loadData(){
        savedData = getSharedPreferences(filename, 0);
        String data = savedData.getString("userData", "Failure in Loading");
        if(data.equals("Failure in Loading")){
            //do something noticeable...
            userName = data;
            welcomePhrase.setText(userName);
        }
        else {
            String[] userData = data.split("`");
            for (int i = 0; i < userData.length; i++) {
                User temp = new User();
                temp.fromString(userData[i]);
                users.add(temp);
            }
        }
    }

}
