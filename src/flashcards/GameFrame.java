/*
 * GameFrame.java
 * Developed by Joey Pekar on 4/4/2019
 * Contains the "Game Mode' portion of the program.
*/

package flashcards;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GameFrame extends DisplayCardFrame { 
    
    // Controls
    private JTextField txtUserAnswer = new JTextField(10);
    private JButton btnCheck = new JButton("Check");
    private JButton btnSkip = new JButton("Skip");
    private JButton btnNext = new JButton("Next");
    
    private int correct = 0;
    private int total = this.questions.size();
    
    public GameFrame() {
        
        this.setJMenuBar(null);
        
        controlContainer.setLayout(new GridLayout(2, 1));
        
        controlContainer.add(new JPanel(new GridLayout(1, 3)) {
            
            JPanel addItems() {
                
                add(new JPanel());
                add(txtUserAnswer);
                add(new JPanel());
                
                return this;
                
            }

        }.addItems());
        
        controlContainer.add(new JPanel(new GridLayout(1, 2)) {
            
            JPanel addItems() {
                
                add(btnCheck);
                add(btnSkip);
                
                return this;
                
            }
            
        }.addItems());
        
        btnCheck.addActionListener(this);
        btnSkip.addActionListener(this);
            
        
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        
        super.actionPerformed(e);
        
        if (e.getSource().equals(btnCheck)) {
            
            
            if (txtUserAnswer.getText().equals(this.cardPanel.getBackText())) {
                
                correct++;
                
            }
            
            nextWord();
            
            
        }
        
        if (e.getSource().equals(btnSkip)) {
            
            nextWord();
            
        }
        
    }

    @Override
    protected void nextWord() {
        
        this.txtUserAnswer.setText("");
        
        if (this.currentCard + 1 < this.questions.size()) {
            
            this.cardPanel.updateCard(this.questions.get(currentCard + 1), this.answers.get(currentCard + 1));
            currentCard += 1;
            
        } else {
            
            JOptionPane.showMessageDialog(this, "You got " + this.correct + " out of " + this.total + ".");
            this.dispose();
            
        }
        
    }
    
}
