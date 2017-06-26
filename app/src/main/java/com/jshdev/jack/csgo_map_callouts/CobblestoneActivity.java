package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class CobblestoneActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cobblestone);


        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.cobblestoneImageView);
        imageView.setImage(ImageSource.resource(R.drawable.cobblestone_callout));
        //ImageView imageView = (ImageView) findViewById(R.id.cobblestoneImageView);
        //imageView.setImageResource(R.drawable.cobblestone_callout);
        //Picasso.with(CobblestoneActivity.this).load(R.drawable.cobblestone_callout).into(imageView);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
