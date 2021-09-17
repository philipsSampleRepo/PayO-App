package com.pay.payo.persistence;


import android.content.Context;


import com.pay.payo.model.NetworksResponseModel;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {NetworksResponseModel.class}, version = 1, exportSchema = false)
@TypeConverters({DataConverter.class})
public abstract class NetworkInfoDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "payment_networks_db";

    private static NetworkInfoDatabase instance;

    public static NetworkInfoDatabase getInstance(final Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NetworkInfoDatabase.class,
                    DATABASE_NAME
            ).build();
        }
        return instance;
    }

    public abstract NetworksInfoDAO getNetworksDAO();

}
