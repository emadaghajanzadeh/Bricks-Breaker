package com.company;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.Random;


public class brick {


    private Pane pane = new Pane();
    private Scene scene = new Scene(pane, 1000, 1000);
    private  javafx.scene.shape.Rectangle rectangle2;
    private Text tx = new javafx.scene.text.Text();
    private  int number =4;
    private boolean is_special;
    public void setScene(Scene scene1) {
        scene = scene1;
    }

    public Scene getScene() {
        return scene;
    }

    public void setPane(Pane pane1)
    {
        pane = pane1;

    }
    public Pane getPane() {
        return pane;
    }
    {
        settext(number);
    }

    public void settext(int num){
        String temp ;
        Integer number = new Integer(num);
        temp = number.toString();
        tx.setText(temp);
        this.number=num;

    }

    public void closetext(){
        tx.setText(null);
    }

    public int getNumber(){
        return number;
    }

    public void drawrect(int x , int  y )
    {

        double rannum = 0;

        Random random = new Random();
        rannum = random.nextDouble();
        if (rannum > 0.89) {
           rectangle2 = new Rectangle(x, y, 50, 30);
            rectangle2.setFill(Color.DARKMAGENTA);
            rectangle2.setStroke(Color.BLACK);
            tx.setLayoutX(x+18);
            tx.setLayoutY(y+20);
            pane.getChildren().addAll(rectangle2,tx);
            is_special=true;

        }
        else{

            rectangle2 = new Rectangle(x, y, 50, 30);
            rectangle2.setFill(Color.GREEN);
            rectangle2.setStroke(Color.BLACK);
            tx.setLayoutX(x+18);
            tx.setLayoutY(y+20);
            pane.getChildren().addAll(rectangle2,tx);
            is_special=false;
            }
        }

public void setColor(){
        rectangle2.setFill(Color.BISQUE);

}
public void removebrick(){
        pane.getChildren().remove(rectangle2);
}

public boolean is_special(brick bricks){
        if(bricks.is_special)
            return true;
        else
            return false;
}

    }











