package com.company;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import java.util.Timer;
import java.util.TimerTask;

public  class  gift {
    private Scene scene;
    private Pane pane;
    private int[] timercheck = new int[3];
    public int[] flag = new int[3];
    public int[] o = new int[3];
    {
        o[0] = 1;
        o[1] = 1;
        flag[0]=0;
        flag[1]=0;
        flag[2]=0;
    }

    public int points() {
        if (flag[0] == 1)
            return 20 * 2;
        else
            return 20;
    }
    public double vOfBall(double v) {
        if (flag[1] == 1)
            return v/2 ;
        else
            return v;
    }

    public int WidthOfBall(int len){
        if(flag[2]==1)
            return len*2 ;
        else
            return len ;
    }

    public void gift2(int t) {
        flag[1] = 1;
        timercheck[1] = 1;
        Reminder time = new Reminder(t, timercheck[1]);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                timercheck[1] = time.o;
                if (timercheck[1] == 0) {
                    flag[1] = 0;
                }
            }
        }.start();
    }

    public void gift3(int t) {
        flag[2] = 1;
        timercheck[2] = 1;
        Reminder time = new Reminder(t, timercheck[2]);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                timercheck[2] = time.o;
                if (timercheck[2] == 0) {
                    flag[2] = 0;
                }
            }
        }.start();
    }


    public void gift1(int t) {
        flag[0] = 1;
        timercheck[0] = 1;
        Reminder time = new Reminder(t, timercheck[0]);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                timercheck[0] = time.o;
                if (timercheck[0] == 0) {
                    flag[0] = 0;
                }
            }
        }.start();
    }



     class Reminder {
        Timer timer;
       public int o ;

        public Reminder(int seconds , int o) {
            timer = new Timer();
            timer.schedule(new RemindTask(), seconds*1000);
            this.o=o;

        }

        class RemindTask extends TimerTask {
            public void run() {
                o=0;
                System.out.println("finish");
                timer.cancel(); //Terminate the timer thread
            }

        }



}}
