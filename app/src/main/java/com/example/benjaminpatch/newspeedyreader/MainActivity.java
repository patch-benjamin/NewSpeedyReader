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

//    static TextView welcomePhrase;
//    static String userName;
    TextView welcomePhrase;
    static String userName;
    static ArrayList<User> users;
    String welcome;
    static User user;
    static int userID;

    //Load User Data
//    static SharedPreferences savedData;
//    public static String filename = "userData";
    static SharedPreferences savedData;
    String filename = "userData";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        users = new ArrayList<User>();
        savedData = getSharedPreferences(filename, 0);

        //Load User Data
        loadData();
//        populateSave();
//        saveData();

        user = users.get(userID);
        welcomePhrase = (TextView)findViewById(R.id.welcomePhrase);
        userName = user.getName();
        welcome = "Welcome Back " + userName;
        welcomePhrase.setText(welcome);

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


    public static void setUser(int newUserID){
        userID = newUserID;
        user = users.get(userID);
    }

    public void levelsClick(View v){
        startActivity(new Intent(this, levels.class));
    }

    public void userListClick(View v) {

        startActivity(new Intent(this, userList.class));
    }

    private void populateSave(){
        Book tempBook = new Book ("BOM", 20);
        User temp = new User("Ben", "Patch", 12, tempBook);
        users.add(temp);
        User temp1 = new User("Tyler", "Hall", 12, new Book("EVIL", 200));
        users.add(temp1);
        User temp2 = new User("Beyler", "Halpatch", 12, new Book("Greatness", 5));
        users.add(temp2);
    }

    public static void saveData(){
        SharedPreferences.Editor editStuff = savedData.edit();
        String data = new String();
        for(int i = 0; i < users.size(); i++) {
            if(i == 0)
                data += users.get(i).toString();
            else
                data += "`" + users.get(i).toString();
        }
        data += "`" + String.valueOf(userID);
        editStuff.putString("userData", data);
        editStuff.commit();
    }

    public void loadData(){
//        savedData = getSharedPreferences(filename, 0); //may not be needed here. see oncreate.
        String data = savedData.getString("userData", "Failure in Loading");
        if(data.equals("Failure in Loading")){
            //do something noticeable...
            userName = data;
            welcomePhrase.setText(userName);
        }
        else {
            String[] userData = data.split("`");
            for (int i = 0; i < userData.length; i++) {
                if ((i + 1) != userData.length){
                    User temp = new User();
                    temp.fromString(userData[i]);
                    users.add(temp);
                }
                else{
                    userID = Integer.valueOf(userData[i]);
                }
            }
//            welcomePhrase.setText("First User's First Book: " + users.get(0).getBooks().get(0).getName());

        }
    }

}
