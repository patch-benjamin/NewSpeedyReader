package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Set;


public class userList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        Log.i("testing", Globals.getUsers().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_list, menu);

        for(int i = 0; i < Globals.getUsers().size(); i++){
            String name = "userName" + (i+1);
            int resID = getResources().getIdentifier(name, "id", getPackageName());
            Button temp = (Button) findViewById(resID);
            temp.setText(Globals.getUsers().get(i).getName());
        }


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

//    @Override
//    public void onResume(){
//        super.onResume();
//    }
//    @Override
//    public void onStart(){
//        super.onStart();
//    }
//    @Override
//    public void onStop(){
//        super.onStop();
//
//        Log.i("testing", "OnStop is called, userData saved: " + Globals.getUserID());
//    }

    public void chooseUserClick1(View v) {
        Button but = (Button) findViewById(R.id.userName1);
        String name = (String) but.getText();
        if(name.equals("Add User")){
            startActivity(new Intent(this, newUser.class));
        }
        else{
            Globals.setUserID(0);
            Log.i("testing", "userclick1 is called, userData: " + Globals.getUserID());
            startActivity(new Intent(this, bookList.class));
        }
    }
    public void chooseUserClick2(View v) {
        Button but = (Button) findViewById(R.id.userName2);
        String name = (String) but.getText();
        if(name.equals("Add User")){
            startActivity(new Intent(this, newUser.class));
        }
        else{
            Globals.setUserID(1);
            Log.i("testing", "userclick2 is called, userData: " + Globals.getUserID());
            startActivity(new Intent(this, bookList.class));
        }
    }
    public void chooseUserClick3(View v) {
        Button but = (Button) findViewById(R.id.userName3);
        String name = (String) but.getText();
        if(name.equals("Add User")){
            startActivity(new Intent(this, newUser.class));
        }
        else{
            Globals.setUserID(2);
            Log.i("testing", "userclick3 is called, userData: " + Globals.getUserID());
            startActivity(new Intent(this, bookList.class));
        }
    }
    public void chooseUserClick4(View v) {
        Button but = (Button) findViewById(R.id.userName4);
        String name = (String) but.getText();
        if(name.equals("Add User")){
            startActivity(new Intent(this, newUser.class));
        }
        else{
            Globals.setUserID(3);
            Log.i("testing", "userclick4 is called, userData: " + Globals.getUserID());
            startActivity(new Intent(this, bookList.class));
        }
    }
    public void chooseUserClick5(View v) {
        Button but = (Button) findViewById(R.id.userName5);
        String name = (String) but.getText();
        if(name.equals("Add User")){
            startActivity(new Intent(this, newUser.class));
        }
        else{
            Globals.setUserID(4);
            Log.i("testing", "userclick5 is called, userData: " + Globals.getUserID());
            startActivity(new Intent(this, bookList.class));
        }
    }

    public void delUser1(View v){
        Globals.getUsers().remove(0);
        Globals.setUserID(Globals.getUserID() - 1);

        startActivity(new Intent(this, MainActivity.class));
    }
    public void delUser2(View v){
        Globals.getUsers().remove(1);
        Globals.setUserID(Globals.getUserID() - 1);

        startActivity(new Intent(this, MainActivity.class));
    }
    public void delUser3(View v){
        Globals.getUsers().remove(2);
        Globals.setUserID(Globals.getUserID() - 1);

        startActivity(new Intent(this, MainActivity.class));
    }
    public void delUser4(View v){
        Globals.getUsers().remove(3);
        Globals.setUserID(Globals.getUserID() - 1);

        startActivity(new Intent(this, MainActivity.class));
    }
    public void delUser5(View v){
        Globals.getUsers().remove(4);
        Globals.setUserID(Globals.getUserID() - 1);

        startActivity(new Intent(this, MainActivity.class));
    }



}
