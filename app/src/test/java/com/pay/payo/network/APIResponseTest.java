package com.pay.payo.network;

import android.util.Log;

import com.pay.payo.model.NetworksResponseModel;
import com.pay.payo.model.ReturnCode;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.doReturn;
import static org.powermock.api.mockito.PowerMockito.spy;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Response.class, Log.class})
public class APIResponseTest {
    @Before
    public void setup() {
        PowerMockito.mockStatic(Log.class);
    }

    @Test
    public void apiResponseErrorTest() {

        String error = "test error";
        ApiResponse response = new ApiResponse();

        ApiResponse.ApiErrorResponse apiResponse =
                (ApiResponse.ApiErrorResponse) response.create(new Throwable(error));
        assertEquals(apiResponse.getErrorMessage(), error);
    }

    @Test
    public void apiResponseSuccessErrorResponse() {

        String errorMsg = "Unexpected Error Occurred. Please try again.";
        Response retroResponse = PowerMockito.mock(Response.class);

        NetworksResponseModel networksResponseModel = new NetworksResponseModel();
        ReturnCode returnCode = new ReturnCode();
        NetworksResponseModel spyResponse = spy(networksResponseModel);
        ReturnCode spyReturnCode = spy(returnCode);

        doReturn("ERROR").when(spyReturnCode).getName();
        doReturn(spyReturnCode).when(spyResponse).getReturnCode();
        doReturn(true).when(retroResponse).isSuccessful();
        doReturn(spyResponse).when(retroResponse).body();

        ApiResponse response = new ApiResponse();
        ApiResponse.ApiErrorResponse apiResponse =
                (ApiResponse.ApiErrorResponse) response.create(retroResponse);

        String actual = apiResponse.getErrorMessage();
        assertEquals(actual, errorMsg);
    }

    @Test
    public void apiResponseSuccessResponse() {
        String successfulMsg = "OK";
        Response retroResponse = PowerMockito.mock(Response.class);

        NetworksResponseModel networksResponseModel = new NetworksResponseModel();
        ReturnCode returnCode = new ReturnCode();
        NetworksResponseModel spyResponse = spy(networksResponseModel);
        ReturnCode spyApiInfo = spy(returnCode);

        doReturn(successfulMsg).when(spyApiInfo).getName();
        doReturn(spyApiInfo).when(spyResponse).getReturnCode();
        doReturn(true).when(retroResponse).isSuccessful();
        doReturn(spyResponse).when(retroResponse).body();

        ApiResponse response = new ApiResponse();
        Object apiResponse = response.create(retroResponse);
        assertTrue(apiResponse instanceof ApiResponse.ApiSuccessResponse);
    }

    @Test
    public void apiResponseEmptyResponse() {
        String successfulMsg = "OK";
        Response retroResponse = PowerMockito.mock(Response.class);

        NetworksResponseModel networksResponseModel = new NetworksResponseModel();
        ReturnCode returnCode = new ReturnCode();
        NetworksResponseModel spyResponse = spy(networksResponseModel);
        ReturnCode spyApiInfo = spy(returnCode);

        doReturn(successfulMsg).when(spyApiInfo).getName();
        doReturn(spyApiInfo).when(spyResponse).getReturnCode();
        doReturn(true).when(retroResponse).isSuccessful();
        doReturn(null).when(retroResponse).body();

        ApiResponse response = new ApiResponse();
        Object apiResponse = response.create(retroResponse);
        assertTrue(apiResponse instanceof ApiResponse.ApiEmptyResponse);
    }
}
