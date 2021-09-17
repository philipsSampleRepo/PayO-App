package com.pay.payo.persistence;

import com.google.gson.Gson;
import com.pay.payo.model.Payment;
import com.pay.payo.model.Status;
import com.pay.payo.model.Style;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.mock;

@RunWith(PowerMockRunner.class)
public class DataConverterTest {

    @Test
    public void fromStatusNullTest() {
        DataConverter converter = new DataConverter();
        Status status = null;
        Object result = converter.fromStatus(status);
        assertNull(result);
    }

    @Test
    public void fromStatusTest() {
        Status status = mock(Status.class);
        DataConverter dataConverter = new DataConverter();
        Object result = dataConverter.fromStatus(status);
        assertTrue(result instanceof String);
    }

    @Test
    public void toStatusNullTest() {
        String input = null;
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.toStatus(input);
        assertNull(output);
    }

    @Test
    public void toStatusTest() {
        String input = new Gson().toJson(new Status());
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.toStatus(input);
        assertTrue(output instanceof Status);
    }

    @Test
    public void fromPaymentNullTest() {
        Payment pay = null;
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.fromPayment(pay);
        assertNull(output);
    }

    @Test
    public void fromPaymentTest() {
        Payment payment = mock(Payment.class);
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.fromPayment(payment);
        assertTrue(output instanceof String);
    }

    @Test
    public void toPaymentNullTest() {
        String input = null;
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.toStatus(input);
        assertNull(output);
    }

    @Test
    public void toPaymentTest() {
        String input = new Gson().toJson(new Payment());
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.toStatus(input);
        assertTrue(output instanceof Payment);
    }

    @Test
    public void fromStyleNullTest() {
        Style style = null;
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.fromStyle(style);
        assertNull(output);
    }

    @Test
    public void fromStyleTest() {
        Style style = mock(Style.class);
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.fromStyle(style);
        assertTrue(output instanceof String);
    }

    @Test
    public void toStyleNullTest() {
        String input = null;
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.toStyle(input);
        assertNull(output);
    }

    @Test
    public void toStyleTest() {
        String input = new Gson().toJson(new Style());
        DataConverter dataConverter = new DataConverter();
        Object output = dataConverter.toStyle(input);
        assertTrue(output instanceof Style);
    }
}


