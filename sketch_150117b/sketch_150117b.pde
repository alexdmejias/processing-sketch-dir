int radiansVar = 0;
void setup() {
  size(300,300);
  rectMode(CENTER);
  rect(30,30,30,30);
  smooth();
}

void draw() {
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
