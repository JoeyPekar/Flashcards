package flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public abstract class DisplayCardFrame extends JFrame implements ActionListener {
    
    // Menu System
    private JMenuBar menuBar = new JMenuBar();
    
    private JMenu menuFile = new JMenu("File");
    protected JMenu menuMode = new JMenu("Mode");
    
    private JMenuItem menuFileExit = new JMenuItem("Exit");
    
    // Card Panels
    protected CardPanel cardPanel = new CardPanel("", "");
    protected JPanel controlContainer = new JPanel();
    
    /* DisplayFrame - Constructor */
    public DisplayCardFrame() {
        
        // Design
        this.setSize(600, 400);  
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.setLayout(new GridLayout(2, 1));
        
        initMenu();
        loadWords();
        
        // Add Card Panel
        this.add(cardPanel);
        this.add(controlContainer);
        
    }
    
    private void initMenu() {
        
        this.setJMenuBar(menuBar);
        
        menuBar.add(menuFile);
        menuBar.add(menuMode);
        
        // Add Exit to File Menu 
        menuFile.add(menuFileExit);
        
        menuFileExit.addActionListener(this);

    }
    
    private void loadWords() {
        
        this.cardPanel = new CardPanel("Hello", "World");
        
    }
    
}
