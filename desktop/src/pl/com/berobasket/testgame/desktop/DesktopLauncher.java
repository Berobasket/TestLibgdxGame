package pl.com.berobasket.testgame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import pl.com.berobasket.testgame.TestGame;

public class DesktopLauncher
{
	public static void main( String[] arg )
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication( new TestGame( new DummyAdsManager() ), config );
	}
}
