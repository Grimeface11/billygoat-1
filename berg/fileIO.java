//The resource file for 
package ice.berg;

//Import additional code
import java.awt.Color;

public class fileIO {
    
    //Global Variables
    
    public static void cubeWorld() {
    //The resources for the cube world
    graphics.polygonNumber3D = 631;
 
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {0, 2, 2, 0}, new double[] {0, 0, 2, 2}, new double[] {0, 0, 0, 0}, Color.blue);
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {0, 2, 2, 0}, new double[] {0, 0, 2, 2}, new double[] {3, 3, 3, 3}, Color.red);
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {0, 2, 2, 0}, new double[] {0, 0, 0, 0}, new double[] {0, 0, 3, 3}, Color.green);
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {0, 2, 2, 0}, new double[] {2, 2, 2, 2}, new double[] {0, 0, 3, 3}, Color.magenta);
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {0, 0, 0, 0}, new double[] {0, 2, 2, 0}, new double[] {0, 0, 3, 3}, Color.orange);
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {2, 2, 2, 2}, new double[] {0, 2, 2, 0}, new double[] {0, 0, 3, 3}, Color.yellow);
    
    //Grow grass
    for(int i = -10; i < 15; i++){ //-4
    for(int j = -10; j < 15; j++){ //-4
    graphics.polygonsIn3D[graphics.polygonNumber] = new polygon3D(new double[] {i, i, i + 1, i + 1}, new double[] {j, j + 1, j + 1, j}, new double[] {0, 0, 0, 0}, Color.green);    
    }
    }
    }
    
}
