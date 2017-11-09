import java.util.function.DoubleUnaryOperator;

public class Graph {

	public static void main(String[] args) {
		initGraph(true);
		drawFunction('*', x -> Math.cos(x));
		drawFunction('#', x -> Math.sin(x));
//		drawFunction('2', x -> Math.pow(x, 2));
//		drawFunction('3', x -> Math.pow(x, 3));
//		drawFunction('4', x -> Math.pow(x, 4));
//		drawFunction('5', x -> Math.pow(x, 5));
//		drawFunction('x', x -> (5 * Math.pow(x, 3)) + (3 * Math.pow(x, 2) - (2 * x)));
		printGraph();
	}

	static final int COLUMNS = 80;
	static final int ROWS = 20;
	static final char[][] GRAPH = new char[COLUMNS][ROWS];
	static final double MIN_X = -4;
	static final double MAX_X = 5;
	static final double MIN_Y = -1.2;
	static final double MAX_Y = 1.2;
	static final double STEP_X = (MAX_X - MIN_X) / (double) (COLUMNS - 1);

	/**
	 * Initialise the graph to contain blank spaces and, optionally, the X and Y
	 * axes.
	 * 
	 * @param drawAxes
	 *            Indicates whether or not to draw the X and Y axes.
	 */
	static void initGraph(boolean drawAxes) {
		for (int j = 0; j < ROWS; j++) {
			for (int i = 0; i < COLUMNS; i++) {
				GRAPH[i][j] = ' ';
			}
		}
		if (drawAxes) {
			int zeroX = getXIndex(0.0);
			int zeroY = getYIndex(0.0);
			if (zeroX >= 0) {
				for (int i = 0; i < ROWS; i++)
					GRAPH[zeroX][i] = '|';
			}
			if (zeroY >= 0) {
				for (int i = 0; i < COLUMNS; i++)
					GRAPH[i][zeroY] = '-';
			}
			if (zeroX >= 0 && zeroY >= 0)
				GRAPH[zeroX][zeroY] = '+';
		}
	}

	/**
	 * Output the final graph to the console.
	 */
	static void printGraph() {
		for (int j = 0; j < ROWS; j++) {
			for (int i = 0; i < COLUMNS; i++) {
				System.out.print(GRAPH[i][j]);
			}
			System.out.println();
		}
	}

	static void drawFunction(char point, DoubleUnaryOperator func) {
		double xVal, yVal;
		int x, y;

		for (xVal = MIN_X; xVal <= MAX_X; xVal += STEP_X) {
			x = getXIndex(xVal);
			yVal = func.applyAsDouble(xVal);
			y = getYIndex(yVal);
			if (y >= 0) {
				GRAPH[x][y] = point;
			}
		}
	}

	/**
	 * Find the graph index of a given value along the X axis.
	 * 
	 * @param val
	 *            The X coordinate to convert to a graph index.
	 * @return The X index of the given value, or -1 if it's out of range.
	 */
	static int getXIndex(double val) {
		return getIndex(MIN_X, MAX_X, COLUMNS, val);
	}

	/**
	 * Find the graph index of a given value along the Y axis.
	 * 
	 * @param val
	 *            The Y coordinate to convert to a graph index.
	 * @return The Y index of the given value, or -1 if it's out of range.
	 */
	static int getYIndex(double val) {
		int index = getIndex(MIN_Y, MAX_Y, ROWS, val);
		if (index >= 0) {
			index = ROWS - index - 1;
		}
		return index;
	}

	/**
	 * Given a range of discrete bins, calculate the most appropriate one to
	 * place a given value in.
	 * 
	 * @param min
	 *            The minimum value of the range.
	 * @param max
	 *            The maximum value of the range.
	 * @param bins
	 *            The number of bins to divide the range into evenly.
	 * @param val
	 *            The value to place in a bin.
	 * @return The index of the most suitable bin to place val into, or -1 if
	 *         it's out of range.
	 */
	static int getIndex(double min, double max, int bins, double val) {
		if (val < min || val > max)
			return -1;

		double step = (max - min) / (double) (bins - 1);
		double newVal = ((val - min) / step);
		return (int) newVal;

	}
}
