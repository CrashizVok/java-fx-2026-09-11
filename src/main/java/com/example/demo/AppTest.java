package com.example.demo;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @BeforeClass // test init
    public static void initJavaFX() {
        try {
            Platform.startup(() -> {});
        } catch (IllegalStateException e) {
        }
    }

    @Test
    public void testHozzaadAndKivalaszt() {
        HelloController controller = new HelloController();

        controller.listView = new ListView<>();
        controller.radioPiros = new RadioButton();
        controller.radioZold = new RadioButton();
        controller.radioKek = new RadioButton();
        controller.radioNegyzet = new RadioButton();
        controller.radioKor = new RadioButton();
        controller.radioHaromszog = new RadioButton();
        controller.label = new Label();
        controller.image = new ImageView();

        controller.initialize();

        if (controller.nowAvailable != null) {
            controller.nowAvailable.clear();
        }

        controller.radioPiros.setSelected(true);
        controller.radioZold.setSelected(false);
        controller.radioKek.setSelected(false);

        controller.radioNegyzet.setSelected(false);
        controller.radioKor.setSelected(false);
        controller.radioHaromszog.setSelected(true);

        controller.hozzaadFunction();

        assertEquals(1, controller.data.size());
        assertEquals("Piros + Háromszög", controller.data.getFirst());
    }

    @Test
    public void testTorolFunction() {
        HelloController controller = new HelloController();

        controller.listView = new ListView<>();
        controller.radioPiros = new RadioButton();
        controller.radioZold = new RadioButton();
        controller.radioKek = new RadioButton();
        controller.radioNegyzet = new RadioButton();
        controller.radioKor = new RadioButton();
        controller.radioHaromszog = new RadioButton();
        controller.label = new Label();
        controller.image = new ImageView();

        controller.initialize();

        if (controller.nowAvailable != null) {
            controller.nowAvailable.clear();
        }

        controller.radioPiros.setSelected(true);
        controller.radioZold.setSelected(false);
        controller.radioKek.setSelected(false);

        controller.radioNegyzet.setSelected(false);
        controller.radioKor.setSelected(false);
        controller.radioHaromszog.setSelected(true);

        controller.hozzaadFunction();
        assertEquals(1, controller.data.size());

        controller.listView.getSelectionModel().select(0);
        controller.torolFunction();

        assertEquals(0, controller.data.size());
    }

    @Test
    public void testSzines() {
        HelloController controller = new HelloController();

        controller.listView = new ListView<>();
        controller.radioPiros = new RadioButton();
        controller.radioZold = new RadioButton();
        controller.radioKek = new RadioButton();
        controller.radioNegyzet = new RadioButton();
        controller.radioKor = new RadioButton();
        controller.radioHaromszog = new RadioButton();
        controller.label = new Label();
        controller.image = new ImageView();

        controller.initialize();
        controller.setZold();
        controller.setKek();
        controller.setKor();
        controller.setNegyzet();

        controller.save();

        controller.radioPiros.setSelected(true);
        controller.radioNegyzet.setSelected(true);
        controller.hozzaadFunction();

        if (!controller.data.isEmpty()) {
            controller.listView.getSelectionModel().select(0);
            controller.torolFunction();
        }
    }
}