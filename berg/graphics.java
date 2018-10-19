//Places the graphics on the JFrame
package ice.berg;

//Import additional code
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class graphics extends JPanel implements KeyListener{
    
    //Global Variables
    static polygonObject[] drawablePolygons = new polygonObject[2000];
    static double[] ViewFrom = new double[] {44, 52, 3};
    static double[] ViewTo = new double[] {-40, -47, -0.5};
    static int polygonNumber = 0;
    static int polygonNumber3D = 0;
    double sleep = 1000/60;
    double timer = 0;
    static polygon3D[] polygonsIn3D = new polygon3D[2000];
    int[] newOrder;
    boolean[] keyInput = new boolean[10];
    
    public graphics() {
    //Defines the information for each of the polygons and initiates important code
    addKeyListener(this);
    setFocusable(true);
    
    fileIO.cubeWorld();
    
    }
    
    public void paintComponent(Graphics g) {
    controlPanel();    
        
    g.clearRect(0, 0, 500, 500);
    g.drawString("System Time: " + System.currentTimeMillis(), 20, 20);
    g.drawString("ViewTo[0]: " + ViewTo[0], 20, 30);
    g.drawString("ViewTo[1]: " + ViewTo[1], 20, 40);
    g.drawString("ViewTo[2]: " + ViewTo[2], 20, 50);
    g.drawString("ViewFrom[0]: " + ViewFrom[0], 20, 60);
    g.drawString("ViewFrom[1]: " + ViewFrom[1], 20, 70);
    g.drawString("ViewFrom[2]: " + ViewFrom[2], 20, 80);
    for(int i = 0; i < polygonNumber3D; i++) {
    polygonsIn3D[i].editPolygon();
    }
    order();
    for(int i = 0; i < polygonNumber; i++) {
    drawablePolygons[newOrder[i]].drawPolygon(g);
    }
    redraw();
    }
    
    void order() {
    double[] k = new double[polygonNumber];
    newOrder = new int[polygonNumber];
    
    for(int i = 0; i < polygonNumber; i++) {
    k[i] = drawablePolygons[i].distanceToCamera;
    newOrder[i] = i;
    }
    
    double functionDouble;
    int functionInt;
    for(int a = 0; a < k.length - 1; a++) {
    for(int b = 0; b < k.length - 1; b++) {
    if(k[b] < k[b + 1]) {
    functionDouble = k[b];
    functionInt = newOrder[b];
    newOrder[b] = newOrder[b + 1];
    k[b] = k[b + 1];
    newOrder[b + 1] = functionInt;
    k[b + 1] = functionDouble;
    }
    }
    }
    }
    
    void redraw() {
    while(true) {
    if((System.currentTimeMillis() - timer) > sleep){
    timer = System.currentTimeMillis();
    repaint();
    break;
    }
    else{
    try{
    Thread.sleep((long)(sleep - (System.currentTimeMillis() - timer)));
    }
    catch(Exception e) {
    //Some code
    }
    }
    }
    }
    
    void controlPanel() {
    Vector ViewVector = new Vector(ViewTo[0] - ViewFrom[0], ViewTo[1] - ViewFrom[1], ViewTo[2] - ViewFrom[2]);
    Vector Vertical = new Vector(0, 0, 1);
    Vector SideView = ViewVector.CrossProduct(Vertical);
    
    if(keyInput[0]) {
    ViewTo[0]--;  
    }
    if(keyInput[1]) {
    ViewTo[0]++;  
    }
    if(keyInput[2]) {
    ViewTo[1]--;
    }
    if(keyInput[3]) {
    ViewTo[1]++;
    }
    if(keyInput[4]) {
    ViewFrom[0] += ViewVector.x;
    ViewFrom[1] += ViewVector.y;
    ViewFrom[2] += ViewVector.z;
    ViewTo[0] += ViewVector.x;
    ViewTo[1] += ViewVector.y;
    ViewTo[2] += ViewVector.z;
    }
    if(keyInput[5]) {
    ViewFrom[0] += SideView.x;
    ViewFrom[1] += SideView.y;
    ViewFrom[2] += SideView.z;
    ViewTo[0] += SideView.x;
    ViewTo[1] += SideView.y;
    ViewTo[2] += SideView.z;
    }
    if(keyInput[6]) {
    ViewFrom[0] -= ViewVector.x;
    ViewFrom[1] -= ViewVector.y;
    ViewFrom[2] -= ViewVector.z;
    ViewTo[0] -= ViewVector.x;
    ViewTo[1] -= ViewVector.y;
    ViewTo[2] -= ViewVector.z;
    }
    if(keyInput[7]) {
    ViewFrom[0] -= SideView.x;
    ViewFrom[1] -= SideView.y;
    ViewFrom[2] -= SideView.z;
    ViewTo[0] -= SideView.x;
    ViewTo[1] -= SideView.y;
    ViewTo[2] -= SideView.z;
    }
    if(keyInput[8]) {
    ViewFrom[2]--;
    ViewTo[2]--;
    }
    if(keyInput[9]) {
    ViewFrom[2]++;
    ViewTo[2]++;
    }
    }
    
    public void keyPressed(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_LEFT) {
    keyInput[0] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
    keyInput[1] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_UP) {
    keyInput[2] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_DOWN) {
    keyInput[3] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_W) {
    keyInput[4] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_A) {
    keyInput[5] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_S) {
    keyInput[6] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_D) {
    keyInput[7] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
    keyInput[8] = true;
    }
    if(e.getKeyCode() == KeyEvent.VK_SPACE) {
    keyInput[9] = true;
    }
    }
    
    public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == KeyEvent.VK_LEFT) {
    keyInput[0] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
    keyInput[1] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_UP) {
    keyInput[2] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_DOWN) {
    keyInput[3] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_W) {
    keyInput[4] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_A) {
    keyInput[5] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_S) {
    keyInput[6] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_D) {
    keyInput[7] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_SHIFT) {
    keyInput[8] = false;
    }
    if(e.getKeyCode() == KeyEvent.VK_SPACE) {
    keyInput[9] = false;
    }
    }
    
    public void keyTyped(KeyEvent e) {
        
    }
}
