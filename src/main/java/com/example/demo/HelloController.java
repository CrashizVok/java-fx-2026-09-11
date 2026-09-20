package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

public class HelloController {
    ObservableList<String> nowAvailable = FXCollections.observableArrayList();
    ObservableList<String> data = FXCollections.observableArrayList();

    @FXML
    private ListView<String> listView;

    @FXML
    private RadioButton radioPiros, radioZold, radioKek, radioNegyzet, radioKor, radioHaromszog;

    @FXML
    private ImageView image;

    @FXML
    private Label label;

    @FXML
    public void initialize() {
        listView.setItems(data);

        if (!radioPiros.isSelected() && !radioZold.isSelected() && !radioKek.isSelected()) {
            radioPiros.setSelected(true);
        }
        if (!radioNegyzet.isSelected() && !radioKor.isSelected() && !radioHaromszog.isSelected()) {
            radioNegyzet.setSelected(true);
        }

        if (radioPiros.isSelected()) {
            setPiros();
        } else if (radioZold.isSelected()) {
            setZold();
        } else if (radioKek.isSelected()) {
            setKek();
        }

        if (radioNegyzet.isSelected()) {
            setNegyzet();
        } else if (radioKor.isSelected()) {
            setKor();
        } else if (radioHaromszog.isSelected()) {
            setHaromszog();
        }
    }

    protected void megjelenit(){
        data.clear();

        try{
            for (int i = 0; i+1 < nowAvailable.size(); i = i+2){
                String line = nowAvailable.get(i) + " + " + nowAvailable.get(i+1);

                data.add(line);

                //listView.setItems(data);

                System.out.println(nowAvailable.get(i) + " + " + nowAvailable.get(i+1));
            }
        }catch (Exception e){
            System.out.println("################");
        }
    }

    @FXML
    protected void hozzaadFunction() {
        getColorRadio();
        getShaved();
        megjelenit();
        listView.setItems(data);
        //System.out.println(nowAvailable);

    }
    @FXML
    protected void torolFunction(){
        data.clear();
        nowAvailable.clear();
        megjelenit();
    }

    protected void getColorRadio(){
        if (radioKek.isSelected()){
            nowAvailable.add("Kék");
            //nowAvailable.set(nowAvailable.size()-1, "Kék");
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

    @FXML
    protected void setPiros(){
        label.setStyle("-fx-background-color: #ff0000; -fx-border-color: black;");
    }
    @FXML
    protected void setZold(){
        label.setStyle("-fx-background-color: #00ff00; -fx-border-color: black;");
    }
    @FXML
    protected void setKek(){
        label.setStyle("-fx-background-color: #0000ff; -fx-border-color: black;");
    }
    @FXML
    protected void setNegyzet(){
        image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/negyzet.png"))));
    }
    @FXML
    protected void setKor(){
        image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/kor.png"))));
    }
    @FXML
    protected void setHaromszog(){
        image.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/assets/haromszog.png"))));
    }

    @FXML
    protected void save(){
        System.out.println(data);
    }
}

