package com.example.salah.zoomcontrol1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ZoomControls;

public class MainActivity extends AppCompatActivity {
    ZoomControls zoomControls;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        zoomControls = (ZoomControls)findViewById( R.id.zoomControl );
        final ImageView imageView = (ImageView)findViewById( R.id.imageView );

        imageView.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        } );

        zoomControls.setOnZoomInClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                imageView.setScaleX( (float) (x + 1) );
                imageView.setScaleY( (float) (y + 1) );
                Toast.makeText( getApplication(), "Zoom in", Toast.LENGTH_LONG ).show();
                zoomControls.show();
            }
        } );

        zoomControls.setOnZoomOutClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x = imageView.getScaleX();
                float y = imageView.getScaleY();

                imageView.setScaleX( (float) (x - 1) );
                imageView.setScaleY( (float) (y - 1) );
                Toast.makeText( getApplication(), "Zoom out", Toast.LENGTH_LONG ).show();
                zoomControls.show();
            }
        } );

    }
}
