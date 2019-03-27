import java.util.Random;

import org.omg.Messaging.SyncScopeHelper;


public class Player {
	
	private int totalScore;
	private Hole h;
	private int shotsOnHole;
	private String name;
	private int ballDistance;
	private Club[] clubs = {new Club(230, 30), new Club(215, 20), new Club(180, 20), new Club(170, 17), new Club(155, 15),
			new Club(145, 15), new Club(135, 15), new Club(125, 15), new Club(110, 10), new Club(50, 10)};
	
	/**
	 * index of Club:
	 * 0 is Driver
	 * 1 is 3-wood
	 * 2 is 3-iron
	 * 3 is 4-iron
	 * 4 is 5-iron
	 * 5 is 6-iron
	 * 6 is 7-iron
	 * 7 is 8-iron
	 * 8 is 9-iron
	 * 9 is Wedge
	 */

	
	public Player(Hole h, int ballDistance) {
		this.h = h;
		this.ballDistance = ballDistance;
		totalScore = 0;
		shotsOnHole = 0;
	}
	public Player() {
		totalScore = 0;
		shotsOnHole = 0;
		ballDistance = 0;
	}

	
	public Club getClub(int i) {
		return clubs[i];
	}
	
	
	/**
	 * @return the totalScore
	 */
	public int getTotalScore() {
		return totalScore;
	}

	/**
	 * @param totalScore the totalScore to set
	 */
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	/**
	 * @return the h
	 */
	public Hole getHole() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setHole(Hole h) {
		this.h = h;
	}

	/**
	 * @return the shotsOnHole
	 */
	public int getShotsOnHole() {
		return shotsOnHole;
	}
	
	/**
	 * 
	 */
	public void setShotsOnHole(int n) {
		shotsOnHole = 0;
	}
	
	/**
	 * Increase shotsonHole by 1 when the player takes a shot
	 */
	public void incrementShots() {
		shotsOnHole ++;
	}
//	/**
//	 * @param shotsOnHole the shotsOnHole to set
//	 */
//	public void setShotsOnHole(int shotsOnHole) {
//		this.shotsOnHole = shotsOnHole;
//	}

	/**
	 * @return the ballDistance
	 */
	public int getBallDistance() {
		return ballDistance;
	}

	/**
	 * @param ballDistance the ballDistance to set
	 */
	public void setBallDistance(int ballDistance) {
		this.ballDistance = ballDistance;
	}
	
	/**
	 * Decreases the distance to the hole when the ball gets closer after taking a shot
	 * @param ballDistance
	 */
	public void decreaseBallDistance(int ballDistance) {
		this.ballDistance -= ballDistance;
	}
	
	public String printShotNumber(int n) {
		switch(n) {
		case 1: 
			return ("Second shot. "); 
		case 2: 
			return("Third shot. ");
		case 3: 
			return("Fourth shot. ");
		case 4: 
			return("Fifth shot. ");
		case 5: 
			return("Sixth shot. ");
		case 6: 
			return("Seventh shot. ");
		case 7: 
			return("Eighth shot. ");
		case 8: 
			return("Ninth shot. ");
		case 9: 
			return("Tenth shot. ");
		}
		return "";
	}
	
	public int putt(int power) {
		Random r = new Random();

		int mean = 0;
		int stdDev = 0;
		switch(power) {
		case 1: 
			mean = 1; 
			stdDev = 1; 
			break;
		case 2: 
			mean = 2; 
			stdDev = 2; 
			break;
		case 3: 
			mean = 4; 
			stdDev = 2; 
			break;
		case 4: 
			mean = 8; 
			stdDev = 2; 
			break;
		case 5: 
			mean = 12; 
			stdDev = 3; 
			break;
		case 6: 
			mean = 16; 
			stdDev = 3; 
			break;
		case 7: 
			mean = 20; 
			stdDev = 4; 
			break;
		case 8: 
			mean = 25; 
			stdDev = 4; 
			break;
		case 9: 
			mean = 30; 
			stdDev = 5; 
			break;
		case 10: 
			mean = 40; 
			stdDev = 5; 
			break;
		}
		int	mean_adj = mean;
		int stddev_adj = stdDev;
		double val = Math.abs(r.nextGaussian() * stddev_adj + mean_adj);
		return (int) val;
	}
	
	
}
