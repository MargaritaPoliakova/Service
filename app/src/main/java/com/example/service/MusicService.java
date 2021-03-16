package com.example.service;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class MusicService extends Service {

    MediaPlayer mediaPlayer;

    public MusicService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.dance_monkey);
        mediaPlayer.setLooping(true);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer.start();

        NotificationManager nManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        //TODO Создать канал
        //TODO создать PendigIntent

        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(this, "chanel")
                .setContentTitle("Музыка")
                .setContentText("Dance Monkey")
                .setColor(Color.BLUE)
                .setSmallIcon(R.drawable.ic_music);

        return Service.START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();

    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
