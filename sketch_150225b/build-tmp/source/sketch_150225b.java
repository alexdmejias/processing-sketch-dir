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

public class sketch_150225b extends PApplet {

PShape basemap;
String csv[];
String myData[][];

public void setup() {
	size(1800,900);
	noLoop();
	basemap = loadShape("WorldMap.svg");
	csv = loadStrings("MeteorStrikesDataSet.csv");
	myData = new String[csv.length][6];

	for (int i = 0; i < csv.length; i++) {
		myData[i] = csv[i].split(",");
	}
	println("myData[20][4]: "+myData[20][4]);
}

public void draw() {
	rect(50,50,50,50);
	// noStroke();
	stroke(0, 50);
	fill(0,50);
	shape(basemap, 0, 0, width, height);

	// place,year,mass_g,longitude,latitude,fell_found
	for (int i = 0; i < myData.length; i++) {
		float lngMap = map(PApplet.parseFloat(myData[i][3]), -180, 180, 0, width);
		float latMap = map(PApplet.parseFloat(myData[i][4]), 90, -90, 0, height);
		float markerSize = 0.04f * sqrt(PApplet.parseFloat(myData[i][2]) / PI);
		ellipse(lngMap, latMap, markerSize, markerSize);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "sketch_150225b" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
