package Interfaces;

import Game.GameOver;
import factory.Fruits;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.util.ArrayList;

public interface IStrategy {

    public void MediumDoTime(Group root, Label label, Stage stage, GameOver gameOver, AudioClip audioClip);
    public void EasyDoTime(Group group,Label label,Stage stage,GameOver gameOver,AudioClip audioClip);
    public void HardDoTime(Group group,Label label,Stage stage,GameOver gameOver,AudioClip audioClip);
    public void addEasyFruit(Group root);
    public void addMediumFruit(Group root);
    public void addHardFruit(Group root);
    public void addBomb(Group root);
    public void UpdateScore(Fruits fruits);
    public void AddHearts(HBox hearts);
    public void RemoveHeart();
    public int getScore();
    public void SliceFruit(Node chosen,double x,double y);
    public int getSeconds();
    public int getTime();
    public void ResetGame();
    public void SaveScore();
    public void addCombo();
    public boolean VerifyCombo();
    public void breakCombo();
    public int getCombo();


}
