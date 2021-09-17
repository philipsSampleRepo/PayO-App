package com.pay.payo.network;

import android.util.Log;

import com.pay.payo.utils.Constants;
import com.pay.payo.utils.LiveDataCallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    private static final String TAG = "NetworkModule";
    public static NetworkClient sharedInstance = null;

    public static NetworkClient getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new NetworkClient();
        }
        return sharedInstance;
    }

    public HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(message ->
                Log.d(TAG, message)).setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }


    public OkHttpClient provideHttpClient(HttpLoggingInterceptor interceptor) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .connectTimeout(Constants.CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(Constants.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(Constants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
        return client;
    }


    public Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    public synchronized APIService provideAPIService() {
        return provideRetrofit(provideHttpClient(provideLoggingInterceptor()))
                .create(APIService.class);
    }
}
