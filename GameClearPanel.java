import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

class GameClearPanel extends JPanel implements MouseListener, ActionListener{
  JButton button2 = new JButton("タイトルに戻る");
  ViewControll viewControll;

  public GameClearPanel(ViewControll vc){
    viewControll = vc;

    //GameOverのラベル
    JLabel label = new JLabel("***Game Clear***", JLabel.CENTER);
    label.setFont(new Font("Century", Font.ITALIC, 60));
    label.setForeground(Color.white);
    label.setPreferredSize(new Dimension(200, 200));
    this.add(label);

    //ボタンの配置
    JPanel panel = new JPanel();
    panel.setBackground(new Color(54,90,149));
    panel.setLayout(new GridLayout(1, 2));
    button2.setBorder(new LineBorder(Color.WHITE, 3, false));
    button2.setForeground(Color.WHITE);
    button2.setBackground(new Color(54,90,149));
    button2.addActionListener(this);
    button2.addMouseListener(this);
    button2.setPreferredSize(new Dimension(200, 70));
    panel.setLayout(new FlowLayout());
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
    viewControll.PanelChange("gameclear","titlePage");
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
    button2.setForeground(Color.YELLOW);
    button2.setBackground(new Color(54,90,149));
  }
  public void mouseExited(MouseEvent e){
    button2.setForeground(Color.WHITE);
  }
}