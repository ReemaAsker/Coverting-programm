package binarystremprogramm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BinaryStreamProgramm extends JFrame implements ActionListener {

    JLabel welcom;
    JButton clickToSmall, clickToFirstLetterCapital;
    File path, outf;
    Scanner read = null;
    PrintWriter pn = null;
    static JFrame frame = new JFrame();

    int i = 0;//if the file exists will put the same name with1,2,3....

    BinaryStreamProgramm() {

        this.setLayout(null);
        this.setBounds( 450, 150 , 430, 350);
        
        welcom = new JLabel(" * Welcom * ");
        welcom.setBounds(120, 25, 160, 30);
        welcom.setForeground(new Color(128, 0, 64));
        welcom.setFont(new Font("Bell MT", Font.BOLD, 22));

        clickToSmall = new JButton("Choose file to Convert in small letter");
        clickToSmall.setFont(new Font("Bell MT", Font.BOLD, 15));
        clickToSmall.setBounds(35, 90, 330, 50);
        clickToSmall.setBorder(new LineBorder(Color.darkGray));
        clickToSmall.addActionListener(this);

        clickToFirstLetterCapital = new JButton("Choose file to make first letter Capital");
        clickToFirstLetterCapital.setFont(new Font("Bell MT", Font.BOLD, 15));
        clickToFirstLetterCapital.setBounds(35, 160, 330, 50);
        clickToFirstLetterCapital.setBorder(new LineBorder(Color.darkGray));
        clickToFirstLetterCapital.addActionListener(this);

        this.add(welcom);
        this.add(clickToSmall);
        this.add(clickToFirstLetterCapital);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clickToSmall) {
            File fileChosen = null;
            String result = "";
            try {
                JFileChooser chooser = new JFileChooser();
                chooser.setAcceptAllFileFilterUsed(false); //to don't show all files
                chooser.setDialogTitle("Select a .txt file");//set a title for the dialog 
                FileNameExtensionFilter show = new FileNameExtensionFilter(" .txt files", "txt");// only allow files of .txt extension 
                chooser.addChoosableFileFilter(show);
                chooser.showOpenDialog(this);

                fileChosen = chooser.getSelectedFile();
                /*    String filepath = fi.getPath();//to print the address
                System.out.println(""+ filepath);*/
                outf = new File(fileChosen.getParent() + "\\" + "copyFile" + i + ".txt");
                 
                if (outf.exists()) {
                    result = fileChosen.getParent() + "\\" + "copyFile" + (++i) + ".txt";
                    outf = new File(result);
                }

                read = null;
                pn = null;
            } catch (NullPointerException ex) {
            }
            try {
                read = new Scanner(fileChosen);
                pn = new PrintWriter(outf);
            } catch (Exception ex) {
            }

            try {

                while (read.hasNext()) {
                    pn.println(read.nextLine().toLowerCase());
                }

                JOptionPane.showMessageDialog(null, "The modified file is located next to the specified file : "+ result, "Information", 1);
                System.out.println("Finished");
            }catch(Exception ex){}
            finally {
                if (read != null) {
                    read.close();
                }

                if (pn != null) {
                    pn.close();
                }

            }

        }
        if (e.getSource() == clickToFirstLetterCapital) {

            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false); //to don't show all files
            chooser.setDialogTitle("Select a .txt file");//set a title for the dialog 
            FileNameExtensionFilter show = new FileNameExtensionFilter(" .txt files", "txt");// only allow files of .txt extension 
            chooser.addChoosableFileFilter(show);
            chooser.showOpenDialog(this);
            String fileOut="";
            File fileChosen = null;
try{
            fileChosen = chooser.getSelectedFile();

            outf = new File(fileChosen.getParent() + "\\" + "copyFile" + i + ".txt");
            fileOut = fileChosen.getParent() + "\\" + "copyFile" + (++i) + ".txt";

            if (outf.exists()) {
                outf = new File(fileOut);
            }
}catch(Exception ex){}
            read = null;
            pn = null;
            try {
                read = new Scanner(fileChosen);
                pn = new PrintWriter(outf);
            } catch (Exception ex) {
            }
            try {

                while (read.hasNextLine()) {
                    String[] line_words = read.nextLine().trim().split(" ");
                    int words_number = line_words.length;
                    for (int j = 0; j < words_number; ++j) {
                        if (line_words[j].length() == 0) {
                            continue;
                        }
                        char first_letter = Character.toUpperCase(line_words[j].charAt(0));
                        line_words[j] = first_letter + line_words[j].substring(1).toLowerCase();
                        pn.print(line_words[j] + " ");
                    }
                    pn.println();
                }

                JOptionPane.showMessageDialog(null, "The modified file is located next to the specified file ::" + fileOut, "Information", 1);
                System.out.println("Finished");
            }catch(Exception ex) {}
            finally {

                if (read != null) {
                    read.close();
                }

                if (pn != null) {
                    pn.close();
                }

            }
        }

    }
//


    public static void main(String[] args) {
        
        JPanel panel = new JPanel(null){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponents(g);
                Image img = new ImageIcon("background.jpg").getImage();
                g.drawImage(img, 0, 0, 430, 355, null);
            }
        };
        panel.setBounds(0, 0, 430, 455);
        panel.setOpaque(true);
        panel.setBackground(Color.blue);
        BinaryStreamProgramm bs = new BinaryStreamProgramm();
         bs.add(panel);
       bs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //bs.setBackground(Color.blue);
//        frame.setLayout(null);
//        frame.setTitle("Converting Programming");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setResizable(false);
//        bs.setOpaque(false);
//
//        frame.setVisible(true);

    }

}
