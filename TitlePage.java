import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class TitlePage extends JPanel implements MouseListener, ActionListener{
  JButton button1 = new JButton("はじめる");
  ViewControll viewControll;

  public TitlePage(ViewControll vc){
    viewControll = vc;
    //ゲーム名の表示
    JLabel label = new JLabel("～野良猫にゃん吉の冒険～", JLabel.CENTER);
    label.setBackground(Color.BLACK);
    label.setFont(new Font("Serif", Font.BOLD, 60));
    label.setForeground(Color.white);
    label.setBounds(400, 300, 200, 200);
    this.add(label);
    
    //ボタン配置(パネルに配置)
    JPanel panel = new JPanel();
    panel.setBackground(new Color(54,90,149));
    button1.setForeground(Color.WHITE);
    button1.setBackground(new Color(54,90,149));
    button1.setBorderPainted(false);
    panel.add(button1, BorderLayout.CENTER);
    button1.addMouseListener(this);
    button1.addActionListener(this);
    button1.setPreferredSize(new Dimension(200, 70));
    button1.setFont(new Font("Monospaced", Font.BOLD, 30));
    this.add(panel);

    this.setSize(800, 600);
    this.setLayout(null);
    this.setLayout(new GridLayout(2,1));
    this.setBackground(new Color(54,90,149));
  }

  public void mouseClicked(MouseEvent e){
    
  }
  public void mousePressed(MouseEvent e){
  
  }
  public void mouseDragged(MouseEvent e){
    
  }
  public void mouseReleased(MouseEvent e){
    
  }
  public void mouseEntered(MouseEvent e){
    button1.setForeground(Color.YELLOW);
    button1.setBackground(new Color(54,90,149));
  }
  public void mouseExited(MouseEvent e){
    button1.setForeground(Color.WHITE);
  }

  public void actionPerformed(ActionEvent e) {
    viewControll.PanelChange("titlePage", viewControll.PanelControll[1]);
  }
  
}