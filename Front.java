package Students;
import static Students.Add.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Front extends JFrame {
    private JLabel L1; // welcome text
    private JButton add , find, stat; // 3 buttons
    private Add page1;
    private Find page2;
    public static String src;
    
    
    public Front(String s){
        super("Students marks");
        this.setLocation(500, 400);
        this.setSize(300,400);
        
        this.src = s;
        try {
            READ(); // readiing from a file
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Front.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        L1 = new JLabel("Welcome");
        add = new JButton("Add student");
        find = new JButton("Find student");
        stat = new JButton("Statistics");
        
        
        JPanel p = (JPanel) this.getContentPane();
        JPanel j1 = new JPanel();
        JPanel j2 = new JPanel();
        
        j1.add(L1);
        p.add(j1, BorderLayout.PAGE_START);
        
        j2.add(add);
        j2.add(find);
        j2.add(stat);
        j2.setLayout(new GridLayout(3,1));
        p.add(j2, BorderLayout.CENTER);
        
        
        //Action listiners
        add.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        page1 = new Add();
    }});
        
        
        find.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        page2 = new Find();
    }});
        
        
        stat.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e) {
        printStat();
    }});
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);        
    }
    
    
    void printStat(){
        String stt = "          ID             F.N          L.N          Mid          Project          final          Sum\n\n";
        
        if(!info.isEmpty()){
           
            for (int i = 100, x = info.size()-1, y = stdNum; ((i >= 0) && (y > 0)); x-=7) {
                if(x<5){
                   x = info.size()-1;
                   i--;
                }
                if((int)info.get(x) == i){
                    for (int j = 6; j >= 0 ; j--) {
                        stt+="          "+info.get(x-j);
                    }
                     y--; stt+="\n";
                }
            }
            
            JOptionPane.showMessageDialog ( null, stt, "Statistics", JOptionPane.INFORMATION_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog ( null, "Nothing here yet", "Statistics", JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    void READ() throws FileNotFoundException{
        FileReader fr = new FileReader(src);
        int i; int c = 0; String s = "";
        
        try {
            while ((i = fr.read()) != -1){
                
                if((char)i == ';'){
                    c++;
                    if(c>3){
                        info.add(Integer.parseInt(s));
                        s = "";
                        continue;
                    }
                    else{
                    info.add(s);
                    s = "";
                    continue;
                    }
                }
                else if((char)i == '\n'){
                    c=0;
                    continue;
                }
                
                s += ""+(char)i;
            }  
            
        } catch (IOException ex) {
            Logger.getLogger(Front.class.getName()).log(Level.SEVERE, null, ex);
        }
        stdNum += (info.size()/7);
    }
    
       
    public static void main(String[] args) {
        Front obj = new Front("N:\\IDkman\\file.txt");
    }
}