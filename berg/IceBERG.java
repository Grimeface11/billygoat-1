//Ice BERG Test Program
package ice.berg;

//Import additional code
import javax.swing.JFrame;


public class IceBERG extends JFrame {
    
    //"Global" Variables
    
    //Add in the graphics
    graphics graphicsObject = new graphics();

    public static void main(String[] args) {
    new IceBERG().setVisible(true); //Starts the window
    }
    
    public IceBERG() {
    //Defines the window parameters
    super("IceBERG Game Engine - 3D Test");
    setSize(500, 500);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    //Add the graphicsObject
    add(graphicsObject);
    }
}