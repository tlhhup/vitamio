package com.example.mytv;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends AppCompatActivity {

//    public static final String DEFAULTPATH = "http://ipadlive.cntv.soooner.com/cctv_p2p_hdcctv6.m3u8";
//    public static final String DEFAULTPATH = "http://t.live.cntv.cn/m3u8/cctv-1.m3u8";
    public static final String DEFAULTPATH = "http://gslb.miaopai.com/stream/oxX3t3Vm5XPHKUeTS-zbXA__.mp4";

    private VideoView mVideoView;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //这句话必须要要
        Vitamio.isInitialized(getApplicationContext());

        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        mVideoView.setMediaController(new MediaController(this));

        if (DEFAULTPATH.startsWith("http:")){
            mVideoView.setVideoURI(Uri.parse(DEFAULTPATH));
        }
        else{
            mVideoView.setVideoPath(DEFAULTPATH);
        }
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mVideoView.start();
            }
        });

        mGestureDetector = new GestureDetector(this,new MyGestureListener());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private final class MyGestureListener extends GestureDetector.SimpleOnGestureListener{

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            mVideoView.switchSecrren();
            return super.onDoubleTap(e);
        }
    }

}
