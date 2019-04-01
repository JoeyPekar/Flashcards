package flashcards;

import java.awt.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class AddFlashCard extends JFrame implements ActionListener{
    private JButton submit = new JButton("Submit");
    private JTextField question = new JTextField();
    private JTextField answer = new JTextField();
    private JLabel questLabel = new JLabel("Please write a question for the flash card");
    private JLabel ansLabel = new JLabel("Please write an answer for the flash card");
    private GridLayout grid1 = new GridLayout(5, 1, 20, 20);
    private String[] quest = new String[10];
    private String[] ans = new String[10];
    private int x = 0;
    
    public AddFlashCard(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(grid1);
        add(questLabel);
        add(question);
        add(ansLabel);
        add(answer);
        add(submit);
        submit.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        quest[x] = question.getText();
        ans[x] = answer.getText();
        System.out.println(quest[x] + "\n" + ans[x] + "\n");
        question.setText("");
        answer.setText("");
        x++;
    }
    public static void main(String[] args) {
        AddFlashCard frame = new AddFlashCard();
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
