package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class CacheActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);

        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.cacheImageView);
        imageView.setImage(ImageSource.resource(R.drawable.cache_callout));
        //ImageView imageView = (ImageView) findViewById(R.id.cacheImageView);
        //imageView.setImageResource(R.drawable.cache_callout);
        //Picasso.with(CacheActivity.this).load(R.drawable.cache_callout).into(imageView);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
