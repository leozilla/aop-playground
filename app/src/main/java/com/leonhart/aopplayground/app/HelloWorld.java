package com.leonhart.aopplayground.app;

import com.leonhart.aopplayground.api.Measure;
import com.leonhart.aopplayground.api.Messenger;

public class HelloWorld implements Messenger {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }

    @Measure
    public void getMessage() {
        System.out.println("Your Message : " + message);
    }
}
