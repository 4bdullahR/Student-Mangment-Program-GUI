package Students;
import static Students.Add.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Find extends JFrame{
    private JLabel L1;
    private JTextField T1;
    private JButton srch, cncl;
    private Update page1;
    
    
    public Find(){
        super("Find student");
        this.setLocation(800, 250);
        this.setSize(300,120);
        
        L1 = new JLabel("ID ");
        T1 = new JTextField(10);
        srch = new JButton("Search");
        cncl = new JButton("cancel");
        
        
        JPanel p = (JPanel) this.getContentPane();
        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        
        j1.add(L1);
        j1.add(T1);
        j2.add(srch);
        j2.add(cncl);
        
        p.add(j1, BorderLayout.PAGE_START);
        p.add(j2, BorderLayout.CENTER);
        
        
        // Action Listenrs
        cncl.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        T1.setText("");
    }});
        
        srch.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            if (T1.getText().isEmpty() || T1.getText().isBlank() ) {
                JOptionPane.showMessageDialog ( null, "-Empty ID\nTRY AGAIN", "Wrong input", JOptionPane.WARNING_MESSAGE);
            }
            else if(isDigit(T1.getText())){
                int indx;
                if(info.contains(T1.getText())){
                    indx = info.indexOf(T1.getText());
                    System.out.println("found :)"+indx);
                    page1 = new Update(indx);
                }
                else
                    JOptionPane.showMessageDialog ( null, "Not found\nTRY AGIAN", "Not found", JOptionPane.WARNING_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog ( null, "-Write only numbers\nTRY AGAIN", "Wrong input", JOptionPane.WARNING_MESSAGE);
    }});
        
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
}