import javax.swing.*;
import java.awt.*;

public class ViewControll extends JFrame{
  public String[] PanelControll = {"titlePage", "courseSelection", "gameView1", "gameView2", "gameView3", "gameover", "gameclear"};
  
  //パネル5枚
  TitlePage titlePage = new TitlePage(this);
  CourseSelection courseSelection = new CourseSelection(this);
  GameManager GM = new GameManager();;
  PlayerController PC = new PlayerController(GM);
  GameView gameView = new GameView(GM, PC, this, 1);
  GameOverPanel gameover = new GameOverPanel(this);
  GameClearPanel gameclear = new GameClearPanel(this);

  //ステージの管理
  public int stagecode = 1;

  public ViewControll(){
    //パネルの登録
    this.add(titlePage);
    this.add(courseSelection);
    this.add(gameover);
    this.add(gameclear);
    this.add(gameView);
    titlePage.setVisible(true);
    courseSelection.setVisible(false);
    gameView.setVisible(false);
    gameover.setVisible(false);
    gameclear.setVisible(false);

    //JFrame設定
    this.setTitle("Game");
    this.setSize(800, 600);
    this.setBackground(Color.BLACK);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setVisible(true);
  }

  //画面遷移
  public void PanelChange(String atname, String toname){
    if(atname == this.PanelControll[0]){
      this.titlePage.setVisible(false);
    }else if(atname == this.PanelControll[1]){
      this.courseSelection.setVisible(false);
    }else if(atname == this.PanelControll[2]){
      this.gameView.setVisible(false);
    }else if(atname == this.PanelControll[3]){
      this.gameView.setVisible(false);
    }else if(atname == this.PanelControll[4]){
      this.gameView.setVisible(false);
    }else if(atname == this.PanelControll[5]){
      this.gameover.setVisible(false);
    }else if(atname == this.PanelControll[6]){
      this.gameclear.setVisible(false);
    }

    if(toname == this.PanelControll[0]){
      this.titlePage.setVisible(true);
    }else if(toname == this.PanelControll[1]){
      this.courseSelection.setVisible(true);
    }else if(toname == this.PanelControll[2]){
      this.gameView.setVisible(true);
      this.gameView.reGameView(1);
      gameView.requestFocusInWindow();
    }else if(toname == this.PanelControll[3]){
      this.gameView.setVisible(true);
      this.gameView.reGameView(2);
      this.stagecode = 2;
      gameView.requestFocusInWindow();
    }else if(toname == this.PanelControll[4]){
      this.gameView.setVisible(true);
      this.gameView.reGameView(3);
      this.stagecode = 3;
      gameView.requestFocusInWindow();
    }else if(toname == this.PanelControll[5]){
      this.gameover.setVisible(true);
    }else if(toname == this.PanelControll[6]){
      this.gameclear.setVisible(true);
    }
  }

  public static void main(String argv[]){
    new ViewControll();
  }
}