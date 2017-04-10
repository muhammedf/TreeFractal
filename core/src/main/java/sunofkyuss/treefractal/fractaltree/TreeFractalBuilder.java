package sunofkyuss.treefractal.fractaltree;

import java.util.function.BiPredicate;
import java.util.function.Function;

import sunofkyuss.treefractal.util.Vector2D;

public class TreeFractalBuilder {

	private Vector2D startPoint = new Vector2D(0, 0);
	private double length = 100, firstAngle = 90;
	private Function<Double, Double> angleChangeFunctionLine1 = a -> a + 10, angleChangeFunctionLine2 = a -> a - 10,
			lengthChangeFunctionLine1 = a -> a * 7 / 10, lengthChangeFunctionLine2 = a -> a * 7 / 10;
	private BiPredicate<Double, Long> endCondition = (length, depth) -> length < 1 || depth > 15;
	private double depthLength = Double.MAX_VALUE;
	private long firstSeed = 0;

	public TreeFractalBuilder setStartPoint(Vector2D startPoint) {
		this.startPoint = startPoint;
		return this;
	}

	public TreeFractalBuilder setFirstLength(double length) {
		this.length = length;
		return this;
	}

	public TreeFractalBuilder setFirstAngle(double angle) {
		this.firstAngle = angle;
		return this;
	}

	public TreeFractalBuilder setAngleChangeFunctionLine1(Function<Double, Double> func) {
		this.angleChangeFunctionLine1 = func;
		return this;
	}

	public TreeFractalBuilder setAngleChangeFunctionLine2(Function<Double, Double> func) {
		this.angleChangeFunctionLine2 = func;
		return this;
	}

	public TreeFractalBuilder setLengthChangeFunctionLine1(Function<Double, Double> func) {
		this.lengthChangeFunctionLine1 = func;
		return this;
	}

	public TreeFractalBuilder setLengthChangeFunctionLine2(Function<Double, Double> func) {
		this.lengthChangeFunctionLine2 = func;
		return this;
	}

	/**
	 * seed for random colors
	 * 
	 * @param fs
	 * @return
	 */
	public TreeFractalBuilder setFirstSeed(long fs) {
		this.firstSeed = fs;
		return this;
	}

	/**
	 * first parameter for length of branch second parameter for depth of branch
	 * 
	 * @param endC
	 * @return
	 */
	public TreeFractalBuilder setEndCondition(BiPredicate<Double, Long> endC) {
		this.endCondition = endC;
		return this;
	}

	public TreeFractalBuilder setDepthLength(double depthLength) {
		this.depthLength = depthLength;
		return this;
	}

	public TreeFractal build() {
		return new TreeFractal(startPoint, length, firstAngle, angleChangeFunctionLine1, angleChangeFunctionLine2,
				lengthChangeFunctionLine1, lengthChangeFunctionLine2, firstSeed, endCondition, depthLength);
	}

	public static TreeFractalBuilder getNewInstance() {
		return new TreeFractalBuilder();
	}

}
