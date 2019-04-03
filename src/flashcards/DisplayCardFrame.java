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
        
        // Read from file soon
        questions.add("Dog");
        questions.add("Cat");
        questions.add("Cow");
        answers.add("Woof");
        answers.add("Meow");
        answers.add("Moo");
        
        // Display first word
        this.cardPanel.updateCard(questions.get(0), answers.get(0));
        
        /* File Code
        Path inFiles = Paths.get("C:\\Java\\FlashCardsIn.txt");
        Path outFiles = Paths.get("C:\\Java\\FlashCardsOut.txt");
        
        String[] questionArray = new String[10];
        String[] answerArray = new String[10];
        int questionCount = 0;
        int answerCount = 0;
        int count = 0;
        String s; 
        
        try
        {
            InputStream input = Files.newInputStream(inFiles);
            BufferedReader reader = new 
                BufferedReader(new InputStreamReader(input));
            OutputStream output = new
                    BufferedOutputStream(Files.newOutputStream(outFiles));
            BufferedWriter writer = new
                    BufferedWriter(new OutputStreamWriter(output));
            s = reader.readLine();
            
            while(s != null)
            {
                if(count % 2 == 1)
                {
                    questionArray[questionCount] = s;
                    writer.write(s, 0, s.length());
                    writer.write(System.getProperty( "line.separator" ));
                    s = reader.readLine();
                    questionCount++;
                }
                else
                {
                    answerArray[answerCount] = s;
                    writer.write(s + "\n", 0, s.length());
                    writer.write(System.getProperty( "line.separator" ));
                    s = reader.readLine();
                    answerCount++;
                }
                count++;
            }
        writer.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        */
        
    }
    
    public abstract void nextWord();
    
    @Override
    public void actionPerformed(ActionEvent e) {
     
        if (e.getSource().equals(menuFileExit)) {
            
            System.exit(0);
            
        }
        
    }
    
}
