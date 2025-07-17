import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class WhacAMole {
    int boardWidth = 600;
    int boardHight = 650;

    JFrame  frame = new JFrame("Mario Whac A Mole");
    JLabel textLabel = new JLabel();
    JPanel textPanel = new JPanel();
    JPanel boardPanel = new JPanel();

    JButton[] board = new JButton[9];

    ImageIcon moleIcon;
    ImageIcon plantIcon;

    JButton currentMoleTile;
    JButton curentPlantTile;

    Random random = new Random();
    Timer setMoleTimer;
    Timer setPlantTimer;
    int score = 0;

    WhacAMole(){
        frame.setVisible(true);
        frame.setSize(boardWidth,boardHight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        textLabel.setFont(new Font("Arial",Font.PLAIN,50));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setText("Score: 0");
        textLabel.setOpaque(true);
        textLabel.setBackground(Color.DARK_GRAY);
        textLabel.setForeground(Color.WHITE);

        textPanel.setLayout(new BorderLayout());
        textPanel.add(textLabel);
        frame.add(textPanel ,BorderLayout.NORTH);  // BorderLayout.NORTH sets textpanel to the top

        boardPanel.setLayout(new GridLayout(3,3));
        boardPanel.setBackground(Color.black);
        frame.add(boardPanel);

        // plantIcon = new ImageIcon(getClass().getResource("./piranha.png")); // work around to reduce size of the image
        Image plantImg = new ImageIcon(getClass().getResource("./piranha.png")).getImage();
        plantIcon  = new ImageIcon(plantImg.getScaledInstance(120, 150, java.awt.Image.SCALE_SMOOTH));

      //  moleIcon = new ImageIcon(getClass().getResource("./monty.png"));  // work around to reduce size of the image
         Image moleImg = new ImageIcon(getClass().getResource("./monty.png")).getImage();
         moleIcon  = new ImageIcon(moleImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH));

        for(int i =0; i< 9 ;i++){
            JButton tile = new JButton();
            board[i] = tile;
            tile.setBackground(Color.BLACK);
            boardPanel.add(tile);
            // tile.setIcon(plantIcon); // testing purposes
            // tile.setIcon(moleIcon);
            tile.setFocusable(false);
            tile.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e ){
                    JButton tile =(JButton) e.getSource();
                    if (tile == currentMoleTile) {
                        score +=10;
                        textLabel.setText("Score: "+Integer.toString(score));
                    }
                    if (tile == curentPlantTile) {
                        textLabel.setText("Game Over : "+Integer.toString(score));
                        // we are able play even after clicked on plat thats why we need to stop timers
                        setMoleTimer.stop();
                        setPlantTimer.stop();
                        //to disable all the buttons 
                        for(int i =0; i<9;i++){
                            board[i].setEnabled(false);
                        }
                        // to restart if user wants !
                        new RestartGamePage();
                    }
                }
            });
        }

        

        setMoleTimer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //remove mole from currnet tile
                if (currentMoleTile != null) {
                    currentMoleTile .setIcon(null);
                    currentMoleTile = null;

                }
                //RANDOMLY select another tile 
                int num = random.nextInt(9);//0-8
                JButton tile = board[num];

                //if tile is accupied by Plant ,skip tile for this turn
                if (curentPlantTile == tile) return; // becuase at the same time there is a chance of 2 different random number chosen are same 

                currentMoleTile = tile;
                currentMoleTile.setIcon(moleIcon);
            }
        });

        setPlantTimer = new Timer(1500, new ActionListener() {
            public void actionPerformed(ActionEvent e ){
                //remove mole from currnet tile
                if (curentPlantTile !=null) {
                    curentPlantTile.setIcon(null);
                    curentPlantTile =null;

                }
                 //RANDOMLY select another tile 
                int num = random.nextInt(9);//0-8
                JButton tile = board[num];

                 //if tile is accupied by Plant ,skip tile for this turn
                if (currentMoleTile == tile) return; // becuase at the same time there is a chance of 2 different random number chosen are same 

                curentPlantTile = tile;
                curentPlantTile.setIcon(plantIcon);
            }
        });
        setMoleTimer.start();
        setPlantTimer.start();
        frame.setVisible(true);
    }

}
