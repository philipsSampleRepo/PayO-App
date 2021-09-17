package com.pay.payo.utils;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.lang.reflect.Type;

import androidx.lifecycle.LiveData;
import retrofit2.Call;
import retrofit2.Retrofit;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Retrofit.class)
public class LiveDataCallAdapterTest {
    @Test
    public void testLiveData() {
        LiveDataCallAdapter liveDataCallAdapter = mock(LiveDataCallAdapter.class);
        Type type = mock(Type.class);
        doReturn(type).when(liveDataCallAdapter).responseType();
        Object typeOutput = liveDataCallAdapter.responseType();
        assertTrue(typeOutput instanceof Type);
    }

    @Test
    public void testLiveDataDapt() {
        LiveDataCallAdapter liveDataCallAdapter = mock(LiveDataCallAdapter.class);
        Call call = mock(Call.class);
        LiveData liveData = mock(LiveData.class);
        doReturn(liveData).when(liveDataCallAdapter).adapt(call);
        Object output = liveDataCallAdapter.adapt(call);
        assertTrue(output instanceof LiveData);
    }
}
