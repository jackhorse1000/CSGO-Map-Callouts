package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MirageActivity extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mirage);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        SubsamplingScaleImageView imageView = (SubsamplingScaleImageView)findViewById(R.id.mirageImageView);
        imageView.setImage(ImageSource.resource(R.drawable.mirage_callout));
        //ImageView imageView = (ImageView) findViewById(R.id.mirageImageView);
        //imageView.setImageResource(R.drawable.mirage_callout);
        //Picasso.with(MirageActivity.this).load(R.drawable.mirage_callout).into(imageView);



    }
}
