package com.pay.payo.persistence;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pay.payo.model.Identification;
import com.pay.payo.model.Interaction;
import com.pay.payo.model.Links;
import com.pay.payo.model.Networks;
import com.pay.payo.model.Payment;
import com.pay.payo.model.ReturnCode;
import com.pay.payo.model.Status;
import com.pay.payo.model.Style;

import java.lang.reflect.Type;

import androidx.room.TypeConverter;

public class DataConverter {

    //Status
    @TypeConverter
    public String fromStatus(Status status) {
        if (status == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Status>() {
        }.getType();
        String json = gson.toJson(status, type);
        return json;
    }

    @TypeConverter
    public Status toStatus(String status) {
        if (status == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Status>() {
        }.getType();
        Status st = gson.fromJson(status, type);
        return st;
    }

    //Payment
    @TypeConverter
    public String fromPayment(Payment payment) {
        if (payment == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Payment>() {
        }.getType();
        String json = gson.toJson(payment, type);
        return json;
    }

    @TypeConverter
    public Payment toPayment(String payment) {
        if (payment == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Payment>() {
        }.getType();
        Payment pay = gson.fromJson(payment, type);
        return pay;
    }

    //Style
    @TypeConverter
    public String fromStyle(Style style) {
        if (style == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Style>() {
        }.getType();
        String json = gson.toJson(style, type);
        return json;
    }

    @TypeConverter
    public Style toStyle(String style) {
        if (style == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Style>() {
        }.getType();
        Style styles = gson.fromJson(style, type);
        return styles;
    }

    //Links
    @TypeConverter
    public String fromLinks(Links links) {
        if (links == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Links>() {
        }.getType();
        String json = gson.toJson(links, type);
        return json;
    }

    @TypeConverter
    public Links toLinks(String links) {
        if (links == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Links>() {
        }.getType();
        Links link = gson.fromJson(links, type);
        return link;
    }

    //Interaction
    @TypeConverter
    public String fromInteraction(Interaction interaction) {
        if (interaction == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Interaction>() {
        }.getType();
        String json = gson.toJson(interaction, type);
        return json;
    }

    @TypeConverter
    public Interaction toInteraction(String interaction) {
        if (interaction == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Interaction>() {
        }.getType();
        Interaction interactions = gson.fromJson(interaction, type);
        return interactions;
    }

    //Identification
    @TypeConverter
    public String fromIdentification(Identification identification) {
        if (identification == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Identification>() {
        }.getType();
        String json = gson.toJson(identification, type);
        return json;
    }

    @TypeConverter
    public Identification toIdentification(String id) {
        if (id == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Identification>() {
        }.getType();
        Identification ids = gson.fromJson(id, type);
        return ids;
    }

    //Networks
    @TypeConverter
    public String fromNetworks(Networks networks) {
        if (networks == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Networks>() {
        }.getType();
        String json = gson.toJson(networks, type);
        return json;
    }

    @TypeConverter
    public Networks toNetworks(String networks) {
        if (networks == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<Networks>() {
        }.getType();
        Networks nets = gson.fromJson(networks, type);
        return nets;
    }

    //ReturnCode
    @TypeConverter
    public String fromReturnCode(ReturnCode returnCode) {
        if (returnCode == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ReturnCode>() {
        }.getType();
        String json = gson.toJson(returnCode, type);
        return json;
    }

    @TypeConverter
    public ReturnCode toReturnCode(String returnCode) {
        if (returnCode == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ReturnCode>() {
        }.getType();
        ReturnCode data = gson.fromJson(returnCode, type);
        return data;
    }

}