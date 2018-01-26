package com.jshdev.jack.csgo_map_callouts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import uk.co.senab.photoview.PhotoViewAttacher;

public class TrainActivity extends AppCompatActivity {

    InterstitialAd mInterstitialAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);



        ImageView imageView = (ImageView) findViewById(R.id.trainImageView);
        imageView.setImageResource(R.drawable.train_callout);

        PhotoViewAttacher photoView = new PhotoViewAttacher(imageView);
        photoView.update();
        //Picasso.with(this.getApplicationContext()).load(R.drawable.train_callout).into(imageView);


        AdRequest adRequest = new AdRequest.Builder().build();


        // Prepare the Interstitial Ad
        interstitial = new InterstitialAd(TrainActivity.this);
        // Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
        // Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }

        });

    }
    private void displayInterstitial() {
// If Ads are loaded, show Interstitial else show nothing.
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }

}
