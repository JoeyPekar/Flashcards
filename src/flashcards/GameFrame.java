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

    private int correct = 0;
    private int wrong = 0;
    private int total = this.questions.size();
    
    private JMenuItem menuFeedback = new JMenuItem("     ");
    private JMenuItem menuCorrect = new JMenuItem("0 Correct");
    private JMenuItem menuWrong = new JMenuItem("0 Wrong");
    
    public GameFrame() {
           
        // Set up Game Menu
        this.menuBar.removeAll();
        this.menuBar.add(this.menuFeedback);
        this.menuBar.add(this.menuCorrect);
        this.menuBar.add(this.menuWrong);
          
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
            
            
            if (txtUserAnswer.getText().equalsIgnoreCase(this.cardPanel.getBackText())) {
                
                correct++;
                this.menuFeedback.setBackground(new Color(15, 155, 10));

                this.menuCorrect.setText(correct + " correct.");
                
            } else {
                
                wrong++;
                this.menuFeedback.setBackground(new Color(206, 40, 20));
                
                this.menuWrong.setText(wrong + " wrong.");
                
            }
            
            nextWord();
            
            
        }
        
        if (e.getSource().equals(btnSkip)) {
            
            this.menuFeedback.setBackground(Color.WHITE);

            
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
