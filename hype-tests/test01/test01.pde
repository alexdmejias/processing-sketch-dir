HRect rect2;

void setup() {
	size(640,640);
	H.init(this).background(#242424);
	smooth();
	
	rect2 = new HRect(200);
	rect2 .rounding(10) .fill(#FF9900) .stroke(#000000, 150) .strokeWeight(6)
	.anchorAt(H.CENTER)
	.rotation(45)
	.loc(247,height / 2);

	H.add(rect2);
	 
	 
	H.drawStage(); // paint the stage
	 	 
	// noLoop();
}
 
void draw() {
	rect2.loc(mouseX, mouseY);
}
 