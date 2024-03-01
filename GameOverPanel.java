import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class GameOverPanel extends JPanel implements MouseListener, ActionListener{
  JButton button1 = new JButton("リトライ！");
  JButton button2 = new JButton("タイトルに戻る");
  ViewControll viewControll;

  public GameOverPanel(ViewControll vc){
    viewControll = vc;

    //GameOverのラベル
    JLabel label = new JLabel("***Game Over***", JLabel.CENTER);
    label.setFont(new Font("Century", Font.ITALIC, 60));
    label.setForeground(Color.white);
    label.setPreferredSize(new Dimension(200, 200));
    this.add(label);

    //ボタンの配置
    JPanel panel = new JPanel();
    JLabel blank = new JLabel(" ");
    panel.setBackground(new Color(54,90,149));
    button1.setBorder(new LineBorder(Color.WHITE, 3, false));
    button2.setBorder(new LineBorder(Color.WHITE, 3, false));
    button1.setForeground(Color.WHITE);
    button2.setForeground(Color.WHITE);
    button1.setBackground(new Color(54,90,149));
    button2.setBackground(new Color(54,90,149));
    button1.addActionListener(this);
    button2.addActionListener(this);
    button1.addMouseListener(this);
    button2.addMouseListener(this);
    button1.setPreferredSize(new Dimension(200, 70));
    button2.setPreferredSize(new Dimension(200, 70));
    panel.setLayout(new FlowLayout());
    panel.add(button1);
    panel.add(blank);
    panel.add(button2);

    this.setLayout(null);
    this.setLayout(new GridLayout(2,1));
    this.add(label);
    this.add(panel);
    this.setSize(800, 600);
    this.setBackground(new Color(54,90,149));
  }

  //Buttonの役割
  public void actionPerformed(ActionEvent e){
    if(e.getSource() == button1 && viewControll.stagecode == 1){
      viewControll.PanelChange("gameover","gameView1");
    }else if(e.getSource() == button1 && viewControll.stagecode == 2){
      viewControll.PanelChange("gameover","gameView2");
    }else if(e.getSource() == button1 && viewControll.stagecode == 3){
      viewControll.PanelChange("gameover","gameView3");
    }else if(e.getSource() == button2){
      viewControll.PanelChange("gameover", "titlePage");
    }
  }

  //カーソル操作
  public void mouseClicked(MouseEvent e){
    
  }
  public void mousePressed(MouseEvent e){
  
  }
  public void mouseDragged(MouseEvent e){
    
  }
  public void mouseReleased(MouseEvent e){
    
  }
  public void mouseEntered(MouseEvent e){
    if(e.getSource() == button1){
      button1.setForeground(Color.YELLOW);
      button1.setBackground(new Color(54,90,149));
    }else if(e.getSource() == button2){
      button2.setForeground(Color.YELLOW);
      button2.setBackground(new Color(54,90,149));
    }
    
  }
  public void mouseExited(MouseEvent e){
    button1.setForeground(Color.WHITE);
    button2.setForeground(Color.WHITE);
  }
}