
public class moonClass {
	// Create private variables for the orbit, angle and size of the moon
	private String name;
	private double orbitSpeed;
	private double spinSpeed;
	private StdDraw3D.Shape moon;
	private StdDraw3D.Vector3D position;
	private int radius;
	private double count = 0;
	
	// Setter Function (This should only be called from the planetClass and not from the main!)
	
	// Creates the moon
	// Parameters (Name, Orbit Speed, Spin Speed, Distance X, Distance Y, Radius, Texture)
	public void setMoon(String name, double os, double ss, double x, double y, int r, String texture) {
		this.name = name;
		this.orbitSpeed = os;
		this.spinSpeed = ss;
		this.radius = r;
		
		 moon = StdDraw3D.sphere(x+17, y, 0, r, texture);
		 position = moon.getPosition();
	}
	public void setPosition(double x, double y, double z) {
		this.moon.setPosition(x, y, z);
	}
	public void setCount(double c) {
		this.count = c;
	}
	public void updateCount() {
		// Increases the distance the moon moves using the orbit speed
		this.count = this.count+this.orbitSpeed;
	}
	// Try to make the moons orbit on their own orbit and not just stay on one side of the planet
	/*
	public void setPosition(double x, double y, double z, int r) {
		double A = (2 * Math.PI)/1;
		double xi = Math.round(x + (x+r) * Math.cos((0-count) * A));
		double yi = Math.round(y + (y+r) * Math.sin((0-count) * A));
		
		// Sets the earths position to the endPoint
		this.moon.setPosition(xi, yi, 0);
	}
	public void setPosition(StdDraw3D.Vector3D pos, int r) {
		double A = (2 * Math.PI)/5;
		double xi = Math.round(pos.x + (pos.x+r) * Math.cos((0+count) * A));
		double yi = Math.round(pos.y + (pos.y+r) * Math.sin((0+count) * A));
		
		// Sets the earths position to the endPoint
		this.moon.setPosition(xi, yi, 0);
	}
	*/
	// End of Setter Function
	
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
	public int getRadius() {
		return this.radius;
	}
	public double getCount() {
		return this.count;
	}
	// End of Getter Functions
}
