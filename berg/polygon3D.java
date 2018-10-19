//Handles rasterization of 3D polygons
package ice.berg;

//Import additional code
import java.awt.Color;
import java.awt.Polygon;

public class polygon3D {
    
    //Global Variables
    Color c;
    double[] x;
    double[] y;
    double[] z;
    int savePoly = 0;
    
    public polygon3D(double[] x, double[] y, double[] z, Color c) {
    //Gets the data from the function call
    this.x = x;
    this.y = y;
    this.z = z;
    this.c = c;
    createPolygon();
    }
    
    void createPolygon() {
    savePoly = graphics.polygonNumber;
    graphics.drawablePolygons[graphics.polygonNumber] = new polygonObject(new double[] {}, new double[] {}, c);
    graphics.drawablePolygons[savePoly].distanceToCamera = distance();
    }
    
    void editPolygon() {
    double vx = -50 * MPC.calculatePosX(graphics.ViewFrom, graphics.ViewTo, graphics.ViewTo[0], graphics.ViewTo[1], graphics.ViewTo[2]);;
    double vy = -50 * MPC.calculatePosY(graphics.ViewFrom, graphics.ViewTo, graphics.ViewTo[0], graphics.ViewTo[1], graphics.ViewTo[2]);;
    double[] newPosX = new double[x.length];
    double[] newPosY = new double[x.length];
    for(int i = 0; i < x.length; i++) {
    newPosX[i] = 250 + vx + 50 *MPC.calculatePosX(graphics.ViewFrom, graphics.ViewTo, x[i], y[i], z[i]);
    newPosY[i] = 250 + vy + 50 *MPC.calculatePosY(graphics.ViewFrom, graphics.ViewTo, x[i], y[i], z[i]);
    }
    graphics.drawablePolygons[savePoly] = new polygonObject(newPosX, newPosY, c);
    graphics.drawablePolygons[savePoly].distanceToCamera = distance();
    graphics.polygonNumber--;
    }
    
    double distance() {
    double total = 0;
    for(int i = 0; i < x.length; i++) {
    total += distanceScanner(i);
    }
    return total / x.length;
    }
    
    double distanceScanner(int i) {
    return Math.sqrt((graphics.ViewFrom[0] - x[i]) * (graphics.ViewFrom[0] - x[i]) +
                     (graphics.ViewFrom[1] - y[i]) * (graphics.ViewFrom[1] - y[i]) +
                     (graphics.ViewFrom[2] - z[i]) * (graphics.ViewFrom[2] - z[i]));   
    }
    
}
