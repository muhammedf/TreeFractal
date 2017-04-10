package sunofkyuss.treefractal.fractaltree;

import java.util.Random;
import java.util.function.BiPredicate;
import java.util.function.Function;

import sunofkyuss.treefractal.drawer.Drawer;
import sunofkyuss.treefractal.util.Color;
import sunofkyuss.treefractal.util.Line2D;
import sunofkyuss.treefractal.util.Vector2D;

public class TreeFractal {

	private final Vector2D startpoint;
	private final double length, firstAngle, depthLength;
	private final Function<Double, Double> angleChangeFunctionLine1, angleChangeFunctionLine2,
			lengthChangeFunctionLine1, lengthChangeFunctionLine2;
	private final BiPredicate<Double, Long> endCondition;
	private final Random rand;
	private final long firstSeed;

	public TreeFractal(Vector2D startpoint, double length, double firstAngle, Function<Double, Double> angleChangeL1,
			Function<Double, Double> angleChangeL2, Function<Double, Double> lengthChangeL1,
			Function<Double, Double> lengthChangeL2, long firstSeed, BiPredicate<Double, Long> endC,
			double depthLength) {
		super();
		this.startpoint = startpoint;
		this.length = length;
		this.firstAngle = firstAngle;
		this.angleChangeFunctionLine1 = angleChangeL1;
		this.angleChangeFunctionLine2 = angleChangeL2;
		this.lengthChangeFunctionLine1 = lengthChangeL1;
		this.lengthChangeFunctionLine2 = lengthChangeL2;
		this.firstSeed = firstSeed;
		this.endCondition = endC;
		this.rand = new Random();
		this.depthLength = depthLength;
	}

	public void draw(Drawer drawer) {

		draw(drawer, startpoint, length, firstAngle, firstSeed, depthLength);
	}

	private void draw(Drawer drawer, Vector2D startPoint, double length, double angle, long seed,
			double remainingLength) {

		if (endCondition.test(length, seed - firstSeed /* depth */) || remainingLength <= 0) {
			return;
		}
		
		if (length > remainingLength) {
			length = remainingLength;
		}

		rand.setSeed(seed);
		Color color = new Color(rand.nextFloat(), rand.nextFloat(), rand.nextFloat(), 1);
		Line2D line = new Line2D(startPoint, length, angle, color);
		drawer.drawLine(line);

		remainingLength -= length;

		draw(drawer, line.getPoint2(), lengthChangeFunctionLine1.apply(length), angleChangeFunctionLine1.apply(angle),
				++seed, remainingLength);
		draw(drawer, line.getPoint2(), lengthChangeFunctionLine2.apply(length), angleChangeFunctionLine2.apply(angle),
				seed, remainingLength);
	}

}
