package com.example.benjaminpatch.newspeedyreader;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class newBook extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_book);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_book, menu);
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


    public void saveData(View v){
//        SharedPreferences.Editor editStuff = MainActivity.savedData.edit();
//        String data = new String();
//        for(int i = 0; i < MainActivity.users.size(); i++) {
//            if(i == 0)
//                data += MainActivity.users.get(i).toString();
//            else
//                data += "`" + MainActivity.users.get(i).toString();
//        }
//        editStuff.putString("userData", data);
//        editStuff.commit();
    }

}
