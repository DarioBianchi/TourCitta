package com.example.bianc.tourcitta;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by bianc on 20/06/2017.
 */

public class Comments {
    private String utente, msg;
    private long data;
    public Comments(){

    }
    public Comments(String mUtente, String mMsg, long mData){
        this.utente=mUtente;
        this.msg=mMsg;
        this.data=mData;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    @Override
    public String toString() {
        String startDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date(data));
        return startDate +"\n" + utente + "\n" + msg;
    }
}
