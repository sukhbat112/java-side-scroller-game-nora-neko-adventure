import javax.swing.*;
import java.awt.*;


class GameView extends JPanel implements Observer{
    public GameManager GM;
    public ViewControll VC;

    public GameView(GameManager gm, PlayerController pc, ViewControll vc, int stagecode){
        this.setBackground(Color.WHITE);
        this.addKeyListener(pc);
        this.setFocusable(true);
        VC = vc;
        GM = gm;
        GM.addObserver(this);
        GM.CreateStage(stagecode);
    }

    public void reGameView(int code){
        GM.CreateStage(code);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        GM.GetBG().draw(g);
        for(int i = 0; i < GM.GetColBlockNum(); i++){
            for(int j = 0; j < GM.GetRowBlockNum(); j++){
                GM.GetStageObjects()[i][j].draw(g);
            }
        }
        GM.GetPlayer().draw(g);
    }

    public void update(Observable o,Object arg){
        if(GM.GetGameState() == 0){
            repaint();
        } else if(GM.GetGameState() == 1){
            VC.PanelChange("gameView", "gameclear");
        } else {
            VC.PanelChange("gameView", "gameover");
        }
    }
}