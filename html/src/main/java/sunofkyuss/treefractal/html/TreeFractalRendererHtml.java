package sunofkyuss.treefractal.html;

import sunofkyuss.treefractal.core.TreeFractalRenderer;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class TreeFractalRendererHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new TreeFractalRenderer();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
