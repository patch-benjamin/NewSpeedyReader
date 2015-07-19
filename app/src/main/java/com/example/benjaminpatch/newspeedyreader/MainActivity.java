package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.provider.Settings;
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
    String welcome;
    //Load User Data
    static SharedPreferences savedData;
    String filename = "userData";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("testing", "starting onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        users = new ArrayList<User>();
        savedData = getSharedPreferences(filename, 0);

        welcomePhrase = (TextView)findViewById(R.id.welcomePhrase);
        //Load User Data
//        populateSave();
//        saveData();
        loadData();

        welcome = "Welcome Back " + Globals.getUser().getName();
        welcomePhrase.setText(welcome);
        Log.i("testing", Globals.getUsers().toString());
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

    @Override
    public void onResume(){
        super.onResume();
        welcome = "Welcome Back " + Globals.getUser().getName();
//        welcomePhrase.setText(welcome);
    }
    @Override
    public void onStop(){
        super.onStop();
    }
    @Override
    public void onStart(){
        super.onStart();
    }


    public void levelsClick(View v){
        startActivity(new Intent(this, levels.class));
    }

    public void userListClick(View v) {

        startActivity(new Intent(this, userList.class));
    }

    private void populateSave(){
        Log.i("testing", "starting popluateSave");
        ArrayList<User> userList = new ArrayList<User>();
        Book tempBook = new Book ("BOM", 20);
        User temp = new User("Ben", "Patch", 12, tempBook);
        userList.add(temp);
        User temp1 = new User("Tyler", "Hall", 12, new Book("EVIL", 200));
        userList.add(temp1);
        User temp2 = new User("Beyler", "Halpatch", 12, new Book("Greatness", 5));
        userList.add(temp2);
        int id = 0;

        SharedPreferences.Editor editStuff = savedData.edit();
        String data = new String();
        for(int i = 0; i < userList.size(); i++) {
            if(i == 0)
                data += userList.get(i).toString();
            else
                data += "`" + userList.get(i).toString();
        }
        data += "`" + String.valueOf(id);
        editStuff.putString("userData", data);
        editStuff.commit();
    }

    public static void saveData(){
        Log.i("testing", "starting saveData");
        SharedPreferences.Editor editStuff = savedData.edit();
        String data = new String();
        for(int i = 0; i < Globals.getUsers().size(); i++) {
            if(i == 0)
                data += Globals.getUser(i).toString();
            else
                data += "`" + Globals.getUser(i).toString();
        }
        data += "`" + String.valueOf(Globals.getUserID());
        editStuff.putString("userData", data);
        editStuff.commit();
    }

    public void loadData(){
        Log.i("testing", "LoadingInfo");
//        savedData = getSharedPreferences(filename, 0); //may not be needed here. see oncreate.
        String data = savedData.getString("userData", "Failure in Loading");
        if(data.equals("Failure in Loading")){
            //do something noticeable...
            welcomePhrase.setText(data);
        }
        else {
            String[] userData = data.split("`");
            for (int i = 0; i < userData.length; i++) {
                if ((i + 1) != userData.length){
                    User temp = new User();
                    temp.fromString(userData[i]);
                    Log.i("testing", "attempting to add user");
                    Globals.addUser(temp, true);
                    Log.i("testing", "user added");
                }
                else{
                    Log.i("testing", "attempting to set userID");
                    Globals.setUserID(Integer.valueOf(userData[i]));
                    Log.i("testing", "userID set");
                }
            }
            Log.i("testing", "attempting to set text");
//                welcomePhrase.setText(Globals.getUsers().toString());
            Log.i("testing", "set text completed.");
        }
    }

}
