import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class node {
    String english;
    String ruso;
}

public class flash implements ActionListener, java.awt.event.ActionListener {

    int count = 0;
    JLabel label;
    JPanel panel;
    JFrame frame;
    JButton button;
    JButton b1 = new JButton("Russian first");
    JButton b2 = new JButton("English first");

    static List<node> words = new ArrayList<node>();

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public flash()// GUI
    {
        frame = new JFrame();
        panel = new JPanel();

        button = new JButton("Begin");
        label = new JLabel();

        button.addActionListener(this);

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(button);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.setVisible(true);

    }

    public static void main(String[] args) throws FileNotFoundException {

        node temp = null;

        String hold = "";
        String data = "";

        File file = new File("C:\\Users\\noelr\\Documents\\Java\\alphPractice.txt");
        Scanner sc = new Scanner(file);

        boolean first = true;

        while (sc.hasNextLine()) {
            hold = sc.nextLine();
            temp = new node();

            for (int i = 0; i < hold.length(); i++) {
                if (hold.charAt(i) != ' ' & first == true) {
                    data += hold.charAt(i);
                }
                if (hold.charAt(i) == ' ') {
                    first = false;
                    temp.ruso = data;
                    data = "";
                }
                if (hold.charAt(i) != ' ' & first == false) {
                    data += hold.charAt(i);
                }
            }
            temp.english = data;
            words.add(temp);
            data = "";
            // System.out.println(temp.english);
        }
        sc.close();

        new flash();// Gui

        // node[] allW = null;
        // allW = words.toArray(new node[words.size()]);

        // for (int i = 0; i < words.size(); i++) {
        //     System.out.println("Node " + i + ": " + words.get(i).ruso);
        // }
        // int quit = 0;
        // String repeat = "";
        // int rep = 0;
        // Random rand = new Random();
        // int lim = 62;

        // int randInt;
        // JFrame frame = new JFrame("Swing Tester");
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(560, 200);
        // frame.setLocationRelativeTo(null);
        // frame.setVisible(false);

        // while (quit == 0) {
        //     randInt = rand.nextInt(lim);
        //     while (rep == 0 && quit == 0) {
        //         infoBox(words.get(randInt).ruso, "");
        //         infoBox(words.get(randInt).english, "");
        //         rep = JOptionPane.showConfirmDialog(frame, "REPEATING", "", JOptionPane.YES_NO_OPTION);
        //         System.out.println(rep);
        //     }
        //     rep = 0;
        //     quit = JOptionPane.showConfirmDialog(frame, "NEXT WORDS", "", JOptionPane.YES_NO_OPTION);
        // }
        // System.out.println("End");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panel.removeAll();
        panel.revalidate();
        panel.add(b1);
        panel.add(b2);
        
        if(e.getSource() == b1)
        {
            panel.removeAll();
            label.removeAll();
            label.setText(words.get(count).ruso);

            panel.add(b1);
            panel.add(label);
            count++;
        }
        else if(e.getSource() == b2)
        {
            
        }
    }

}