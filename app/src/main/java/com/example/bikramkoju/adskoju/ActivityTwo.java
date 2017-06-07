package com.example.bikramkoju.adskoju;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class ActivityTwo extends AppCompatActivity {

    private AdView mAdMobAdView;
    InterstitialAd mAdMobInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        mAdMobInterstitialAd = new InterstitialAd(this);
        mAdMobInterstitialAd.setAdUnitId(getString(R.string.interstitial_full_screen_ad));
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("40813E1F5309BE3C2DFE1900EF5E9BA7")
                .build();

        mAdMobInterstitialAd.loadAd(adRequest);
        mAdMobInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                showInterstitialAd();
            }
        });
    }

    private void showInterstitialAd() {
        if (mAdMobInterstitialAd.isLoaded()) {
            mAdMobInterstitialAd.show();
        }
    }
}
