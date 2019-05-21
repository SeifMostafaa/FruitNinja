package Game;

import Interfaces.IStrategy;
import factory.Fruits;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Context {
    IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void doTime(Group group, Label label, Stage stage,GameOver gameOver){
        strategy.dotime(group,label,stage,gameOver);
    }
    public void addFruit(Group group){
        strategy.addfruit(group);
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
    public void SliceFruit(Node chosen){
        strategy.SliceFruit(chosen);
    }
    public int getSeconds(){
        return strategy.getSeconds();
    }
    public void resetGame(){strategy.ResetGame();}

}
