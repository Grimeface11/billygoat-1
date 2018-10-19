//Does the math involved with 3D graphics
package ice.berg;

//Import additional code


public class MPC {
    
    //Global variables
    static double DrawX;
    static double DrawY;
    
    static double calculatePosX(double[] ViewFrom, double[] ViewTo, double x, double y, double z) {
    setTop(ViewFrom, ViewTo, x, y, z);
    return DrawX;
    }
    static double calculatePosY(double[] ViewFrom, double[] ViewTo, double x, double y, double z) {
    setTop(ViewFrom, ViewTo, x, y, z);
    return DrawY;
    }
    static void setTop(double[] ViewFrom, double[] ViewTo, double x, double y, double z) {
    //For setting things
    Vector ViewVector = new Vector(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
    Vector DirectionVector = new Vector(1, 1, 1);
    Vector PlaneVector1 = ViewVector.CrossProduct(DirectionVector);
    Vector PlaneVector2 = ViewVector.CrossProduct(PlaneVector1);
    
    Vector ViewToPoint = new Vector(x - ViewFrom[0], y - ViewFrom[1], z - ViewFrom[2]);
    
    Vector RotationVector = findRotationVector(ViewFrom, ViewTo);
    Vector RotationConstant1 = ViewVector.CrossProduct(RotationVector);
    Vector RotationConstant2 = ViewVector.CrossProduct(RotationConstant1);
    
    double t = (ViewVector.x * ViewTo[0] + ViewVector.y*ViewTo[1] + ViewVector.z*ViewTo[2]
    -  (ViewVector.x * ViewFrom[0] + ViewVector.y*ViewFrom[1] + ViewVector.z*ViewFrom[2]))
    /  (ViewVector.x * ViewToPoint.x + ViewVector.y*ViewToPoint.y + ViewVector.z*ViewToPoint.z);
    
    x = ViewFrom[0] + ViewToPoint.x * t;
    y = ViewFrom[1] + ViewToPoint.y * t;
    z = ViewFrom[2] + ViewToPoint.z * t;
    
    if(t > 0) {
    DrawX = RotationConstant2.x * x + RotationConstant2.y * y + RotationConstant2.z * z;
    DrawY = RotationConstant1.x * x + RotationConstant1.y * y + RotationConstant1.z * z;
    }
    }
    
    static Vector findRotationVector(double[] ViewFrom, double[] ViewTo) {
    double dx = Math.abs(ViewFrom[0] - ViewTo[0]);
    double dy = Math.abs(ViewFrom[1] - ViewTo[1]);
    double xRot;
    double yRot;
    xRot = dy / (dx + dy);
    yRot = dx / (dx + dy);
    if(ViewFrom[1] > ViewTo[1]) {
    xRot = -xRot;
    }
    if(ViewFrom[0] < ViewTo[0]) {
    yRot = -yRot;
    }
        
    Vector V = new Vector(xRot, yRot, 0);
    return V;
    }
}
