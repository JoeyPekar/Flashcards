package flashcards;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;

public class AddFlashCard extends JFrame implements ActionListener {

    // Controls
    private JButton submit = new JButton("Submit");
    private JButton close = new JButton("Close");
    private JTextField question = new JTextField();
    private JTextField answer = new JTextField();
    private JLabel questLabel = new JLabel("Please write a question for the flash card");
    private JLabel ansLabel = new JLabel("Please write an answer for the flash card");
    private GridLayout grid1 = new GridLayout(6, 1, 20, 20);
    private int x = 0;

    // Array Lists for Questions and Answers
    private ArrayList<String> questions = new ArrayList<String>();
    private ArrayList<String> answers = new ArrayList<String>();

    // Constructor
    public AddFlashCard() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

        if (source == submit) {
            questions.add(question.getText());
            answers.add(answer.getText());
            System.out.println(questions.get(x) + "\n" + answers.get(x) + "\n");
            question.setText("");
            answer.setText("");
            x++;

        } else if (source == close) {

            loadWords();

            try {

                // File
                File file = new File("FlashCards.txt");

                // Create the file if it doesn't exist.
                if (file.createNewFile()) {
                    
                    System.out.println("File is created!");
                    
                } else {
                    
                    System.out.println("File already exists.");
                    
                }
           
                // Save Output to File
                Path outFiles = Paths.get("FlashCards.txt");
                OutputStream output = new BufferedOutputStream(Files.newOutputStream(outFiles));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output));
                String s = " ";
                for (int c = 0; c < questions.size(); c++) {
                    s = questions.get(c);
                    if (s != null) {
                        writer.write(s, 0, s.length());
                        writer.write(",");
                    }
                    s = answers.get(c);
                    if (s != null) {
                        writer.write(s, 0, s.length());
                        writer.write(System.getProperty("line.separator"));
                    }

                    System.out.println("Test");

                }
                writer.close();

                this.dispose();

            } catch (IOException ex) {

                System.out.println(ex);

            }
        }

    }

    // Loads all words into the word list
    private void loadWords() {

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

        } catch (FileNotFoundException e) {

            JOptionPane.showMessageDialog(this, "Missing file FlashCards.txt");

        } catch (IOException e) {

            System.out.println(e);

        }

    }

    // Opens this window.
    public static void addCards() {

        AddFlashCard frame = new AddFlashCard();
        frame.setSize(300, 300);
        frame.setVisible(true);
        
    }
}
