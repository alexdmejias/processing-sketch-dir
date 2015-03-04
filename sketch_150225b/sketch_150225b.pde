PShape basemap;
String csv[];
String myData[][];

void setup() {
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

void draw() {
	rect(50,50,50,50);
	// noStroke();
	stroke(0, 50);
	fill(0,50);
	shape(basemap, 0, 0, width, height);

	// place,year,mass_g,longitude,latitude,fell_found
	for (int i = 0; i < myData.length; i++) {
		float lngMap = map(float(myData[i][3]), -180, 180, 0, width);
		float latMap = map(float(myData[i][4]), 90, -90, 0, height);
		float markerSize = 0.04 * sqrt(float(myData[i][2]) / PI);
		ellipse(lngMap, latMap, markerSize, markerSize);
	}
}