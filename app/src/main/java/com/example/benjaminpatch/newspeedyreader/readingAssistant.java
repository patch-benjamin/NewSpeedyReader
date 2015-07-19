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
  Integer levelNum;

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
    levelNum = i.getIntExtra(levels.EXTRA_MESSAGE, 1);
    welcome = "Level " + levelNum;
    userName = Globals.getUser().getName();
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
    song = MediaPlayer.create(this, R.raw.level1song);
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

  public void stopMusic() {
    if(started) {
      song.stop();
      song.release();
      started = false;
      isPaused = true;
      secsPassed = 0;
      if(counter != null){
        counter.cancel();
        counter = null;
      }
    }
  }

  @Override
  protected void onPause() {
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

  private void setSong(){
    switch (levelNum){
      case 1:
        song = MediaPlayer.create(this, R.raw.level1song);
        break;
      case 2:
        song = MediaPlayer.create(this, R.raw.level2song);
        break;
      case 3:
        song = MediaPlayer.create(this, R.raw.level3song);
        break;
      case 4:
        song = MediaPlayer.create(this, R.raw.level4song);
        break;
      case 5:
        song = MediaPlayer.create(this, R.raw.level5song);
        break;
      case 6:
        song = MediaPlayer.create(this, R.raw.level6song);
        break;
      case 7:
        song = MediaPlayer.create(this, R.raw.level7song);
        break;
      case 8:
        song = MediaPlayer.create(this, R.raw.level8song);
        break;
      case 9:
        song = MediaPlayer.create(this, R.raw.level9song);
        break;
      case 10:
        song = MediaPlayer.create(this, R.raw.level10song);
        break;
      case 11:
        song = MediaPlayer.create(this, R.raw.level11song);
        break;
      case 12:
        song = MediaPlayer.create(this, R.raw.level12song);
        break;
      case 13:
        song = MediaPlayer.create(this, R.raw.level13song);
        break;
      case 14:
        song = MediaPlayer.create(this, R.raw.level14song);
        break;
      case 15:
        song = MediaPlayer.create(this, R.raw.level15song);
        break;
      case 16:
        song = MediaPlayer.create(this, R.raw.level16song);
        break;
      case 17:
        song = MediaPlayer.create(this, R.raw.level17song);
        break;
      case 18:
        song = MediaPlayer.create(this, R.raw.level18song);
        break;
      case 19:
        song = MediaPlayer.create(this, R.raw.level19song);
        break;
      case 20:
        song = MediaPlayer.create(this, R.raw.level20song);
        break;
      default:
        song = MediaPlayer.create(this, R.raw.level1song);
    }
  }

  public void playPause(View v){
    if(!started){
      if (counter != null){
        Log.i("counterStatus", "Counter is null and being started...");
        counter.cancel();
        counter = null;
      }
      setSong();
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
        stopMusic();
        int progress = 0;
        progressBar.setProgress(progress);
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
