package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.Arrays;

public class HelloController {
    ArrayList<String> nowAvailable = new ArrayList<>();

    @FXML
    private RadioButton radioPiros, radioZold, radioKek, radioNegyzet, radioKor, radioHaromszog;

    @FXML
    protected void hozzaadFunction() {
        getColorRadio();
        getShaved();

        System.out.println(nowAvailable);

    }

    protected void getColorRadio(){
        if (radioKek.isSelected()){
            nowAvailable.add("Kék");
        }
        else if(radioZold.isSelected()){
            nowAvailable.add("Zöld");
        }
        else if(radioPiros.isSelected()){
            nowAvailable.add("Piros");
        }
        else {
            System.out.println("Nagy baj van");
        }
    }

    protected void getShaved(){
        if (radioNegyzet.isSelected()){
            nowAvailable.add("Négyzet");
        }
        else if (radioKor.isSelected()) {
            nowAvailable.add("Kör");
        }
        else if (radioHaromszog.isSelected()) {
            nowAvailable.add("Háromszög");
        }
        else {
            System.out.println("Nagy baj van, megint");
        }
    }

    protected void setBackground(){

    }
}