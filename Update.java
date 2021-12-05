package Students;
import static Students.Add.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static Students.Front.*;
import javax.swing.*;

public class Update extends JFrame {
    int index;
    private JLabel idL, fnL, lnL, midL, projL, finalL; // Labels
    private JTextField idTF, fnTF, lnTF, midTF, projTF, finalTF; // text fields
    private JButton updt, cncl;
    
    
    public Update(int x){
        super("Update "+info.get(x));
        this.setLocation(550, 100);
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
        
        updt = new JButton("Update");
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
        
        j1.add(updt);
        j1.add(cncl);
        
        p.add(j1, BorderLayout.CENTER);
        
        idTF.setText(""+info.get(x));
        fnTF.setText(""+info.get(x+1));
        lnTF.setText(""+info.get(x+2));
        midTF.setText(""+info.get(x+3));
        projTF.setText(""+info.get(x+4));
        finalTF.setText(""+info.get(x+5));
        
        
        
        // Action Listenrs
        cncl.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        idTF.setText("");
        fnTF.setText("");
        lnTF.setText("");
        midTF.setText("");
        projTF.setText("");
        finalTF.setText("");
    }});
        
        updt.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
            boolean wrongIn = false;
            String s = "";
            
            // ID checking
            if(idTF.getText().isEmpty() || idTF.getText().isBlank()){
                s += "-Empty ID\n";
                wrongIn = true;
            }
            else if(isDigit(idTF.getText())){
                Object temp = info.get(x);
                info.set(x,0);
                
                if(idTF.getText().length() < 4){
                    s += "-ID must be at least four numbers\n";
                    wrongIn = true;
                    info.set(x, temp);
                }
                else if(info.contains(idTF.getText())){
                    s += "-This student already exists\n";
                    wrongIn = true;
                    info.set(x, temp);
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
                info.set(x,idTF.getText());
                info.set(x+1,fnTF.getText());
                info.set(x+2,lnTF.getText());
                info.set(x+3,Integer.parseInt(midTF.getText()));
                info.set(x+4,Integer.parseInt(projTF.getText()));
                info.set(x+5,Integer.parseInt(finalTF.getText()));
                
                //sum of all marks
                info.set(x+6,(Integer.parseInt(midTF.getText()) + Integer.parseInt(projTF.getText()) + Integer.parseInt(finalTF.getText())));
                System.out.println(info);
                FileWrite1();
            }
               
    }});
        
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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