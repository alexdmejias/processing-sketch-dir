import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.serial.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class sketch_150301c extends PApplet {



Serial port;

int splitBy = 10;
int sectionWidth;
int[] sections = new int[splitBy];
int oldMouseX;
int selectedSection;
int mouseDown;
int[] data = new int[3];

public void setup() {
  size(500, 255);
  sectionWidth = width / splitBy;

  port = new Serial(this, Serial.list()[Serial.list().length -1], 9600);
}

public void draw() {
  clear();

	// set some defaults
  noStroke();

  data[0] = 0;
  data[1] = 0;
  data[2] = 0;

	// setup the rectangles
	for(int i = 0; i < splitBy; i++) {
    sections[i] = sectionWidth * (1 + i); 
    fill(i*20);
    rect(sections[i] - sectionWidth, 0, sections[i], height);
  }

  if (mouseX != oldMouseX) {
	  // set the color of the "cursor" and draw cursor
	  // set it to red by default, green if pressed
 	  fill(255, 0, 0);
 	  if (mousePressed) {
 	  	fill(0, 255, 0);
 	  }
 	  ellipse(mouseX, mouseY, 30, 30);

 	  // detect in which section the cursor is in
 	  for(int i = 0; i < sections.length; i++) {
 	  	if (mouseX < sections[i]) {
 	  		data[0] = i;
 	  		break;
 	  	}
 	  }
  }

	// if the mouse is pressed, add 100 to the value to send in order
	// to denote it
  if (mousePressed) {
  	data[1] = 1;
  }

  data[2] = mouseY;

  String dataToSend = data[0]+","+data[1]+","+data[2]+"\n";
  port.write(dataToSend);

  println(dataToSend);
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_150301c" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
