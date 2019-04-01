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
        
        controlContainer.add(btnPrevious);
        controlContainer.add(btnFlip);
        controlContainer.add(btnNext);
        
        btnFlip.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        
        StudyFrame frame = new StudyFrame();      
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource().equals(btnFlip)) {
            
            this.cardPanel.flip();
            
        }
        
    }
    
}