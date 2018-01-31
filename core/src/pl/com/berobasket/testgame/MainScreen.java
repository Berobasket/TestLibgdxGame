package pl.com.berobasket.testgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by bero on 20/01/2018.
 */

public class MainScreen implements Screen
{
    private SpriteBatch _spriteBatch;
    //private Texture _backgroundTexture;
    private Texture _circleTexture;

    private float _angle;

    private static float RADIUS = 220;
    private static int CENTER_X = 300;
    private static int CENTER_Y = 300;

    public MainScreen()
    {
        Gdx.app.log( "SP", "Constructor" );
        _spriteBatch = new SpriteBatch();

        _circleTexture = new Texture( "kolko.png" );
    }

    @Override
    public void show()
    {
        Gdx.app.log( "SP", "Show" );
    }

    @Override
    public void render( float delta )
    {
        _angle = _angle + 0.025f;

        int posX = (int)( Math.cos( _angle ) * RADIUS ) + CENTER_X;
        int posY = (int)( Math.sin( _angle ) * RADIUS ) + CENTER_Y;

        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        _spriteBatch.begin();

        _spriteBatch.draw( _circleTexture, posX, posY );

        _spriteBatch.end();
    }

    @Override
    public void resize( int width, int height )
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {
        _spriteBatch.dispose();
    }
}
