package pl.com.berobasket.testgame;

import com.badlogic.gdx.Game;

public class TestGame extends Game
{
	public static final String GAME_LOG = "TestGameLog";

	private AdsManager _adsManager;

	public TestGame( AdsManager adsManager )
	{
		_adsManager = adsManager;
	}

	@Override
	public void create()
	{
		this.setScreen( new AdsMenuScreen( _adsManager ) );
	}

	@Override
	public void render()
	{
		super.render();
	}

	@Override
	public void dispose()
	{
	}
}