public class Triangle {
	// 3 borders
	protected long lborderA = 0;

	protected long lborderB = 0;

	protected long lborderC = 0;

	// Constructor
	public Triangle(long lborderA, long lborderB, long lborderC) {

		this.lborderA = lborderA;

		this.lborderB = lborderB;

		this.lborderC = lborderC;

	}

	/**
	 * Check if it is a triangle
	 * 
	 * return true if it is, otherwise return false
	 */
	public boolean isTriangle(Triangle triangle) {
		boolean isTriangle = false;

		// check the border
		if ((triangle.lborderA > 0 && triangle.lborderA <= Long.MAX_VALUE)
				&& (triangle.lborderB > 0 && triangle.lborderB <= Long.MAX_VALUE)
				&& (triangle.lborderC > 0 && triangle.lborderC <= Long.MAX_VALUE)) {

			// check if diff between 2 borders is less than the 3rd
			if (diffOfBorders(triangle.lborderA, triangle.lborderB) < triangle.lborderC
					&& diffOfBorders(triangle.lborderB, triangle.lborderC) < triangle.lborderA
					&& diffOfBorders(triangle.lborderC, triangle.lborderA) < triangle.lborderB) {
				isTriangle = true;
			}

		}
		return isTriangle;
	}

	/**
	 * Return the type of triangle
	 * 
	 * 
	 */
	public String getType(Triangle triangle) {
		String strType = "Illegal";

		// Is it a triangle
		if (isTriangle(triangle)) {
			// Is it regular
			if (triangle.lborderA == triangle.lborderB
					&& triangle.lborderB == triangle.lborderC) {
				strType = "Regular";
			}
			// Is it scalene
			else if ((triangle.lborderA != triangle.lborderB)
					&& (triangle.lborderB != triangle.lborderC)
					&& (triangle.lborderA != triangle.lborderC)) {
				strType = "Scalene";
			}
			// Is it scalene
			else {
				strType = "Isoceles";
			}
		}

		return strType;
	}

	/**
	 * Get abs diff between two borders
	 * 
	 * */
	public long diffOfBorders(long a, long b) {
		return (a > b) ? (a - b) : (b - a);
	}

	/**
	 * get borders of a triangle
	 */
	public long[] getBorders() {
		long[] borders = new long[3];
		borders[0] = this.lborderA;
		borders[1] = this.lborderB;
		borders[2] = this.lborderC;
		return borders;
	}
}