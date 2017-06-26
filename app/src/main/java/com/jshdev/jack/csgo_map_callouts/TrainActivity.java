package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class TrainActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);


        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.trainImageView);
        imageView.setImage(ImageSource.resource(R.drawable.train_callout));
        //ImageView imageView = (ImageView) findViewById(R.id.trainImageView);
        //imageView.setImageResource(R.drawable.train_callout);
        //Picasso.with(TrainActivity.this).load(R.drawable.train_callout).into(imageView);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
