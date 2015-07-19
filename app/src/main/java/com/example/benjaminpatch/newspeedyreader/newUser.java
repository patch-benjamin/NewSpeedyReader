package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class newUser extends ActionBarActivity {

    EditText firstName;
    EditText lastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user);
        Log.i("testing", Globals.getUsers().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_user, menu);
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

//    protected void onPause(){
//        super.onPause();
//    }
//
//    protected void onResume() {
//        super.onResume();
//
//    }
//    protected void onStop(){
//        super.onStop();
//    }
//    protected void onStart(){
//        super.onStart();
//    }
//    protected void onDestroy(){
//        super.onDestroy();
//    }
//

    public void addUserButtonClick(View v){
        firstName = (EditText) findViewById(R.id.firstNameBox);
        lastName = (EditText) findViewById(R.id.lastNameBox);

        User temp = new User();
        temp.setName(String.valueOf(firstName.getText()), String.valueOf(lastName.getText()));
        Globals.addUser(temp);

        startActivity(new Intent(this, MainActivity.class));
    }




}