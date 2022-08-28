
package com.company;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
public class Main extends Application {

    double[] speed = new double[1];
    int [][] xy = new int [50][2];
    int x , y ;
    private int[] flag =new  int[1];

    public void start(Stage primaryStage) {

        Media mediabutton = new Media(new File("button6.wav").toURI().toString());
        MediaPlayer buttonsound = new MediaPlayer(mediabutton);

        primaryStage.setTitle("Bricks Breaker");
        Pane pane1 = new Pane();
        pane1.setStyle("-fx-background-color: gray;");
        Glow glow = new Glow();
        Reflection ref = new Reflection();
        glow.setLevel(0.9);

        Label label = new Label("Welcome to BRICKS BREAKER");
        label.setTextFill(Color.BISQUE);
        label.setFont(new Font("Arial", 25));
        label.setEffect(ref);
        label.setLayoutX(120);
        label.setLayoutY(50);
        Button startgame = new Button("Start Game");

        startgame.setLayoutX(250);
        startgame.setLayoutY(200);

        Label help = new Label("Hello Please First Go To Settings & Select Game Difficulty");
        help.setTextFill(Color.BISQUE);
        help.setFont(new Font("Arial", 15));
        help.setLayoutX(100);
        help.setLayoutY(400);
        pane1.getChildren().add(help);


        Label AboutMe = new Label("This Game Created By Emad Aghajanzadeh\n" +
        "Project Of Advanced Programming Language" );
        AboutMe.setTextFill(Color.LIGHTCORAL);
        AboutMe.setFont(new Font("Arial", 15));
        AboutMe.setLayoutX(165);
        AboutMe.setLayoutY(650);
        pane1.getChildren().add(AboutMe);


        startgame.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startgame.setLayoutX(startgame.getLayoutX()-20);
                startgame.setTextFill(Color.BLACK);
                startgame.setEffect(null);
            }
        });


        Button settings = new Button("Settings");
        settings.setLayoutX(260);
        settings.setLayoutY(255);
        settings.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settings.setLayoutX(settings.getLayoutX()+20);
                settings.setTextFill(Color.DARKRED);
                settings.setEffect(glow);

            }
        });

        settings.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                settings.setLayoutX(settings.getLayoutX()-20);
                settings.setTextFill(Color.BLACK);
                settings.setEffect(null);
            }
        });

        Pane paneSettings = new Pane();
        Scene sceneSettings = new Scene(paneSettings,600, 700);
        settings.setOnMouseClicked(event -> primaryStage.setScene(sceneSettings));
        paneSettings.setStyle("-fx-background-color: gray;");
        Label labelsettings = new Label("settings");
        labelsettings.setTextFill(Color.BISQUE);
        labelsettings.setFont(new Font("Arial", 25));
        labelsettings.setEffect(ref);
        labelsettings.setLayoutX(250);
        labelsettings.setLayoutY(50);
        paneSettings.getChildren().add(labelsettings);
        Button button = new Button("easy");
        button.setLayoutX(270);
        button.setLayoutY(200);
        paneSettings.getChildren().add(button);
        Button button1 = new Button("medium");
        button1.setLayoutX(260);
        button1.setLayoutY(255);
        paneSettings.getChildren().add(button1);
        Button button2 = new Button("hard");
        button2.setLayoutX(270);
        button2.setLayoutY(310);
        paneSettings.getChildren().add(button2);
        Button back = new Button("Back To Main Menu");
        back.setLayoutX(225);
        back.setLayoutY(365);
        paneSettings.getChildren().add(back);
        pane1.getChildren().add(startgame);
        pane1.getChildren().add(label);
        pane1.getChildren().add(settings);
        Scene scene1 = new Scene(pane1,600, 700);

        button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonsound.play();
                speed[0]=2;
                flag[0]=1;
                Label labeleasy = new Label("Game Difficulty Sets To Easy");
                labeleasy.setLayoutX(200);
                labeleasy.setLayoutY(600);
                paneSettings.getChildren().add(labeleasy);

            }
        });

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonsound.play();
                speed[0]=3;
                flag[0]=1;
                Label labeleasy = new Label("Game Difficulty Sets To Medium");
                labeleasy.setLayoutX(200);
                labeleasy.setLayoutY(600);
                paneSettings.getChildren().add(labeleasy);
            }
        });

        button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                buttonsound.play();
                speed[0]=8;
                flag[0]=1;
                Label labeleasy = new Label("Game Difficulty Sets To Hard");
                labeleasy.setLayoutX(200);
                labeleasy.setLayoutY(600);
                paneSettings.getChildren().add(labeleasy);


            }
        });
     back.setOnMouseClicked(event -> primaryStage.setScene(scene1));
        Button exit = new Button("Exit");
        exit.setLayoutX(275);
        exit.setLayoutY(310);
        exit.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exit.setLayoutX(exit.getLayoutX()+20);
                exit.setText("Good bye");
                exit.setTextFill(Color.DARKRED);
                exit.setEffect(glow);

            }
        });

        exit.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                exit.setLayoutX(exit.getLayoutX()-20);
                exit.setText("Exit");
                exit.setTextFill(Color.BLACK);
                exit.setEffect(null);
            }
        });

        pane1.getChildren().add(exit);
        primaryStage.setScene(scene1);
        primaryStage.show();
        Pane pane =new Pane();
        Scene scene = new Scene(pane , 1000 , 700);
        pane.setStyle("-fx-background-color: Darkgray;");
        startgame.setOnMouseClicked(event -> primaryStage.setScene(scene));
         breaks[] rectangle = new breaks[50];
        for(int i = 0 ; i < 30 ; i++){
            rectangle[i] = new breaks();
        }
         rectangle[0].setPane(pane);
         rectangle[0].setScene(scene);
         rectangle[0].drawrect(0 ,0);
         xy[0][0]=25;
         xy[0][1]=15;

        for(int i = 1 ; i < 30 ; i++)
        {
            rectangle[i].setPane(pane);
            rectangle[i].setScene(scene);
            if(i>=10) {
                x=i*100;
                y=(Math.floorDiv(x,1000))*60;
                x= x-(Math.floorDiv(x , 1000))*1000;
                xy[i][0]=(x+25);
                xy[i][1]=(y+15);
            } else {
                x=i*100;
                y=0;
                xy[i][0]=(x+25);
                xy[i][1]=(y+15);
            }
            rectangle[i].drawrect(x,y);
        }

        racket emad2 = new racket();
        emad2.setPane(pane);
        emad2.setScene(scene);
        emad2.drawracket();
        emad2.racketmotion();

        ball emad1 = new ball();
        emad1.setPane(pane);
        emad1.setScene(scene);
        emad1.drawcircle();
        emad1.setpoints();
        emad1.setRacketwidth(emad2.getRacketwidth());
        emad1.getBreak(rectangle);

        primaryStage.getIcons().add(new Image("file:bricks.png"));


        new AnimationTimer(){
            @Override
            public void handle(long now) {
        emad1.getracketposition(emad2.getCoordinates());
            }

        }.start();
        startgame.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                startgame.setLayoutX(startgame.getLayoutX()+20);
                startgame.setTextFill(Color.DARKRED);
                startgame.setEffect(glow);
                if(flag[0]==1)
                emad1.circlemotion(xy,speed);
            }
        });
        new AnimationTimer(){
            @Override
            public void handle(long now) {
               emad2.setRacketWidth(emad1.Return_Racket_Width());

            }
        }.start();
    }





    public static void main(String[] args) {
        launch(args);
    }

}










