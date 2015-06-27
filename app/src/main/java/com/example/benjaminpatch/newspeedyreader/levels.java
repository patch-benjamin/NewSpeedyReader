package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class levels extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_levels, menu);
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

    public void onclick(View v){
        Integer message = 1;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick2(View v){
        Integer message = 2;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick3(View v){
        Integer message = 3;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick4(View v){
        Integer message = 4;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick5(View v){
        Integer message = 5;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick6(View v){
        Integer message = 6;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick7(View v){
        Integer message = 7;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick8(View v){
        Integer message = 8;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick9(View v){
        Integer message = 9;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
    public void onclick10(View v){
        Integer message = 10;
        Intent i = new Intent(this, readingAssistant.class);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
}
