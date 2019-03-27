import java.util.Arrays;

public class Course {
	
	String courseName;
	private Hole[] h;
	
	public Course(String courseName) {
		if(courseName.equals("Genesee Valley Park North Course")) {
			Hole[] genesee = {new Hole(530, 5, "1"), new Hole(305, 4, "2"), new Hole(331, 4, "3"),
					new Hole(201, 3, "4"), new Hole(500, 5, "5"), new Hole(226, 3, "6"), new Hole(409, 4, "7"),
					new Hole(410, 4, "8"), new Hole(229, 3, "9"), new Hole(433, 4, "10"), new Hole(363, 4, "11"),
					new Hole(174, 3, "12"), new Hole(545, 5, "13"), new Hole(419, 4, "14"), new Hole(512, 5, "15"),
					new Hole(410, 4, "16"), new Hole(320, 4, "17"), new Hole(170, 3, "18")};
			this.h = genesee;
			this.courseName = courseName;
		}
		else if (courseName.equals("The Old Course at St. Andrews")){
			Hole[] stAndrewsHoles = {new Hole(376, 4, "1. Burn"), new Hole(453, 4, "2. Dyke"),
					new Hole(397, 4, "3. Cartgate (Out)"), new Hole(480, 4, "4. Ginger Beer"),
					new Hole(568, 5, "5. Hole O'Cross (Out)"), new Hole(412, 4, "6. Heathery (Out)"),
					new Hole(371, 4, "7. High (Out)"), new Hole(175, 3, "8. Short"),
					new Hole(352, 4, "9. End"), new Hole(386, 4, "10. Bobby Jones"),
					new Hole(174, 3, "11. High (In)"), new Hole(348, 4, "12. Heathery (In)"),
					new Hole(465, 4, "13. Hole O'Cross (In)"), new Hole(618, 5, "14. Long"),
					new Hole(455, 4, "15. Cartgate (In)"), new Hole(423, 4, "16. Corner of the Dyke"),
					new Hole(495, 4, "17. Road"), new Hole(357, 4, "18. Tom Morris")};
			this.h = stAndrewsHoles;	
			this.courseName = courseName;
		}
	}
	
	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * Gets the Hole at the specified index
	 * @param index
	 * @return
	 */
	public Hole getHole(int index) {
		return h[index];
	}
	
	public void setHole(int index, Hole h) {
		this.h[index] = h;
	}
	
	public int getHLength() {
		return h.length;
	}
	
	@Override
	public String toString() {
		return Arrays.toString(h);
	}
}
