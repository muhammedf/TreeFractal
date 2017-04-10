package sunofkyuss.treefractal.util;

public class Line2D {

	private Vector2D point1, point2;
	private Color color;

	public Line2D(Vector2D startPoint, double length, double angle, Color color) {
		point1 = startPoint;
		point2 = new Vector2D(point1.x + (float) length, point1.y);
		angle = (float) (Math.PI * angle / 180);
		point2 = new Vector2D(
				(point2.x - point1.x) * (float) Math.cos(angle) - (point2.y - point1.y) * (float) Math.sin(angle)
						+ point1.x,
				(point2.y - point1.y) * (float) Math.cos(angle) + (point2.x - point1.x) * (float) Math.sin(angle)
						+ point1.y);
		this.color = color;
	}

	public Vector2D getPoint1() {
		return point1;
	}

	public Vector2D getPoint2() {
		return point2;
	}

	public Color getColor() {
		return color;
	}

}
