package exercise30_3;

import java.applet.Applet;
import java.awt.*;

import javax.swing.*;

public class Exercise30_3 extends JApplet{
 private static final long serialVersionUID = 1L;

 
 public Exercise30_3() {
  FlagPanel flagPanel = new FlagPanel();
  add(flagPanel);
  Thread thread = new Thread(flagPanel);
  thread.start();
 }

 public static void main(String[] args) {
  JFrame frame = new JFrame();
  frame.add(new Exercise30_3());
  frame.setTitle("Exercise30_3");
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setSize(500, 500);
  frame.setMinimumSize(new Dimension(frame.getWidth(), frame.getHeight()));
  frame.setLocationRelativeTo(null);
  frame.setVisible(true);
 }

 class FlagPanel extends JPanel implements Runnable {
  private int currentFlag = 0;
  private ImageIcon imageIcon;
  private int x;
  private int y;
  private static final long serialVersionUID = 1L;
  private boolean newFlag = true;
  private Image image;
  
  
  @Override
  protected void paintComponent(Graphics g) {
   super.paintComponent(g);
   if (newFlag) {
    y = getHeight();
    newFlag = false;
    imageIcon = new ImageIcon(this.getClass().getResource("flag" + currentFlag + ".jpg"));
    image = imageIcon.getImage();
   }
   x = (getWidth() - imageIcon.getIconWidth()) / 2;
   g.drawImage(image, x,  y, imageIcon.getIconWidth(), imageIcon.getIconHeight(), this);
   if (y + imageIcon.getIconHeight() <= 0) {
    newFlag = true;
    currentFlag++;
    if (currentFlag > 6) {
     currentFlag = 0;
    }    
   }
  }

  @Override
  public void run() {
   try {
    while (true) {
     Thread.sleep(10);
     y--;          
     repaint();
    }
   } catch (InterruptedException e) {
    e.printStackTrace();
   }
  }
 }
}
