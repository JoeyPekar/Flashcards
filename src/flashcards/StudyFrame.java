package flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudyFrame extends DisplayCardFrame {

    JButton btnFlip = new JButton("Flip");
    
    JButton btnPrevious = new JButton("Previous");
    JButton btnNext = new JButton("Next");
    
    public StudyFrame() {
        
        controlContainer.setLayout(new GridLayout(1, 3));
        
        // Add Components to the Control Container
        controlContainer.add(btnPrevious);
        controlContainer.add(btnFlip);
        controlContainer.add(btnNext);
        
        btnFlip.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        
        StudyFrame frame = new StudyFrame();   
        //comment
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Flips the Card
        if (e.getSource().equals(btnFlip)) {
            
            this.cardPanel.flip();
            
        }
        
        if (e.getSource().equals(btnNext)) {
            
            nextWord();
            
        }
        
        if (e.getSource().equals(btnPrevious)) {
            
            previousWord();
            
        }
        
        // Exit
        
    }

    @Override
    public void nextWord() {
        
        if (this.currentCard + 1 < this.questions.size()) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard + 1), this.answers.get(currentCard + 1));
            currentCard += 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "There are no more questions past this point.");
            
        }
        
    }
    
    public void previousWord() {
        
        if (this.currentCard - 1 >= 0) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard - 1), this.answers.get(currentCard - 1));
            currentCard -= 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "There are no more questions past this point.");
            
        }
        
    }
    
}
