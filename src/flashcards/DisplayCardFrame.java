package flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.nio.file.*;
import java.io.*;

import java.util.ArrayList;

public abstract class DisplayCardFrame extends JFrame implements ActionListener {
    
    // Word Arrays
    protected ArrayList<String> questions = new ArrayList<String>();
    protected ArrayList<String> answers = new ArrayList<String>();
    
    protected int currentCard = 0;
    
    // Menu System
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu menuFile = new JMenu("File");
    protected JMenu menuCards = new JMenu("Cards");
    protected JMenu menuMode = new JMenu("Mode");
    
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    
    // Card Panels
    protected CardPanel cardPanel = new CardPanel("", "");
    protected JPanel controlContainer = new JPanel();
    
    /* DisplayFrame - Constructor */
    public DisplayCardFrame() {
        
        // Design
        this.setSize(1200, 600);  
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new GridLayout(2, 1));
        
        initMenu();
        loadWords();
        
        // Add Card Panel
        this.add(cardPanel);
        this.add(controlContainer);
        
    }
    
    // Initialize Menus
    private void initMenu() {
        
        this.setJMenuBar(menuBar);
        
        menuBar.add(menuFile);
        menuBar.add(menuCards);
        menuBar.add(menuMode);
        
        // Add Exit to File Menu 
        menuFile.add(menuFileExit);
        
        menuFileExit.addActionListener(this);

    }
    
    // Load Words into the Program
    protected void loadWords()  {
        
        questions.clear();
        answers.clear();
        
        /* File Read */
        String file = "FlashCards.txt";
        
        BufferedReader reader = null;
        String input = "";
        
        // Add Questions and Answers
        try {
        
            reader = new BufferedReader(new FileReader(file));
            
            while ((input = reader.readLine()) != null) {
                
                String[] in = input.split(",");
                
                questions.add(in[0]);
                answers.add(in[1]);
                
            }
            
            // Display first word
            this.cardPanel.updateCard(questions.get(0), answers.get(0));
            
            reader.close();
        
            
        } catch (FileNotFoundException e) {
                
            JOptionPane.showMessageDialog(this, "Missing file FlashCards.txt");
                
        } catch (IOException e) {
            
            System.out.println(e);
            
        }
        
    }
    
    protected abstract void nextWord();
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource().equals(menuFileExit)) {
            
            System.exit(0);
            
        }
        
    }
    
}
