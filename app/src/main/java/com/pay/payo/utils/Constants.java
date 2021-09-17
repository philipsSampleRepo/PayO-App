package com.pay.payo.utils;

public final class Constants {

    //Network
    public static final String BASE_URL =
            "https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/";

    public static final int CONNECTION_TIMEOUT = 10; // 10 seconds
    public static final int READ_TIMEOUT = 10; // 10 seconds
    public static final int WRITE_TIMEOUT = 10; // 10 seconds
    public static final int SPLASH_DISPLAY_LENGTH = 1000;

    //Errors
    public static final String RESPONSE_ERROR = "Unexpected Error Occurred. Please try again.";
    public static final String NETWORK_ERROR = "Unknown error\nCheck network connection";
    public static final String ERROR_404 = "Resource not found";
    public static final String ERROR_500 = "Server encountered unexpected issue";
}
