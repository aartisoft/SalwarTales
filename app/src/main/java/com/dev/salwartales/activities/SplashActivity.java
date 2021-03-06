package com.dev.salwartales.activities;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dev.salwartales.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SplashActivity extends AppCompatActivity {
    private ProgressBar mProgress;
    public final int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mProgress = (ProgressBar) findViewById(R.id.progressBar);



       /* try {
            PackageInfo info = getPackageManager().getPackageInfo(
                    getPackageName(),
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        }
        catch (PackageManager.NameNotFoundException e) {

        }
        catch (NoSuchAlgorithmException e) {

        }*/



        // Start lengthy operation in a background thread
        new Thread(new Runnable() {
            public void run() {
                doWork();
                if (isOnline()){
                    startApp();
                }else {
                    Toast.makeText(SplashActivity.this, "Please Check Your Internet Connection!", Toast.LENGTH_SHORT).show();
                    mProgress.setVisibility(View.INVISIBLE);
                    Looper.prepare();
                }


            }
        }).start();
    }

    private void doWork() {
        for (int progress=0; progress<100; progress++) {
            try {
                Thread.sleep(50);
                mProgress.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();



            }
        }
    }

    private void startApp() {
        Intent intent = new Intent(SplashActivity.this, Navigation.class);
        startActivity(intent);
        finish();
    }



    public boolean isOnline() {
        ConnectivityManager connManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }

    }

