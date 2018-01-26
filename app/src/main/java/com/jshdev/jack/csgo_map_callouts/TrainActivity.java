package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class TrainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);



        ImageView imageView = (ImageView) findViewById(R.id.trainImageView);
        imageView.setImageResource(R.drawable.train_callout);

        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();
        //Picasso.with(this.getApplicationContext()).load(R.drawable.train_callout).into(imageView);


        mAdView = (AdView) findViewById(R.id.trainAdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }


}
