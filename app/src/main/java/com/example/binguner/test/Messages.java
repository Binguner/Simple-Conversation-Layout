package com.example.binguner.test;

/**
 * Created by binguner on 2018/1/3.
 */

public class Messages {
    private String msg;
    private int type;

    public String getMessage(){
        return msg;
    }

    public void setMessage(String msg){
        this.msg = msg;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Messages(String msg, int type) {
        this.msg = msg;
        this.type = type;
    }
}
