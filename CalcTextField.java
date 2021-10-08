/**************************************************************
  Class CalcTextField

  A modified TextField control that calculats
  automatically the value of an expression the user typed 
  in. When the control losts the focus, the Control
  swiches into Resultmode and displays the result of
  the expression. Wenn the control gets the focus
  again, the control swiches to the expression mode
  and displays the the editable expression.

  uses  :       ExprCalc.class

  Author:       Arnold Beck
  e-mail:       beck@informatik.htw-dresden

**************************************************************/  
package beck.CalcTextField;
import java.lang.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class CalcTextField extends TextField 
                           implements FocusListener
{
  private String theInput;
  private boolean hasFocus=false;

  /***********************************************************
  The constructor 
  the string describes the expression to calculate 
  ***********************************************************/
  
  public CalcTextField(String S)
  {
    super(S);
    theInput=S;
    addFocusListener(this);
  }

  public CalcTextField()
  {
    super("0");
    theInput="0";
    addFocusListener(this);
  }

  /***********************************************************
  Overridden Method focusGained, swiches to expression mode
  ***********************************************************/

  public void focusGained(FocusEvent e)
  {
    super.setText(theInput);
    hasFocus=true;
  }
  /***********************************************************
  Overridden Method focusLost, swiches to result mode after
  the calculation of the expression
  ***********************************************************/

  public void focusLost(FocusEvent e)
  {
    theInput=super.getText();
    hasFocus=false;
    try
    {
      double d=new ExprCalc(theInput).getResult();
      Double D=Double.valueOf(d);    
      super.setText(D.toString());
    }
    catch(Exception exept)
    {
      super.setText("Exception");
    }
  }
  /***********************************************************
  Overridden Method returns the calculated Value as a String
  ***********************************************************/

  public String getText()
  {
    try
    {
      if (hasFocus) theInput=super.getText();
      double d=new ExprCalc(theInput).getResult();
      Double D=Double.valueOf(d);
      return D.toString();
    }
    catch(Exception e)
    {
      super.setText("Exception");
    }
    return "0.0";
  }

  /***********************************************************
  Overridden Method to fill in an expression
  ***********************************************************/

  public void setText(String t)
  {
    theInput=t;
    super.setText(t);
  }
}
