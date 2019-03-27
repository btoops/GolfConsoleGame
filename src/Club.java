
import java.util.Random;

public class Club {

	private int meanDistance;
	private int stdDev;

	public Club(int meanDistance, int stdDev) {
		this.meanDistance = meanDistance;
		this.stdDev = stdDev;
	}
	
	public static int nextDistance(int mean, int stdDev, int power) {
		Random r = new Random();
		double mean_adj = mean * power / 10.0;
		double stddev_adj = stdDev * power / 10.0;
		double val = Math.abs(r.nextGaussian() * stddev_adj + mean_adj);
		return (int) val;
	}
	

	/**
	 * @return the meanDistance
	 */
	public int getMeanDistance() {
		return meanDistance;
	}

	/**
	 * @param meanDistance the meanDistance to set
	 */
	public void setMeanDistance(int meanDistance) {
		this.meanDistance = meanDistance;
	}

	/**
	 * @return the stdDev
	 */
	public int getStdDev() {
		return stdDev;
	}

	/**
	 * @param stdDev the stdDev to set
	 */
	public void setStdDev(int stdDev) {
		this.stdDev = stdDev;
	}
}
