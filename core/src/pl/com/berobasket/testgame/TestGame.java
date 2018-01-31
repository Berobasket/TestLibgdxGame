package pl.com.berobasket.testgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TestGame extends Game
{
	@Override
	public void create()
	{
		this.setScreen( new MainScreen() );
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