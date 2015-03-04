import processing.serial.*;

Serial port;

int splitBy = 10;
int sectionWidth;
int[] sections = new int[splitBy];
int oldMouseX;
int selectedSection;
int mouseDown;
int dataToSend;

void setup() {
  size(500, 500);
  sectionWidth = width / splitBy;

  port = new Serial(this, Serial.list()[Serial.list().length -1], 9600);
}

void draw() {
  clear();

	// set some defaults
  noStroke();
  mouseDown = 0;

	// setup the rectangles
	for(int i = 0; i < splitBy; i++) {
    sections[i] = sectionWidth * (1 + i); 
    fill(i*20);
    rect(sections[i] - sectionWidth, 0, sections[i], height);
  }

  if (mouseX != oldMouseX) {

	  // set the color of the "cursor" and draw cursor
 	  fill(255, 0, 0);
 	  if (mousePressed) {
 	  	fill(0, 255, 0);
 	  }
 	  ellipse(mouseX, mouseY, 30, 30);

 	  // detect in which section the cursor is in
 	  for(int i = 0; i < sections.length; i++) {
 	  	if (mouseX < sections[i]) {
 	  		selectedSection = i;
			  dataToSend = selectedSection;
 	  		break;
 	  	}
 	  }
  }

	// if the mouse is pressed, add 100 to the value to send in order
	// to denote it
  if (mousePressed) {
  	mouseDown = 100;
  }
  dataToSend += mouseDown;

	// send the data
  port.write(dataToSend);
  println(dataToSend);
   
}
