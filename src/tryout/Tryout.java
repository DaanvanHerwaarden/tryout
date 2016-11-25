package tryout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
   
public class Tryout extends JFrame {
  public static void main( String args[] ) {
    JFrame frame = new Tryout();
    frame.setSize( 700, 300 );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setTitle( "Oefening 0607" );
    frame.setContentPane( new Paneel() );
    frame.setVisible( true );
  }
}

class Paneel extends JPanel {
  private Cirkel cirkel;
  private JButton knop;
  private JTextField straalVak, xVak, yVak;
      
  public Paneel() {
    setBackground( Color.RED );
    
    cirkel = new Cirkel( 100 );
    
    knop = new JButton( "Teken" );
    knop.addActionListener( new KnopHandler() );
    
    straalVak = new JTextField( 10 );
    xVak = new JTextField( 10 );
    yVak = new JTextField( 10 );
    
    add( new JLabel( "straal" ) );
    add( straalVak );
    add( new JLabel( "xM" ) );
    add( xVak );
    add( new JLabel( "yM" ) );
    add( yVak );
    add( knop );
  }

  public void paintComponent( Graphics g ) {
    super.paintComponent( g );
    cirkel.teken( g );
  }

 

class KnopHandler implements ActionListener {
    public void actionPerformed( ActionEvent e ) {
      String invoer = straalVak.getText();
      if( !invoer.equals( "" ) ) {
            	int straal = Integer.parseInt( invoer );
            	cirkel.setStraal( straal );
      }
    
      String invoer1, invoer2;
      invoer1 = xVak.getText();
      invoer2 = yVak.getText();
      
      if( !invoer1.equals( "" ) && !invoer2.equals( "" ) ) {
         int x = Integer.parseInt(invoer1);   
         int y = Integer.parseInt(invoer2);
         cirkel.setMiddelpunt(x,y);
      }
      repaint();
    }
  }
	
  

public class Cirkel {
  private int straal, xM, yM;
  
  public Cirkel( int straal ) {
           this.straal = straal;
  }
  
  public void setStraal( int straal ) {
            this.straal = straal;
  }

  public void setMiddelpunt( int xM, int yM ) {
           this.xM = xM;
           this.yM = yM;
  }
  
  public void teken( Graphics pen ) {
           pen.drawOval( xM - straal, yM - straal, 2 * straal, 2 * straal );
  }
}}
