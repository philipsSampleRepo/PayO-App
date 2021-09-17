package com.pay.payo.application.di;

import android.content.Context;

import com.pay.payo.network.APIService;
import com.pay.payo.network.NetworkClient;
import com.pay.payo.persistence.NetworkInfoDatabase;
import com.pay.payo.repository.Repository;
import com.pay.payo.utils.AppExecutors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Singleton
    @Provides
    AppExecutors providesAppExecutors() {
        return new AppExecutors();
    }

    @Singleton
    @Provides
    APIService providesAPIService() {
        return NetworkClient.getSharedInstance().provideAPIService();
    }

    @Singleton
    @Provides
    Context providesContext() {
        return this.context;
    }

    @Singleton
    @Provides
    NetworkInfoDatabase providesDatabase() {
        return NetworkInfoDatabase.getInstance(context);
    }

    @Singleton
    @Provides
    Repository ProvidesRepository() {
        return Repository.getInstance(context);
    }
}
