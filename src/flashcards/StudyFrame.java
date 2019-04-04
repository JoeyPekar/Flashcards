package flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudyFrame extends DisplayCardFrame {

    // Button Controls
    JButton btnFlip = new JButton("Flip");
    
    JButton btnPrevious = new JButton("Previous");
    JButton btnNext = new JButton("Next");
    
    // Menu Add Cards
    JMenuItem menuFileAddCards = new JMenuItem("Add Cards");
    JMenuItem menuFileUpdateCards = new JMenuItem("Update Cards");
    
    public StudyFrame() {
        
        controlContainer.setLayout(new GridLayout(1, 3));
        
        // Add Components to the Control Container
        controlContainer.add(btnPrevious);
        controlContainer.add(btnFlip);
        controlContainer.add(btnNext);
        
        this.menuFile.addSeparator();
        this.menuFile.add(menuFileAddCards);
        this.menuFile.add(menuFileUpdateCards);
        
        // Add Action Listeners for Buttons
        btnFlip.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        
        menuFileAddCards.addActionListener(this);
        menuFileUpdateCards.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        
        StudyFrame frame = new StudyFrame();   
        
    }
    
    // Action Listeners
    @Override
    public void actionPerformed(ActionEvent e) {
        
        super.actionPerformed(e);
        
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
        
        if (e.getSource().equals(menuFileAddCards)) {
            
            AddFlashCard.addCards();
            
        }
        
        if (e.getSource().equals(menuFileUpdateCards)) {
            
            this.loadWords();
            
        }
        
    }
    
    // Next Word - btnNext - Goes to the next word.
    @Override
    public void nextWord() {
        
        if (this.currentCard + 1 < this.questions.size()) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard + 1), this.answers.get(currentCard + 1));
            currentCard += 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "There are no more questions past this point.");
            
        }
        
    }
    
    // Previous Word - btnPrevious - Goes back to the previous word.
    public void previousWord() {
        
        if (this.currentCard - 1 >= 0) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard - 1), this.answers.get(currentCard - 1));
            currentCard -= 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "There are no more questions past this point.");
            
        }
        
    }
    
}
