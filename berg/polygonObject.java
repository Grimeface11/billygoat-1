//Builds the polygons for graphics to put on the JFrame
package ice.berg;

//Import addition code
import java.awt.Color;
import java.awt.Polygon;
import java.awt.Graphics;

public class polygonObject {
    
    //Global Variables
    Polygon p;
    Color c;
    double distanceToCamera = 0;
    
    public polygonObject(double[] x, double[] y, Color c) {
    //Receives data from the function call
    graphics.polygonNumber++;
    p = new Polygon();
    for (int i = 0; i < x.length; i++) {
    p.addPoint((int)x[i], (int)y[i]);
    }
    this.c = c;
    }
    
    void drawPolygon(Graphics g) {
    g.setColor(c);
    g.fillPolygon(p);
    g.setColor(Color.black);
    g.drawPolygon(p);
    }
    
}
