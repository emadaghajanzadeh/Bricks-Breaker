package com.company;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.awt.*;
public class racket {

    private Scene scene;
    private Pane pane;
    private boolean goWest, goEast, run;
    private double coordinates;
    private int racketwidth = 130 ;
    Rectangle rect = new Rectangle(500, 650, racketwidth, 5);

    public void setRacketWidth(int racketwidth){
        this.racketwidth =racketwidth;
        rect.setWidth(racketwidth);
    }


    public void setScene(Scene scene1) {
        scene = scene1;
    }

    public Scene getScene() {
        return scene;
    }


    public void setPane(Pane pane1) {
        pane = pane1;
    }

    public Pane getPane() {
        return pane;
    }


    public void drawracket() {
        rect.setFill(Color.GRAY);
        rect.setStroke(Color.BLACK);
        pane.getChildren().add(rect);

    }

    public void racketmotion() {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                switch (event.getCode()) {

                    case LEFT:
                        goWest = true;
                        break;
                    case RIGHT:
                        goEast = true;
                        break;
                    case SPACE:
                        run = true;
                        break;

                }
                if (goWest) {
                    rect.setLayoutX(rect.getLayoutX() - 20);
                    setCoordinates(rect.getLayoutX());
                } else if (goEast) {
                    rect.setLayoutX(rect.getLayoutX() + 20);
                    setCoordinates(rect.getLayoutX());
                }
            }


        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {

                    case LEFT:
                        goWest = false;
                        break;
                    case RIGHT:
                        goEast = false;
                        break;
                    case SPACE:
                        run = true;
                        break;

                }

            }


        });

        scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if ((MouseInfo.getPointerInfo().getLocation().x) - 1360 > rect.getLayoutX()) {
                    while ((MouseInfo.getPointerInfo().getLocation().x) - 1360 > rect.getLayoutX()) {
                        rect.setLayoutX(rect.getLayoutX() + 0.03);
                        setCoordinates(rect.getLayoutX());
                    }
                } else if ((MouseInfo.getPointerInfo().getLocation().x) - 1360 < rect.getLayoutX())
                    while ((MouseInfo.getPointerInfo().getLocation().x) - 1360 < rect.getLayoutX()) {
                        //System.out.println((MouseInfo.getPointerInfo().getLocation().x));
                        rect.setLayoutX(rect.getLayoutX() - 0.03);
                        setCoordinates(rect.getLayoutX());
                    }
            }
        });
    }


    public void setCoordinates(double coordiantes ){
        this.coordinates = coordiantes;
    }


    public double getCoordinates(){
        return  coordinates;
    }

    public int getRacketwidth(){
        return racketwidth;
    }


}
