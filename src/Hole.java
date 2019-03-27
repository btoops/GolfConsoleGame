
public class Hole {

	private int distance;
	private int par;
	private String name;
	
	public Hole(int distance, int par, String name) {
		this.distance = distance;
		this.par = par;
		this.name = name;
	}
	
	
	
	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	/**
	 * @return the par
	 */
	public int getPar() {
		return par;
	}

	/**
	 * @param par the par to set
	 */
	public void setPar(int par) {
		this.par = par;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public void subtractDistance(int sub) {
		distance -= sub;
	}
	
	@Override
	public String toString() {
		return "hole " + name + ". " + distance + " yards, par " + par + ".";
	}
}
