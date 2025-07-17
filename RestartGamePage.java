import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RestartGamePage implements ActionListener {

    JFrame frame = new JFrame();
    JLabel label = new JLabel();
    JPanel textJPanel = new JPanel();
    JPanel textJPanel2 = new JPanel();
    JButton yesButton = new JButton("Yes");
    JButton noButton = new JButton("No");



    RestartGamePage(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,400);
        frame.setLayout(null);// for Manual control
       // frame.setLocationRelativeTo(null);
        frame.setBackground(Color.BLACK);      

        label.setText("wanna have another go?");// text of label
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setBounds(20,100,350,40);
        label.setForeground(Color.GREEN);
        label.setFont(new Font("MV Boli",Font.BOLD,30));   
        label.setBackground(Color.BLACK); // setting color but wont work directly
        label.setOpaque(true); //for coloring every pixel
        label.setHorizontalAlignment(JLabel.CENTER); // setting it to middle 
       


        textJPanel.setLayout(new BorderLayout());
        textJPanel.setSize(400,200);
        textJPanel.setBackground(Color.BLACK);
        textJPanel.add(label);

        textJPanel2.setLayout(new BorderLayout());
        textJPanel2.setSize(400,400);
        textJPanel2.setBackground(Color.BLACK);

        // i have added two panels one for bottum and one for top
        // idk why but i was unable to allign label so that why i needed to this way!


        yesButton.setBounds(20,180,170,40);
        yesButton.setFocusable(false);
        yesButton.addActionListener(this);
        yesButton.setFont(new Font("Arial",Font.BOLD,20));
        yesButton.setBackground(Color.green);
        yesButton.setForeground(Color.BLACK);
        yesButton.setOpaque(true);

        noButton.setBounds(210,180,170,40);
        noButton.setFocusable(false);
        noButton.addActionListener(this);
        noButton.setFont(new Font("Arial",Font.BOLD,20));
        noButton.setBackground(Color.RED);
        noButton.setForeground(Color.BLACK);
        yesButton.setOpaque(true);



        frame.add(yesButton);
        frame.add(noButton);
        frame.add(textJPanel);
        frame.add(textJPanel2);
        frame.setVisible(true);
        frame.setLocation(1000,200);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
      if(e.getSource()==yesButton){
        
        frame.dispose(); 

        new WhacAMole();
         //new TickTackToe();

      }
      if(e.getSource()==noButton){
        frame.dispose();
      }
    }



}
