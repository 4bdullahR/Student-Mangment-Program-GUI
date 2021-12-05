package Students;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import static Students.Front.*;

public class Add extends JFrame{
    public static ArrayList info = new ArrayList();
    public static int stdNum = 0;
    // ID FirstName LastName (Mid,project,final)MARKS
    private JLabel idL, fnL, lnL, midL, projL, finalL; // Labels
    private JTextField idTF, fnTF, lnTF, midTF, projTF, finalTF; // text fields
    private JButton add, cncl;
    
    
    public Add(){
        super("Add student");
        this.setLocation(1100, 100);
        this.setSize(250,270);
        
        idL = new JLabel(" ID");
        fnL = new JLabel(" First name");
        lnL = new JLabel(" Last name");
        midL = new JLabel(" Mid marks");
        projL = new JLabel(" Project mark");
        finalL = new JLabel(" Final mark");
        
        idTF = new JTextField(10);
        fnTF = new JTextField(10);
        lnTF = new JTextField(10);
        midTF = new JTextField(10);
        projTF = new JTextField(10);
        finalTF = new JTextField(10);
        
        add = new JButton("Add");
        cncl = new JButton("Cancel");
        
        
        JPanel p = (JPanel) this.getContentPane();
        JPanel j1 = new JPanel();
        j1.setLayout(new GridLayout(7,2));
        
        j1.add(idL);
        j1.add(idTF);
        
        j1.add(fnL);
        j1.add(fnTF);
        
        j1.add(lnL);
        j1.add(lnTF);
        
        j1.add(midL);
        j1.add(midTF);
        
        j1.add(projL);
        j1.add(projTF);
        
        j1.add(finalL);
        j1.add(finalTF);
        
        j1.add(add);
        j1.add(cncl);
        
        p.add(j1, BorderLayout.CENTER);
        
        // Action Listenrs
        cncl.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        idTF.setText("");
        fnTF.setText("");
        lnTF.setText("");
        midTF.setText("");
        projTF.setText("");
        finalTF.setText("");
    }});
        
        add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            boolean wrongIn = false;
            String s = "";
            
            // ID checking
            if(idTF.getText().isEmpty() || idTF.getText().isBlank()){
                s += "-Empty ID\n";
                wrongIn = true;
            }
            else if(isDigit(idTF.getText())){
                if(info.contains(idTF.getText())){
                    s += "-This student already exists\n";
                    wrongIn = true;
                }
                else if(idTF.getText().length() < 4){
                    s += "-ID must be at least four numbers\n";
                    wrongIn = true;
                }
            }
            else if(isString(idTF.getText())){
                s += "-ID must be numbers\n";
                wrongIn = true;
            }
            else{
                s += "-Wrong ID\n";
                wrongIn = true;
            }
            
            // First name checking
            if(fnTF.getText().isEmpty() || fnTF.getText().isBlank()){
                s += "-Empty first name\n";
                wrongIn = true;
            }
            else if(isDigit(fnTF.getText())){
                s += "-First name only in aphabet\n";
                wrongIn = true;
            }
            else if(isString(fnTF.getText())){
                
            }
            else{
                s += "-Wrong first name\n";
                wrongIn = true;
            }
            
            // Last name checking
            if(lnTF.getText().isEmpty() || lnTF.getText().isBlank()){
                s += "-Empty last name\n";
                wrongIn = true;
            }
            else if(isDigit(lnTF.getText())){
                s += "-Last name only in aphabet\n";
                wrongIn = true;
            }
            else if(isString(lnTF.getText())){
                
            }
            else{
                s += "-Wrong last name\n";
                wrongIn = true;
            }
            
            //mid marks checking
            if(midTF.getText().isEmpty() || midTF.getText().isBlank()){
                s += "-Empty mid marks\n";
                wrongIn = true;
            }
            else if(isDigit(midTF.getText())){
                
            }
            else if(isString(midTF.getText())){
                s += "-Mid marks must be a number\n";
                wrongIn = true;
            }
            else{
                s += "-Wrong mid marks\n";
                wrongIn = true;
            }
            
            // project marks checking
            if(projTF.getText().isEmpty() || projTF.getText().isBlank()){
                s += "-Empty project marks\n";
                wrongIn = true;
            }
            else if(isDigit(projTF.getText())){
                
            }
            else if(isString(projTF.getText())){
                s += "-Project marks must be a number\n";
                wrongIn = true;
            }
            else{
                s += "-Wrong project marks\n";
                wrongIn = true;
            }
            
            // final marks checking
            if(finalTF.getText().isEmpty() || finalTF.getText().isBlank()){
                s += "-Empty final marks\n";
                wrongIn = true;
            }
            else if(isDigit(finalTF.getText())){
                if(Integer.parseInt(midTF.getText()) + Integer.parseInt(projTF.getText()) + Integer.parseInt(finalTF.getText()) > 100){
                    s += "-sum of all marks exceed 100\n";
                    wrongIn = true;
                }
            }
            else if(isString(finalTF.getText())){
                s += "-Final marks must be a number\n";
                wrongIn = true;
            }
            else{
                s += "-Wrong final marks\n";
                wrongIn = true;
            }
            
            //results
            if(wrongIn){
                JOptionPane.showMessageDialog ( null, s+"\nPLEASE TRY AGAIN", "Wrong input", JOptionPane.WARNING_MESSAGE);
            }
            else{
                info.add(idTF.getText());
                info.add(fnTF.getText());
                info.add(lnTF.getText());
                info.add(Integer.parseInt(midTF.getText()));
                info.add(Integer.parseInt(projTF.getText()));
                info.add(Integer.parseInt(finalTF.getText()));
                
                //sum of all marks
                info.add((Integer.parseInt(midTF.getText()) + Integer.parseInt(projTF.getText()) + Integer.parseInt(finalTF.getText())));
                stdNum++; // number of studenst
                System.out.println(info);
                System.out.println(stdNum);
                FileWrite1();
            }
    }});
        
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    
        public static boolean isString(String str){
        int n = str.length();
        str = str.toLowerCase();
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= 'a'&& str.charAt(i) <= 'z') {} // keep going
            else {
                return false; // catch noneString
            }
        }
        return true;
    }
        
        
        public static boolean isDigit(String str){
        int n = str.length();
        
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) >= '0'&& str.charAt(i) <= '9') {} // keep going
            else {
                return false; // catch nondigit
            }
        }
        return true;
    }
        
        
        public void FileWrite1(){
        try{
        FileWriter f = new FileWriter(src);
        
        for (int i = 0; i < info.size(); i+=7) {
            for (int j = 0; j < 7; j++) {
                f.write(info.get(i+j)+";");
                System.out.print(info.get(i+j)+";");
            }
            f.write("\n");
            System.out.println("\n");
        }
        
        f.close();
        
        }catch (IOException ex) {
      System.out.println("Error in read is found");
    }
    }
        
}