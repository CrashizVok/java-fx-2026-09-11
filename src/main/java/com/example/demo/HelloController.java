package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import java.util.Arrays;

public class HelloController {
    String[] nowAvailable = null;

    @FXML
    private RadioButton radioPiros, radioZold, radioKek, radioNegyzet, radioKor, radioHaromszog;

    @FXML
    protected void hozzaadFunction() {
        getColorRadio();
        getShaved();

        System.out.println(Arrays.toString(nowAvailable));

    }

    protected void getColorRadio(){
        if (radioKek.isSelected()){
            nowAvailable[0] = "kek";
        }
        else if(radioZold.isSelected()){
            nowAvailable[0] = "zold";
        }
        else if(radioPiros.isSelected()){
            nowAvailable[0] = "piros";
        }
        else {
            System.out.println("Nagy baj van");
        }
    }

    protected void getShaved(){
        if (radioNegyzet.isSelected()){
            nowAvailable[1] = "negyzet";
        }
        else if (radioKor.isSelected()) {
            nowAvailable[1] = "kor";
        }
        else if (radioHaromszog.isSelected()) {
            nowAvailable[1] = "haromszog";
        }
        else {
            System.out.println("Nagy baj van, megint");
        }
    }
}