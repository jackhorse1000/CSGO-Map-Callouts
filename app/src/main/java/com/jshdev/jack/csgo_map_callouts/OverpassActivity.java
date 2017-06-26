package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class OverpassActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overpass);

        //ImageView imageView = (ImageView) findViewById(R.id.overpassImageView);
        //imageView.setImageResource(R.drawable.overpass_callout);
        //Picasso.with(OverpassActivity.this).load(R.drawable.overpass_callout).into(imageView);

        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.overpassImageView);
        imageView.setImage(ImageSource.resource(R.drawable.overpass_callout));

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
