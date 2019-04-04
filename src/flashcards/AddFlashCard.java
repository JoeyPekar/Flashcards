package flashcards;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AddFlashCard extends JFrame implements ActionListener{
    private JButton submit = new JButton("Submit");
    private JButton close = new JButton("Close");  
    private JTextField question = new JTextField();
    private JTextField answer = new JTextField();
    private JLabel questLabel = new JLabel("Please write a question for the flash card");
    private JLabel ansLabel = new JLabel("Please write an answer for the flash card");
    private GridLayout grid1 = new GridLayout(6, 1, 20, 20);
    private static String[] quest = new String[10];
    private static String[] ans = new String[10];
    private int x = 0;
    
    public AddFlashCard(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(grid1);
        add(questLabel);
        add(question);
        add(ansLabel);
        add(answer);
        add(submit);
        add(close);
        submit.addActionListener(this);    
        close.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == submit)
        {
        quest[x] = question.getText();
        ans[x] = answer.getText();
        System.out.println(quest[x] + "\n" + ans[x] + "\n");
        question.setText("");
        answer.setText("");  
        x++;
        }
        
        else if(source == close)
        {
            
        
        try
        {
            
            File file = new File("FlashCards.txt");
  
            //Create the file
            if (file.createNewFile())
            {
                System.out.println("File is created!");
            } else {
                System.out.println("File already exists.");
            }
            
        Path outFiles = Paths.get("FlashCards.txt");
        OutputStream output = new
                    BufferedOutputStream(Files.newOutputStream(outFiles));
            BufferedWriter writer = new
                    BufferedWriter(new OutputStreamWriter(output));
            String s = " ";
            for(int c = 0; c < 3; c++)
            {
                s = quest[c];
                if(s != null)
                {
                writer.write(s, 0, s.length());
                writer.write(",");
                }
                s = ans[c];
                if(s != null)
                {
                writer.write(s, 0, s.length());
                writer.write(System.getProperty( "line.separator" ));
                }
            }
            writer.close();
            System.exit(0);
        }
        catch(IOException ex) {
            
            System.out.println(ex);
            
        }
        }
    
    }
    public static void main(String[] args) {

        AddFlashCard frame = new AddFlashCard();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
