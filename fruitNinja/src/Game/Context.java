package Game;

import Interfaces.IStrategy;
import factory.Fruits;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class Context {
    IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void EasyDoTime(Group group, Label label, Stage stage, GameOver gameOver, AudioClip audioClip){
        strategy.EasyDoTime(group,label,stage,gameOver,audioClip);
    }
    public void MediumDoTime(Group group, Label label, Stage stage,GameOver gameOver,AudioClip audioClip){
        strategy.MediumDoTime(group,label,stage,gameOver,audioClip);
    }
    public void HardDoTime(Group group, Label label, Stage stage,GameOver gameOver,AudioClip audioClip){
        strategy.HardDoTime(group,label,stage,gameOver,audioClip);
    }
    public void addEasyFruit(Group group){
        strategy.addEasyFruit(group);
    }
    public void addMediumFruit(Group group){
        strategy.addMediumFruit(group);
    }
    public void addHardFruit(Group group){
        strategy.addHardFruit(group);
    }
    public void addBomb(Group group){
        strategy.addBomb(group);
    }
    public void UpdateScore(Fruits fruits){
        strategy.UpdateScore(fruits);
    }
    public void AddHearts(HBox hearts){
        strategy.AddHearts(hearts);
    }
    public void RemoveHeart(){
        strategy.RemoveHeart();
    }
    public int getScore(){
        return strategy.getScore();
    }
    public void SliceFruit(Node chosen,double x,double y){
        strategy.SliceFruit(chosen,x,y);
    }
    public int getSeconds(){
        return strategy.getSeconds();
    }
    public void resetGame(){strategy.ResetGame();}
    public void addCombo(){strategy.addCombo();}
    public boolean VerifyCombo(){return strategy.VerifyCombo();}
    public int getCombo(){return strategy.getCombo();}
    public void breakCombo(){strategy.breakCombo();}

}
