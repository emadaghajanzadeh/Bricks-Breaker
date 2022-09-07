package com.company;
import java.io.File;
import java.io.FileWriter;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.util.Random;

public class ball {
    private Scene scene ;
    private Pane pane ;
    private double[] speed = new double[2];
    private double racketx;
    private double d;
    private brick[] bricks = new brick[30];
    private int[] number = new int [30];
    private int Racketwidth=130;
    private int sumofpoints ;
    private int[] x = new int[1];
    private int[] y = new int[1];
    private double[] CopyOfV = new double[1];
    private Boolean[] checkhgift = new Boolean[3];
    private double rannum = 0;
    private long totalTime;
    private Text textofpoints = new Text("Points: "+ 0);
    Random random = new Random();
    javafx.scene.shape.Circle circle = new Circle(500, 500, 10);

    public void setScene(Scene scene1){
        scene = scene1;
    }
    public Scene getScene(){
        return scene;
    }
    public void setPane(Pane pane1){
        pane = pane1;
    }
    public Pane getPane(){
        return pane;
    }
    void getbrick(brick[] brick){
        for(int i = 0 ; i<30 ; i++){
            this.bricks[i] = brick[i];
        }
    }
    private void gameover(long startTime , int sumofpoints){
        long endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        totalTime/=1000000000;
        Integer timeamount = new Integer((int)totalTime);
        Integer sumamount = new Integer((int)sumofpoints);
        String timestring = new String("Total Time : "+timeamount.toString());
        Text time = new Text(timestring);
        time.setFont(new Font("Arial", 15));
        time.setFill(Color.DARKRED);
        time.setLayoutY(0);
        time.setLayoutX(450);
        pane.getChildren().add(time);


        Text gameover = new Text("GAME OVER");
        gameover.setFill(Color.DARKRED);
        gameover.setFont(new Font("Arial", 25));
        gameover.setLayoutX(420);
        gameover.setLayoutY(-30);
        pane.getChildren().add(gameover);
        new AnimationTimer(){
            @Override
            public void handle(long now) {
                gameover.setLayoutY(gameover.getLayoutY()+10);
                time.setLayoutY(time.getLayoutY()+10);
                if(gameover.getLayoutY()==300 && time.getLayoutY()==330){
                    Text result = new Text(370 , 360 ,"Your Score Has Been Saved In Result File");
                    result.setFont(new Font("Arial", 14));
                    result.setFill(Color.DARKCYAN);
                    pane.getChildren().add(result);
                    this.stop();
                }
            }
        }.start();
        try{
            FileWriter fw=new FileWriter("results.txt");
            String result = new String("\rBricks Breaker points :\r\r\r\r\r"  + timestring +"\n\nPoints : "+sumamount.toString() );
            fw.write("Bricks Breaker points ");
            fw.write(System.getProperty("line.separator"));
            fw.write(timestring);
            fw.write(System.getProperty("line.separator"));
            fw.write("Points : "+sumamount.toString());
            fw.close();
        }catch(Exception e){System.out.println(e);}
    }
    public void setRacketwidth(int Racketwidth){
        this.Racketwidth=Racketwidth;
    }
    public void drawcircle(){
        circle.setFill(Color.BLUE);
        circle.setStroke(Color.BLACK);
        pane.getChildren().add(circle);

    }
    public void setpoints(){
        textofpoints.setFont(new Font("Arial", 25));
        textofpoints.setLayoutY(680);
        textofpoints.setLayoutX(70);
        textofpoints.setFill(Color.ORANGERED);
        pane.getChildren().add(textofpoints);
    }
    public void circlemotion(int[][] ab , double[] v){
            long startTime = System.nanoTime();
            Media media = new Media(new File("06.mp3").toURI().toString());
            Media mediabutton = new Media(new File("button6.wav").toURI().toString());
            MediaPlayer mp = new MediaPlayer(media);
            MediaPlayer buttonsound = new MediaPlayer(mediabutton);
            mp.play();
            CopyOfV[0] = v[0];
            speed[0]= v[0];
            speed[1]=0;
            gift emad1 = new gift();

            for(int p = 0 ; p<3 ; p++){
                checkhgift[p]=false;
            }
       new AnimationTimer(){
           @Override
           public void handle(long now) {

               circle.setLayoutY(circle.getLayoutY()-speed[0]*3);
               circle.setLayoutX(circle.getLayoutX()-speed[1]*3);
               for(int i = 0 ; i<30 ; i++){
                       if(Math.abs(circle.getLayoutX()-(ab[i][0]-500))<=25 && Math.abs((circle.getLayoutY()-10)-(ab[i][1]-500))<=15 ){
                           x[0]=ab[i][0];
                           y[0]=ab[i][1];
                          number[i] =  bricks[i].getNumber();
                          number[i]--;
                           bricks[i].settext(number[i]);
                            if(number[i]==0){
                                bricks[i].removebrick();
                                ab[i][0]=-500;
                                bricks[i].closetext();
                                if(bricks[i].is_special(bricks[i]))
                                {
                                    sumofpoints += (emad1.points());
                                    Racketwidth = emad1.WidthOfBall(130);
                                    rannum = random.nextDouble();
                                    if(rannum<0.35){
                                        emad1.gift1(20);
                                    }
                                    if(rannum>0.35 && rannum<0.65){     //vof balls
                                        emad1.gift2(15);
                                        v[0] = emad1.vOfBall(CopyOfV[0]);
                                    }
                                    if(rannum>0.65) {                    //width of tacket
                                        emad1.gift3(10);
                                        Racketwidth *= 2 ;
                                    }
                                }
                                else
                                {
                                        sumofpoints += emad1.points();
                                }
                                v[0] = emad1.vOfBall(CopyOfV[0]);
                                Racketwidth = emad1.WidthOfBall(130);
                                new AnimationTimer(){
                                    @Override
                                    public void handle(long now) {
                                        textofpoints.setText("Points: "+ new Integer(sumofpoints));
                                    }
                                }.start();
                            }
                           speed[0] *= (-1);
                       }
               }
               if(circle.getLayoutY()<=-500){
                   speed[0] *= -1 ;
               }
               if(circle.getLayoutY()>=200){
                    this.stop();
                    mp.stop();
                    gameover(startTime , sumofpoints);
               }

               if(circle.getLayoutX()>=500){
                   speed[1] *= -1 ;
               }

               if(circle.getLayoutX()<-500){
                   speed[1] *= -1 ;
               }

               if((circle.getLayoutX()-racketx)<=Racketwidth &&  circle.getLayoutX()-racketx>=0 && circle.getLayoutY()>=150 && circle.getLayoutY()<=160+v[0]){
                       buttonsound.play();
                       d=circle.getLayoutX()-racketx;
                       if(d<=((Racketwidth)/2)){
                              d *= (60.0/((Racketwidth)/2));
                              d += 30 ;
                              d = (d*Math.PI)/180;
                             speed[1] =  v[0]*Math.cos(d);
                             speed[0] =  v[0]*Math.sin(d);
                  }
                       if(d>65){
                               d *= (60.0/((Racketwidth)/2));
                               d += 30 ;
                               d = (d*Math.PI)/180;
                               speed[1] =  v[0]*Math.cos(d);
                               speed[0] =  v[0]*Math.sin(d);
                   }
                       buttonsound.stop();
               }
           }

       }.start();
         };




    public void getracketposition(double racketx){
        this.racketx=racketx;
    }
     public int Return_Racket_Width(){
        return Racketwidth ;
     }

 }

