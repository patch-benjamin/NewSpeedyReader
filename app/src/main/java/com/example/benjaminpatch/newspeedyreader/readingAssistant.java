package com.example.benjaminpatch.newspeedyreader;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


public class readingAssistant extends ActionBarActivity {

  TextView levelWelcome;
  TextView nameDisplay;
  String welcome;
  String userName; ///Should be shareable through each activity.........

  MediaPlayer song;
  boolean isPaused;
  boolean started;
  ImageButton playButton;
  float secsPassed;
  float songFinish;
  CountDownTimer counter;

  private ProgressBar progressBar;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_reading_assistant);
    Intent i = getIntent();
    Integer levelNum = i.getIntExtra(levels.EXTRA_MESSAGE, 1);
    welcome = "Level " + levelNum;
    userName = MainActivity.userName;
    levelWelcome = (TextView) findViewById(R.id.levelNum);
    levelWelcome.setText(welcome);
    nameDisplay = (TextView) findViewById(R.id.nameDisplay);
    nameDisplay.setText(userName);

    playButton = (ImageButton) findViewById(R.id.playButton);
    isPaused = false;
    started = false;
    secsPassed = 0;
    songFinish = 10; //make this changeable according to activity??

    progressBar = (ProgressBar) findViewById(R.id.songProgress);
    progressBar.setMax(90);
    progressBar.getProgress();
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

  public void stopMusic() {song.release(); started = false;}

  @Override
  protected void onPause(){
    super.onPause();
    stopMusic();
  }

  private void changePicture() {
    if (isPaused) {
      playButton.setBackgroundResource(R.drawable.playicon);
    } else{
      playButton.setBackgroundResource(R.drawable.pauseicon);
    }
  }

  public void playPause(View v){
    if(!started){
        if (counter != null){
            Log.i("counterStatus", "Counter is null and being started...");
            counter.cancel();
            counter = null;
        }
      song = MediaPlayer.create(this, R.raw.level1);
      song.start();
      song.setLooping(true);
      isPaused = false;
      started = true;
      changePicture();
      //create new timer
      startTimer((long) (songFinish) * 1000);
    }
    else if(isPaused){
      song.start();
      isPaused = false;
      changePicture();
      //create new timer with time left
      startTimer(((long) (songFinish - secsPassed) * 1000));
    }
    else{
      song.pause();
      isPaused = true;
      changePicture();
      //kill timer
      counter.cancel();
      counter = null;
    }
    //call/create timerthingie
  }

  public void startTimer(long seconds){
    counter = new CountDownTimer(seconds, 100) {

      public void onTick(long millisUntilFinished) {
        secsPassed += .1;
        int progress = ((int)((secsPassed/songFinish)*100));
        progressBar.setProgress(progress);
        if (progressBar.getProgress() >= progressBar.getMax() && !isPaused && !started){
            Log.e("progressTag", "ProgressBar completed earlier than song!!!! Stupid!");
        }
      }

      public void onFinish() {
        song.stop();
          song.release();
        song = null;
        secsPassed = 0;
        isPaused = true;
        started = false;
        changePicture();
          if (progressBar.getProgress() < progressBar.getMax() && !isPaused && !started) {
              Log.e("progressTag", "ProgressBar did not complete before song ended!!!! Idiot!!");
          }
          else if(progressBar.getProgress() == progressBar.getMax() && !isPaused && !started) {
              Log.i("progressTag", "progressBar is perfect!!!! Dummy!");
          }
      }
    }.start();
  }


}
