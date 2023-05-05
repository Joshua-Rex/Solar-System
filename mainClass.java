
public class mainClass {
	public static void main(String[] args) {
		// Create a Sphere for the sun at coord (0, 0)
		// Using the planetClass, create 8-9 planets (9 if you want to include Pluto)
		// Alter the variables for the planets to change their orbit, angle and size
		
		// Sets the scale, clears the light and creates the sun with a light in the sphere
		StdDraw3D.setScale(-400, 400);
		StdDraw3D.clearLight();
		StdDraw3D.Shape sun = StdDraw3D.sphere(0, 0, 0, (25/2), "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\sunmap.jpg");
		StdDraw3D.pointLight(sun.getPosition(), StdDraw3D.WHITE);
		
		// Array Values { 0 = Mercury, 1 = Venus, 2 = Earth, 3 = Mars, 4 = Jupiter, 5 = Saturn, 6 = Uranus, 7 = Neptune, 8 = Pluto }
		planetClass[] planets = new planetClass[9];
		for (int i = 0; i < planets.length; i++) planets[i] = new planetClass();
		
		// Declares all the planets and moons
		planets[0].setPlanet("Mercury", 0.008, 20, 40, 0, 3, 0, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\mercurymap.jpg");
		planets[1].setPlanet("Venus", 0.007, 20, 80, 0, 5, 0, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\venusmap.jpg");
		planets[2].setPlanet("Earth", 0.006, 20, 120, 0, 5, 1, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\earthmap.jpg");
			planets[2].setMoons("Earth's Moon", 0.03, 20, 2, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\earthmoonmap.jpg");
		planets[3].setPlanet("Mars", 0.0045, 20, 160, 0, 4, 2, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\marsmap.jpg");
			planets[3].setMoons(new String[] {"Deimos", "Phobos"}, new double[] {0.02, 0.05}, new double[] {20, 20}, new int[] {1, 1}, new String[] {"D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\deimosmap.jpg", "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\phobosmap.jpg"});
		planets[4].setPlanet("Jupiter", 0.001, 20, 200, 0, 15, 3, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\jupitermap.jpg");
			planets[4].setMoons(new String[] {"Io", "Europa", "Ganymede" },  new double[] {0.04, 0.05, 0.02}, new double[] {20, 20, 20}, new int[] {1, 1, 1}, new String[] {"D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\iomap.jpg", "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\europamap.jpg", "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\ganymedemap.jpg"});
		planets[5].setPlanet("Saturn", 0.002, 20, 240, 0, 10, 2, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\saturnmap.jpg");
			planets[5].setMoons(new String[] {"Enceladus", "Titan"}, new double[] {0.03, 0.01}, new double[] {20, 20}, new int[] {1, 1}, new String[] {"D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\enceladusmap.jpg", "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\titanmap.jpg"});
		planets[6].setPlanet("Uranus", 0.004, 20, 280, 0, 7, 2, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\uranusmap.jpg");
			planets[6].setMoons(new String[] {"Ariel", "Umbriel"}, new double[] {0.06, 0.06}, new double[] {20, 20}, new int[] {1, 1}, new String[] {"D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\arielmap.jpg", "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\umbrielmap.jpg"});
		planets[7].setPlanet("Neptune", 0.003, 20, 320, 0, 7, 1, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\neptunemap.jpg");
			planets[7].setMoons("Triton", 0.04, 20, 2, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\tritonmap.jpg");
		planets[8].setPlanet("Pluto", 0.005, 20, 360, 0, 2, 1, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\plutomap.jpg");
			planets[8].setMoons("Charon", 0.05, 20, 1, "D:\\Uni Work\\Year 2\\Computer Graphics and Modelling\\CW2\\Textures\\charonmap.jpg");
			
		while(true) {
			
			for (int i = 0; i < planets.length; i++) {
				// Finds the current position of earth
				StdDraw3D.Vector3D currentPos = planets[i].getPosition();
				
				// EndPoint [0] = Destination of the x axis / [1] Destination of y axis
				// To change the speed at which the planets change, add 'planets[i].getSpeed' next to the 0.01
				// Determines where the planet will move across the circle and then moves it there
				double[] endPoint = 
					{ 		((currentPos.x * Math.cos(0.01+planets[i].getSpeed())) + (currentPos.y * Math.sin(0.01+planets[i].getSpeed()))),
							(-(currentPos.x * Math.sin(0.01+planets[i].getSpeed())) + (currentPos.y * Math.cos(0.01+planets[i].getSpeed()))) };
				
				// Sets the earths position to the endPoint
				planets[i].setPosition(endPoint[0], endPoint[1], 0);
				sun.setOrientation(0.01, 0.01, 0.01);
				planets[i].setOrientation(0.01+planets[i].getSpinSpeed(), 0.01+planets[i].getSpinSpeed(), 0.01+planets[i].getSpinSpeed());
				planets[i].setMoonPosition();
				
				//Sets the camera to the earths atmosphere
				StdDraw3D.setCameraMode(StdDraw3D.LOOK_MODE);
				StdDraw3D.setCameraPosition(planets[2].getPosition().x-6, planets[2].getPosition().y, planets[2].getPosition().z);
			}
			StdDraw3D.show(5);
		}
	}
}
