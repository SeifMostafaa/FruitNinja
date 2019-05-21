package Interfaces;

import Game.GameOver;
import factory.Fruits;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public interface IStrategy {

    public void dotime(Group root, Label label, Stage stage, GameOver gameOver);
    public void addfruit(Group root);
    public void addBomb(Group root);
    public void UpdateScore(Fruits fruits);
    public void AddHearts(HBox hearts);
    public void RemoveHeart();
    public int getScore();
    public void SliceFruit(Node chosen);
    public int getSeconds();
    public int getTime();
    public void ResetGame();
    public void SaveScore();


}
