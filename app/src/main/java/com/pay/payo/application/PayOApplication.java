package com.pay.payo.application;

import android.app.Application;

import com.pay.payo.application.di.ApplicationComponent;
import com.pay.payo.application.di.ApplicationModule;
import com.pay.payo.application.di.DaggerApplicationComponent;

public class PayOApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.factory()
                .create(new ApplicationModule(getApplicationContext()));
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
