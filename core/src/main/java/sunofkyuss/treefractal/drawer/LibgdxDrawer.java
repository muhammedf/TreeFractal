package sunofkyuss.treefractal.drawer;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import sunofkyuss.treefractal.util.Line2D;

public class LibgdxDrawer implements Drawer {

	private ShapeRenderer sr;

	public LibgdxDrawer(ShapeRenderer sr) {
		this.sr = sr;
	}

	@Override
	public void drawLine(Line2D line) {
		sr.setColor(line.getColor().getR(), line.getColor().getG(), line.getColor().getB(), line.getColor().getA());
		sr.line(line.getPoint1().x, line.getPoint1().y, line.getPoint2().x, line.getPoint2().y);
	}

}
