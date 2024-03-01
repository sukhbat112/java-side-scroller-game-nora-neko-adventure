import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CourseSelection extends JPanel implements ActionListener{
  ViewControll viewControll;

  //ボタン生成
  JButton button1 = new JButton("スタート");
  JButton button2 = new JButton("スタート");
  JButton button3 = new JButton("スタート");

  public CourseSelection(ViewControll vc){
    viewControll = vc;
    //コース一覧
    JLabel titlelabel = new JLabel("コース一覧", JLabel.CENTER);
    titlelabel.setFont(new Font("Serif", Font.BOLD, 40));
    titlelabel.setForeground(Color.white);
    this.add(titlelabel);

    //コース1
    JPanel panel1 = new JPanel();
    panel1.setBackground(new Color(54,90,149));
    JPanel panel1_sub = new JPanel();
    panel1_sub.setBackground(new Color(54,90,149));
    JLabel label1 = new JLabel("Stage 1 (難易度：★★☆☆☆)", JLabel.CENTER);
    label1.setForeground(Color.white);
    button1.addActionListener(this);
    panel1_sub.add(button1);
    panel1.add(label1);
    panel1.add(panel1_sub);
    this.add(panel1);

    //コース2
    JPanel panel2 = new JPanel();
    panel2.setBackground(new Color(54,90,149));
    JPanel panel2_sub = new JPanel();
    panel2_sub.setBackground(new Color(54,90,149));;
    JLabel label2 = new JLabel("Stage 2 (難易度：★★★★☆)", JLabel.CENTER);
    label2.setForeground(Color.white);
    button2.addActionListener(this);
    panel2_sub.add(button2);
    panel2.add(label2);
    panel2.add(panel2_sub);
    this.add(panel2);

    //コース3
    JPanel panel3 = new JPanel();
    panel3.setBackground(new Color(54,90,149));
    JPanel panel3_sub = new JPanel();
    panel3_sub.setBackground(new Color(54,90,149));;
    JLabel label3 = new JLabel("Stage 3 (難易度：★★★★★)", JLabel.CENTER);
    label3.setForeground(Color.white);
    button3.addActionListener(this);
    panel3_sub.add(button3);
    panel3.add(label3);
    panel3.add(panel3_sub);
    this.add(panel3);

    //this.setTitle("コース選択");
    this.setLayout(new GridLayout(4,1));
    this.setSize(800, 600);
    this.setBackground(new Color(54,90,149));
  }

  public void actionPerformed(ActionEvent e) {
    this.setVisible(false);
    if(e.getSource() == button1){
      viewControll.PanelChange("courseSelection", viewControll.PanelControll[2]);
    }else if(e.getSource() == button2){
      viewControll.PanelChange("courseSelection", viewControll.PanelControll[3]);
    }else if(e.getSource() == button3){
      viewControll.PanelChange("courseSelection", viewControll.PanelControll[4]);
    }
  }
  
}