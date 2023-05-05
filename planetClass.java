
public class planetClass {
	// Create private variables for the orbit, angle and size of the planet
	// Add a variable for how many moons the planet has and have it create them using the moonClass
	private String name;
	private double orbitSpeed;
	private double spinSpeed;
	private int radius;
	private StdDraw3D.Shape planet;
	private StdDraw3D.Vector3D position;
	private StdDraw3D.Vector3D orientation;
	private moonClass[] moons;
	
	// Setter Functions
	
	// Creates the planets and determines the amount of moons
	// Parameters (Name, Orbit Speed, Spin Speed, Distance X, Distance Y, Radius, Amount of Moons, Texture)
	public void setPlanet(String name, double os, double ss, double dx, double dy, int r, int moon, String texture) {
		this.name = name;
		this.orbitSpeed = os;
		this.spinSpeed = ss;
		this.radius = r;
		
		// Declares the amount of moonClass's of the planet
		moonClass[] moons = new moonClass[moon];
		for (int i = 0; i < moons.length; i++) moons[i] = new moonClass();
		this.moons = moons;
		
		planet = StdDraw3D.sphere(dx, dy, 0, r, texture);
		position = planet.getPosition();
	}
	public void setPosition(double x, double y, double z) {
		this.planet.setPosition(x, y, z);
		this.position = planet.getPosition();
	}
	public void setOrientation(double x, double y, double z) {
		this.planet.setOrientation(x, y, z);
		this.orientation = planet.getOrientation();
	}
	
	// Makes the moons rotate around the planet
	public void setMoonPosition() {
		for (int i = 0; i < moons.length; i++) {
			// Determines the distance the moons travel around the planet and moves the moon there 
			double xi = this.position.x + (this.radius+10) * Math.cos(moons[i].getCount());
			double yi = this.position.y + (this.radius+10) * Math.sin(moons[i].getCount());
			moons[i].setPosition(xi, yi, 0);
			moons[i].updateCount();;
			// Resets the count after a full rotation to stop ever growing integers
			if (moons[i].getCount() >= 3.6 || moons[i].getCount() <= -3.6) moons[i].setCount(0);
		}
	}
/*		double xi, yi;
		double A = (2 * Math.PI)/(moons.length);
		for(int i = 0; i < (moons.length - count); i++) {
				xi = Math.round(this.position.x + (this.position.x+20) * Math.cos((i-count) * A));
				yi = Math.round(this.position.y + (this.position.y+20) * Math.sin((i-count) * A));
				
				moons[i].setPosition(xi, yi, 0);
		}
		// Increases the count which is used for the positioning of the letters
		count++;
		// If count reaches a full rotation of the circle, reset count to avoid infinite growing variables
		if (count == moons.length) count = 0;
	}
	/*public void setPosition(StdDraw3D.Vector3D pos) {
		this.planet.setPosition(pos);
		this.position = planet.getPosition();
		for(int i = 0; i < moons.length; i++) moons[i].setPosition(pos, this.radius);
	}*/
	// Creates the moons
	public void setMoons(String[] name, double[] os, double[] oa, int[] r, String[] texture) {
		for (int i = 0; i < this.moons.length; i++) {
			// For each moon, calls the set moon function
			this.moons[i].setMoon(name[i], os[i], oa[i], this.position.x, this.position.y, r[i], texture[i]);
		}
	}
	public void setMoons(String name, double os, double oa, int r, String texture) {
		// Calls the set moon function for a single moon
		this.moons[0].setMoon(name, os, oa, this.position.x, this.position.y, r, texture);
	}
	// End of Setter Functions
	
	// Getter Functions
	public String getName() {
		return this.name;
	}
	public double getSpeed() {
		return this.orbitSpeed;
	}
	public double getSpinSpeed() {
		return this.spinSpeed;
	}
	public double getDistanceX() {
		return this.position.x;
	}
	public double getDistanceY() {
		return this.position.y;
	}
	public double getDistanceZ() {
		return this.position.z;
	}
	public StdDraw3D.Vector3D getPosition() {
		return this.position;
	}
	public StdDraw3D.Vector3D getOrientation() {
		return this.orientation;
	}
	public int getRadius() {
		return this.radius;
	}
	public int getMoonsNum() {
		return this.moons.length;
	}
	public String[] getMoonsName() {
		String[] names = new String[this.moons.length];
		for (int i = 0; i < this.moons.length; i++) {
			names[i] = this.moons[i].getName();
		}
		return names;
	}
	// End of Getter Functions
}
