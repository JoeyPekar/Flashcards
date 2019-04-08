/*
 * CardPanel.java
 * 
 * Developed by Joey Pekar on 3/28/2019
 * Contains code for a panel with a two sided system.
 */

package flashcards;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
    
    private JLabel lblDisplay = new JLabel();
    
    private String cardFront;
    private String cardBack;
    
    public CardPanel(String frontText, String backText) {
        
        // Variables
        this.cardFront = frontText;
        this.cardBack = backText;
        
        Font cardFont = new Font("Consolas", Font.BOLD, 16);
        
        // Card Design     
        this.setLayout(new BorderLayout());
        
        this.add(lblDisplay, BorderLayout.CENTER);
        
        lblDisplay.setText("<p>" + cardFront + "</p>");
        
        // Change background and styling
        setBackground(Color.WHITE);
        lblDisplay.setHorizontalAlignment(SwingConstants.CENTER);
        lblDisplay.setFont(cardFont);
        
    }
    
    // "Flips" the panel
    public void flip() {
        
        if (lblDisplay.getText().equals(cardFront)) {
            
            lblDisplay.setText(cardBack);
            
        } else {
            
            lblDisplay.setText(cardFront);
            
        }
        
    }
    
    public void updateCard(String frontText, String backText) {
        
        // Variables
        this.cardFront = frontText;
        this.cardBack = backText;
        
        lblDisplay.setText(frontText);
        
    }
    
    public String getFrontText() {
        
        return this.cardFront;
        
    }
    
    public String getBackText() {
        
        return this.cardBack;
        
    }
    
}
