package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class NukeActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuke);

        ImageView imageView = (ImageView) findViewById(R.id.nukeImageView);
        imageView.setImageResource(R.drawable.nuke_callout);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();

        mAdView = (AdView) findViewById(R.id.nukeAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


    }

}
