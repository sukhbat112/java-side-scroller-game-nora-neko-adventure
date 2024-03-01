import java.awt.event.*;

class PlayerController implements KeyListener{
  protected GameManager GM;
  public PlayerController(GameManager gm){
    GM = gm;
  }
  public void keyTyped(KeyEvent e){
    if(e.getKeyChar() == 'j'){
      GM.Move(3);
    }
    if(e.getKeyChar() == 'w'){
      GM.Move(3);
    }
  }
  

  public void keyPressed(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      GM.Move(1);
    }
    if(e.getKeyChar() == 'd'){
      GM.Move(1);
    }

    if(e.getKeyCode() == KeyEvent.VK_LEFT){
      GM.Move(2);
    }
    if(e.getKeyChar() == 'a'){
      GM.Move(2);
    }
  }

  public void keyReleased(KeyEvent e){
    if(e.getKeyCode() == KeyEvent.VK_RIGHT){
      GM.Move(0);
    }
    if(e.getKeyChar() == 'd'){
      GM.Move(0);
    }

    if(e.getKeyCode() == KeyEvent.VK_LEFT){
      GM.Move(0);
    }
    if(e.getKeyChar() == 'a'){
      GM.Move(0);
    }
  }

}