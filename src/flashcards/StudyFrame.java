package flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

public class StudyFrame extends DisplayCardFrame {

    // Button Controls
    JButton btnFlip = new JButton("Flip");
    
    JButton btnPrevious = new JButton("Previous");
    JButton btnNext = new JButton("Next");
    
    // Menu Add Cards
    JMenuItem menuCardsAddCards = new JMenuItem("Add Cards");
    JMenuItem menuCardsUpdateCards = new JMenuItem("Update Cards");
    
    JMenuItem menuCardsShuffle = new JMenuItem("Shuffle Cards");
    
    public StudyFrame() {
        
        controlContainer.setLayout(new GridLayout(1, 3));
        
        // Add Components to the Control Container
        controlContainer.add(btnPrevious);
        controlContainer.add(btnFlip);
        controlContainer.add(btnNext);
        
        this.menuCards.add(menuCardsAddCards);
        this.menuCards.add(menuCardsUpdateCards);
        this.menuCards.addSeparator();
        this.menuCards.add(menuCardsShuffle);
        
        // Add Action Listeners for Buttons
        btnFlip.addActionListener(this);
        btnNext.addActionListener(this);
        btnPrevious.addActionListener(this);
        
        menuCardsAddCards.addActionListener(this);
        menuCardsUpdateCards.addActionListener(this);
        menuCardsShuffle.addActionListener(this);
        
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
        
        if (e.getSource().equals(menuCardsAddCards)) {
            
            AddFlashCard.addCards();
            
        }
        
        if (e.getSource().equals(menuCardsUpdateCards)) {
            
            this.loadWords();
            
        }
        
        if (e.getSource().equals(menuCardsShuffle)) {
            
            this.shuffle();
            
        }
        
    }
    
    // Next Word - btnNext - Goes to the next word.
    @Override
    protected void nextWord() {
        
        if (this.currentCard + 1 < this.questions.size()) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard + 1), this.answers.get(currentCard + 1));
            currentCard += 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "There are no more questions past this point.");
            
        }
        
    }
    
    // Previous Word - btnPrevious - Goes back to the previous word.
    private void previousWord() {
        
        if (this.currentCard - 1 >= 0) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard - 1), this.answers.get(currentCard - 1));
            currentCard -= 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "There are no more questions past this point.");
            
        }
        
    }
    
    /* Shuffles the cards so they are in a new order */
    private void shuffle() {
        
        // Save Cards to a combined array.
        ArrayList<String> cards = new ArrayList<String>();
        
        for (int i = 0; i < questions.size(); i++) {
            
            cards.add(questions.get(i) + "," + answers.get(i));
            
        }
        
        // Shuffle Cards
        Collections.shuffle(cards);
        
        // Clear Card Arrays
        questions.clear();
        answers.clear();
        
        // Repopulate Arrays
        for (String newCard : cards) {

            
            questions.add(newCard.split(",")[0]);
            answers.add(newCard.split(",")[1]);
            
        }
        
        // Update Card Panel with new starting word.
        this.cardPanel.updateCard(questions.get(0), answers.get(0));
        
        
        
    }
    
}
