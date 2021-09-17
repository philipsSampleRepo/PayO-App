package com.pay.payo.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.pay.payo.R;

import static com.pay.payo.utils.Constants.SPLASH_DISPLAY_LENGTH;

public class PayoSplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(() -> {
                    startActivity(new Intent(PayoSplashScreen.this,
                            PaymentMethodsActivity.class));
                    finish();
                },

                SPLASH_DISPLAY_LENGTH);
    }
}
