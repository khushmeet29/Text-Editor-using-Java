//Importing needed packages :

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

//MainClass implementing Action Listener :
class AWT2 implements ActionListener{

    int val,pos,style=0,fontsize=18;

    String mpl="",fontname="Times New Roman";
    TextArea t1;
    TextField size;
    Button b1,b2,b3,b3i,b3ii,b3iii,b3iv,b3v,b4,bold,italic,normal,inc,dec,choice;
    Font F;
    Choice fonts;
    Frame f1 = new Frame("My Editor.");
    
	//Constructor :
	AWT2(){

        f1.setBounds(0,0,1000,1500);
        f1.setLayout(null);				//Specifying Layout
        f1.addWindowListener(new close());		//Implementing Window Listener on the frame
        f1.setBackground(Color.pink);
	
	//ADDING THE DIFFERENT COMPONENTS :
	
        t1 = new TextArea();
        t1.setBounds(150,150,700,550);

        fonts = new Choice();
        fonts.setBounds(600,120,145,25);
        fonts.add("Times New Roman");
        fonts.add("Monospaced");
        fonts.add("Serif");

        choice = new Button("Set");
        choice.setBounds(750,118,40,25);
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
        size.setBounds(800,118,25,25);
        size.setText(""+fontsize);
        size.setEditable(false);

        inc = new Button("+");
        inc.setBounds(830,115,15,15);
        inc.addActionListener(this);
        inc.setFont(new java.awt.Font("Times New Roman", 1,14));
        dec = new Button("-");
        dec.setBounds(830,130,15,15);
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
        b3i.setBounds(900,150,100,100);
        b3i.addActionListener(this);
        b3i.setFont(new java.awt.Font("Serif", 2,18));
        b3ii = new Button("Copy");
        b3ii.setBounds(900,300,100,100);
        b3ii.addActionListener(this);
        b3ii.setFont(new java.awt.Font("Serif", 2,18));

        b3iii = new Button("Paste");
        b3iii.setBounds(900,450,100,100);
        b3iii.addActionListener(this);
        b3iii.setFont(new java.awt.Font("Serif", 2,18));

        b3iv = new Button("Delete");
        b3iv.setBounds(900,600,100,100);
        b3iv.addActionListener(this);
        b3iv.setFont(new java.awt.Font("Serif", 2,18));
	
	//Visual Properties
        F = new Font(fontname,style,fontsize);

        t1.setForeground(Color.blue);
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
	
	//Frame Visibility set to True
        f1.setVisible(true);

    }

    //Action Event Implementation for different buttons :
    public void actionPerformed(ActionEvent ae){

        String fname,line,line1;
        try{
            if(ae.getSource()==b1){				//New Editor
                f1.dispose();
                AWT2 Ax = new AWT2();
            }
            else if(ae.getSource()==choice) {			//Font Setting
                int index;
                fontname = fonts.getSelectedItem();
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                t1.setFont(new java.awt.Font(fontname, style, fontsize));
                
            }
            else if(ae.getSource()==b2)				//Open File
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

            else if(ae.getSource()==b3)				//Save As
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
            else if(ae.getSource()==b3i){			//CUT feature
                mpl = t1.getSelectedText();
                val = t1.getText().indexOf(mpl);
                t1.replaceRange("",val,val+mpl.length());

            }
            else if(ae.getSource()==b3ii){			//COPY feature
                mpl = t1.getSelectedText();
            }
            else if(ae.getSource()==b3iii){			//PASTE feature
               pos = t1.getCaretPosition();
               t1.insert(mpl,pos);
            }
            else if(ae.getSource()==b3iv){			//DELETE Text
                String msg = t1.getSelectedText();
                val = t1.getText().indexOf(msg);
                t1.replaceRange("",val,val+msg.length());
                msg="";
            }
            else if(ae.getSource()==b3v){			//SELECT ALL Text
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
            }
            else if(ae.getSource()==normal){			//Text Style - Normal
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                t1.setFont(new java.awt.Font(""+fontname+"", 0, fontsize));
                style=0;
            }
            else if(ae.getSource()==bold){			//Text Style - Bold
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                t1.setFont(new java.awt.Font(""+fontname+"", 1, fontsize));
                style=1;
            }
            else if(ae.getSource()==italic){			//Text Style - Italic
                //String txt = t1.getSelectedText();
                t1.setFont(new java.awt.Font(""+fontname+"", 2, fontsize));
                style=2;
            }
            else if(ae.getSource()==inc){			//Increasing Font Size
                String txt = t1.getText();
                int txt_len = txt.length();
                t1.select(0,txt_len);
                fontsize=fontsize+2;
                t1.setFont(new java.awt.Font(""+fontname+"", style, fontsize));
                size.setText(""+fontsize);
            }
            else if(ae.getSource()==dec){			//Decreasing Font Size

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

            else System.exit(0);				//Exit Button        
	}
        catch(Exception E){}
    }

    class close extends WindowAdapter{				//Implementing Window Events

        public void windowClosing(WindowEvent we){
            System.exit(0);
        }

    }
    public static void main(String args[]){			//Main Method
        AWT2 A2 = new AWT2();					//Object Creation

    }

}





