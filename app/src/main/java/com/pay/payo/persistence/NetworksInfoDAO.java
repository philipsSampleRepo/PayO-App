package com.pay.payo.persistence;


import com.pay.payo.model.NetworksResponseModel;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface NetworksInfoDAO {

    @Insert(onConflict = REPLACE)
    void insertCameraItem(NetworksResponseModel responseModel);

    @Query("SELECT * FROM payment_info")
    LiveData<NetworksResponseModel> getPaymentInfo();
}
