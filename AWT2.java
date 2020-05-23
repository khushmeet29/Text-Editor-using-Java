//Importing needed packages :

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*; 

//MainClass implementing Action Listener :

class AWT2 implements ActionListener{		//InterFace

    int val,pos,style=0,fontsize=18,init=0,index=0;

    String mpl="",fontname="Times New Roman";
    TextArea t1;
    TextField size,search,rep;
    Button b1,b2,b3,b3i,b3ii,b3iii,b3iv,b3v,b4,bold,italic,normal,inc,dec,choice,findd,replace,replaceall;
    Font F;
    Choice fonts;
    Frame f1 = new Frame("My Editor.");
    AWT2(){

        f1.setBounds(0,0,1500,1500);
        f1.setLayout(null);                    //Specifying Layout
        f1.addWindowListener(new close());     //Implementing Window Listener on the frame
        f1.setBackground(Color.pink);

	//ADDING THE DIFFERENT COMPONENTS :
	
        t1 = new TextArea();
        t1.setBounds(150,150,850,550);

        fonts = new Choice();
        fonts.setBounds(760,120,145,25);
        fonts.add("Times New Roman");
        fonts.add("Monospaced");
        fonts.add("Serif");

        choice = new Button("Set");
        choice.setBounds(945,118,40,25);
        choice.addActionListener(this);
        choice.setFont(new java.awt.Font("Serif", 2,14));

        normal = new Button("N");
        normal.setBounds(100,150,25,25);
        normal.addActionListener(this);
        normal.setFont(new java.awt.Font("Serif", 0,14));

        bold = new Button("B");
        bold.setBounds(100,190,25,25);
        bold.addActionListener(this);
        bold.setFont(new java.awt.Font("Times New Roman", 1,14));

        italic = new Button("I");
        italic.setBounds(100,230,25,25);
        italic.addActionListener(this);
        italic.setFont(new java.awt.Font("Serif", 2,14));

        size = new TextField();
        size.setBounds(915,118,25,25);
        size.setText(""+fontsize);
        size.setEditable(false);
        
        search = new TextField();
        search.setBounds(150,110,100,35);
        search.setFont(new java.awt.Font("Serif", 2,18));
        
        rep = new TextField();
        rep.setBounds(400,110,100,35);
        rep.setFont(new java.awt.Font("Serif", 2,18));
        
        inc = new Button("+");
        inc.setBounds(990,115,18,18);
        inc.addActionListener(this);
        inc.setFont(new java.awt.Font("Times New Roman", 1,14));
        
        dec = new Button("-");
        dec.setBounds(990,130,18,18);
        dec.addActionListener(this);
        dec.setFont(new java.awt.Font("Times New Roman", 1,14));

        b1 = new Button("New");
        b1.setBounds(150,45,100,50);
        b1.addActionListener(this);
        b1.setFont(new java.awt.Font("Serif", 2,18));
        
        b2 = new Button("Open");
        b2.setBounds(400,45,100,50);
        b2.addActionListener(this);
        
        b2.setFont(new java.awt.Font("Serif", 2,18));
        b3 = new Button("Save As");
        b3.setBounds(650,45,100,50);
        b3.addActionListener(this);
        b3.setFont(new java.awt.Font("Serif", 2,18));
        
        b4 = new Button("Exit");
        b4.setBounds(1150,45,100,50);
        b4.addActionListener(this);
        b4.setFont(new java.awt.Font("Serif", 2,18));
        
        b3v = new Button("Select All");
        b3v.setBounds(900,45,100,50);
        b3v.addActionListener(this);
        b3v.setFont(new java.awt.Font("Serif", 2,18));
        
        b3i= new Button("Cut");
        b3i.setBounds(1150,150,100,100);
        b3i.addActionListener(this);
        b3i.setFont(new java.awt.Font("Serif", 2,18));
        
        b3ii = new Button("Copy");
        b3ii.setBounds(1150,300,100,100);
        b3ii.addActionListener(this);
        b3ii.setFont(new java.awt.Font("Serif", 2,18));

        b3iii = new Button("Paste");
        b3iii.setBounds(1150,450,100,100);
        b3iii.addActionListener(this);
        b3iii.setFont(new java.awt.Font("Serif", 2,18));

        b3iv = new Button("Delete");
        b3iv.setBounds(1150,600,100,100);
        b3iv.addActionListener(this);
        b3iv.setFont(new java.awt.Font("Serif", 2,18));
        
        findd = new Button("Find");
        findd.setBounds(255,110,80,35);
        findd.addActionListener(this);
        findd.setFont(new java.awt.Font("Serif", 2,18));
        
        replace = new Button("Replace");
        replace.setBounds(510,110,100,35);
        replace.addActionListener(this);
        replace.setFont(new java.awt.Font("Serif", 2,18));
        
        replaceall = new Button("Replace All");
        replaceall.setBounds(620,110,120,35);
        replaceall.addActionListener(this);
        replaceall.setFont(new java.awt.Font("Serif", 2,18));

        F = new Font(fontname,style,fontsize);

        t1.setForeground(Color.black);
        t1.setFont(F);

        f1.add(t1);
        f1.add(b1);
        f1.add(b2);
        f1.add(b3);
        f1.add(b3i);
        f1.add(b3ii);
        f1.add(b3iii);
        f1.add(b3iv);
        f1.add(b3v);
        f1.add(b4);
        f1.add(bold);
        f1.add(normal);
        f1.add(italic);
        f1.add(inc);
        f1.add(dec);
        f1.add(size);
        f1.add(fonts);
        f1.add(choice);
        f1.add(search);
        f1.add(findd);
        f1.add(replace);
        f1.add(replaceall);
        f1.add(rep);

        f1.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        String fname,line,line1;
        try{
        
            if(ae.getSource()==b1){                    //New Button
                f1.dispose();
                AWT2 Ax = new AWT2();
            }
            
            else if(ae.getSource()==choice) {          //Font Setting
                int index;
                fontname = fonts.getSelectedItem();
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                t1.setFont(new java.awt.Font(fontname, style, fontsize));
                
            }
            
            else if(ae.getSource()==b2)                 //Open File
            {

                FileDialog fd = new FileDialog(f1,"FILES",FileDialog.LOAD);
                fd.setVisible(true);

                fname = fd.getDirectory() + fd.getFile();
                BufferedReader br = new BufferedReader(new FileReader(fname));
                StringBuffer sb = new StringBuffer();
                line = br.readLine();

                while(line!=null){
                    sb.append(line+"\n");
                    line = br.readLine();
                }

                line1 = sb.toString();
                t1.setText(line1);
            }

            else if(ae.getSource()==b3)                     //Save As
            {
                FileDialog fd = new FileDialog(f1,"FILES",FileDialog.SAVE);
                fd.setVisible(true);

                line1 = t1.getText();

                fname = fd.getDirectory() + fd.getFile();
                BufferedReader br = new BufferedReader(new StringReader(line1));
                StringBuffer sb = new StringBuffer();
                DataOutputStream ds = new DataOutputStream(new FileOutputStream(fname));
                line = br.readLine();

                while(line!=null)
                {
                    ds.writeBytes(line+"\n");
                    line = br.readLine();
                }

                ds.close();
            }
            
            else if(ae.getSource()==b3i){                     //CUT feature
                mpl = t1.getSelectedText();
                val = t1.getText().indexOf(mpl);
                t1.replaceRange("",val,val+mpl.length());

            }
            
            else if(ae.getSource()==b3ii){                    //COPY feature
                mpl = t1.getSelectedText();
            }
            
            else if(ae.getSource()==b3iii){                   //PASTE feature

               pos = t1.getCaretPosition();
               t1.insert(mpl,pos);
            }
            
            else if(ae.getSource()==b3iv){                     //DELETE feature
                String msg = t1.getSelectedText();
                val = t1.getText().indexOf(msg);
                t1.replaceRange("",val,val+msg.length());
                msg="";
            }
            
            else if(ae.getSource()==b3v){                      //SELECT ALL Text
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
            }
            
            else if(ae.getSource()==normal){                   //Text Style - Normal
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                t1.setFont(new java.awt.Font(""+fontname+"", 0, fontsize));
                style=0;
            } 
            
            else if(ae.getSource()==bold){                     //Text Style - Bold
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                t1.setFont(new java.awt.Font(""+fontname+"", 1, fontsize));
                style=1;
            }
            
            else if(ae.getSource()==italic){
                t1.setFont(new java.awt.Font(""+fontname+"", 2, fontsize));  //Text Style - Italic
                style=2;
            }
            
            else if(ae.getSource()==inc){                      //Increasing Font Size
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                fontsize=fontsize+2;
                t1.setFont(new java.awt.Font(""+fontname+"", style, fontsize));
                size.setText(""+fontsize);
            }
            
            else if(ae.getSource()==dec){                       //Decreasing Font Size

                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                if(fontsize!=2){
                    fontsize=fontsize-2;
                t1.setFont(new java.awt.Font(""+fontname+"", style, fontsize));
                size.setText(""+fontsize);
                }
                else{
                    JOptionPane.showMessageDialog(f1,"MINIMUM SIZE REACHED.");
                }
            }
            
            else if(ae.getSource()==findd){                       //Find Button        
            	 String sText = search.getText();
               if(sText != null)
               {
                  String tSearch = t1.getText();
                  int size = tSearch.length();
                  boolean endOfSearch = false;
                  while(!endOfSearch)
                  {
                     index = 0;
                     t1.setCaretPosition(0);
                     init = t1.getCaretPosition();
                     index = tSearch.indexOf(sText, init);
                     if(index != -1)
                     {
                        endOfSearch = true;
                        t1.select(index, index + sText.length());
                        init = t1.getCaretPosition();
                     }
                     else
                     {
                        endOfSearch = true;
                        JOptionPane.showMessageDialog(f1,"not found");
                     }
                  }
               }
            }
            
            else if(ae.getSource()==replace){                       //Replace Button        
            	 String from = search.getText();
               if(from != null)
               {
                  String replacer = rep.getText();
                  if(index >= 0 && replacer.length() > 0)
                  {
                     int end = index + from.length();
                     t1.replaceRange(replacer, index, end);
                     t1.setCaretPosition(0);
                     init = t1.getCaretPosition();
                     JOptionPane.showMessageDialog(f1,"SUCCESS!");
                  }
                  
               }
               search.setText("");
               rep.setText("");
            }
            
            else if(ae.getSource()==replaceall){                        //Replace All Button        
            	t1.setCaretPosition(0);
            	init = t1.getCaretPosition();
            	 String from = search.getText();
               if(from != null)
               {
                  String tSearch = t1.getText();
                  String replacer = rep.getText();
                  if(replacer.length() > 0)
                  {
                     index = tSearch.indexOf(from, init);
                     if(index == -1)
                        JOptionPane.showMessageDialog(f1,"not found");
                     else
                     {
                        while(index != -1)
                        {
                           int end = index + from.length();
                           t1.replaceRange(replacer, index, end);
                           init = init + replacer.length() + 1;
                           tSearch = t1.getText();
                           index = tSearch.indexOf(from, init);
                        }
                        JOptionPane.showMessageDialog(f1,"SUCCESS!");
                        
                     }
                  }
               }
               search.setText("");
               rep.setText("");
            }
            
            else System.exit(0);                      //Exit Button        
        }
        
        catch(Exception E){}
    }

    class close extends WindowAdapter{               //Implementing Window Events 

        public void windowClosing(WindowEvent we){
            System.exit(0);
        }

    }
    
    public static void main(String args[]){          //Main Method
        AWT2 A2 = new AWT2();                        //Object Creation

    }

}



