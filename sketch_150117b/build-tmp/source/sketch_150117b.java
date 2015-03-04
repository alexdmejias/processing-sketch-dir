import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_150117b extends PApplet {

int radiansVar = 0;
public void setup() {
  size(300,300);
  rectMode(CENTER);
  rect(30,30,30,30);
  smooth();
}

public void draw() {
  background(100);
  clear();
  pushMatrix();
  fill(random(255), random(255), random(255));
  translate(width/2, height/2);
  rotate(radians(radiansVar));
  rect(0,0,30,30);
  popMatrix();
  radiansVar++;
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_150117b" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
