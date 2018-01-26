package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import uk.co.senab.photoview.PhotoViewAttacher;

public class OverpassActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overpass);

        ImageView imageView = (ImageView) findViewById(R.id.overpassImageView);
        imageView.setImageResource(R.drawable.overpass_callout);
        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();


        mAdView = (AdView) findViewById(R.id.overpassAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }


}
