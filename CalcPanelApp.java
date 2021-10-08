/* Arnold Beck */
/* arnold.beck@web.de */

import java.lang.*;
import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import beck.CalcTextField.*;

public class CalcPanelApp extends Panel implements ActionListener
{
  CalcTextField tIn;  // Inputarea
  TextField tOut; // Outputarea
  Label     enter=new Label("Enter expression:");
  Label     resul=new Label("Result:");
  Label     Head =new Label("Expression Calculator");

  Button    BOK  =new Button("Calculate");
  Panel     p0   =new Panel();
  Panel     p1   =new Panel();
  Panel     p2   =new Panel();
  Panel     p3   =new Panel();

  public CalcPanelApp()
  {
    Font F;
    setLayout(new GridLayout(4,1,5,10));
    tIn =new CalcTextField();
    tIn.addActionListener(this);
    tOut=new TextField(30);
    tOut.setEditable(false);
    p0.setLayout(new FlowLayout(FlowLayout.CENTER));
    p1.setLayout(new GridLayout(1,2));
    p2.setLayout(new GridLayout(1,2));
    p3.setLayout(new FlowLayout(FlowLayout.CENTER));
    Head.setFont(new Font("Helvetica",Font.PLAIN,20));
    enter.setFont(new Font("Helvetica",Font.PLAIN,16));
    resul.setFont(new Font("Helvetica",Font.PLAIN,16));
    BOK  .setFont(new Font("Helvetica",Font.PLAIN,18));
    BOK  .addActionListener(this);
    p0.add(Head);
    p1.add(enter); p1.add(tIn);
    p2.add(resul); p2.add(tOut);
    p3.add(BOK);
    add(p0);
    add(p1);
    add(p2);
    add(p3);
    repaint();
  }

  /* calc erzeugt ein Objekt ExecCalc, das ausser dem Konstruktor
     eine Methode getResult() bereitstellt. */

  private void calc()
  {
//      System.out.println("calc1");
     tOut.setText(tIn.getText());
//      System.out.println("calc2");
  }

  public void actionPerformed(ActionEvent e)
  {
    if (e.getSource()==tIn)calc();
    if (e.getSource()==BOK)calc();
  }
  
  public static void main(String args[])
  {
     Frame f=new Frame("Calulating Textfield Demopanel");
     Panel p=new CalcPanelApp();
     f.add(p);
     f.addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent ew){System.exit(0);}});
     f.setVisible(true);
     f.pack();
  }
}

