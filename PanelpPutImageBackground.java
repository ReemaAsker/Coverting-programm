
package binarystremprogramm;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


 public class PanelpPutImageBackground extends JPanel  {

    PanelpPutImageBackground(LayoutManager l) {
        super.setLayout(l);
        
    }
     
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponents(g);
        // Image img = new ImageIcon ("C:\\Users\\Remaa\\Desktop\\مجلد جديد (2)\\bg4.jpg").getImage().getScaledInstance(600,600,Image.SCALE_SMOOTH );
         //Image img = new ImageIcon ("C:\\Users\\Remaa\\Desktop\\Frames about library\\wp3569714.jpg").getImage();
         Image img = new ImageIcon ("background.jpg").getImage();

          g.drawImage(img,0,0,400,300, null);
        // g.drawImage(img,0,0, null);
       
    
}
 }