package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class bookList extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        for(int i = 0; i < MainActivity.user.getBooks().size(); i++){
            String name = "book" + (i+1);
            int resID = getResources().getIdentifier(name, "id", getPackageName());
            Button temp = (Button) findViewById(resID);
            temp.setText(MainActivity.user.getBooks().get(i).getName());
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book_list, menu);
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


    public void chooseBookClick1(View v) {
        Button but = (Button) findViewById(R.id.book1);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void chooseBookClick2(View v) {
        Button but = (Button) findViewById(R.id.book2);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void chooseBookClick3(View v) {
        Button but = (Button) findViewById(R.id.book3);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void chooseBookClick4(View v) {
        Button but = (Button) findViewById(R.id.book4);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void chooseBookClick5(View v) {
        Button but = (Button) findViewById(R.id.book5);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void chooseBookClick6(View v) {
        Button but = (Button) findViewById(R.id.book6);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }
    public void chooseBookClick7(View v) {
        Button but = (Button) findViewById(R.id.book7);
        String name = (String) but.getText();
        if(name.equals("Add Book")){
            startActivity(new Intent(this, newBook.class));
        }
        else{
            startActivity(new Intent(this, MainActivity.class));
        }
    }

}
