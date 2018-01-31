package pl.com.berobasket.testgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.TimeUtils;

/**
 * Created by bero on 20/01/2018.
 */

public class MainScreen implements Screen
{
    private static final int VIEWPORT_WIDTH = 200;
    private static float RADIUS = 220;
    private static int CENTER_X = 200;
    private static int CENTER_Y = 200;

    private SpriteBatch _spriteBatch;
    private Texture _backgroundTexture;
    private Texture _circleTexture;

    private BitmapFont _bitmapFont;

    private long _lastNanoTimeCounted;
    private float _changeTimeSeconds;
    private float _angle;
    private int _fps;

    private OrthographicCamera _camera;
    private OrthographicCamera _UICamera;

    public MainScreen()
    {
        Gdx.app.log( "SP", "Constructor" );
        _spriteBatch = new SpriteBatch();

        _backgroundTexture = new Texture( "szachownica.png" );
        _circleTexture = new Texture( "kolko.png" );

        _bitmapFont = new BitmapFont();

        _camera = new OrthographicCamera();
        _UICamera = new OrthographicCamera();
    }

    @Override
    public void show()
    {
        Gdx.app.log( "SP", "Show" );
    }

    @Override
    public void render( float delta )
    {
        countFPS();

        _angle = _angle + 0.025f;

        int posX = (int)( Math.cos( _angle ) * RADIUS ) + CENTER_X;
        int posY = (int)( Math.sin( _angle ) * RADIUS ) + CENTER_Y;

        updateCamera( posX, posY );

        Gdx.gl.glClearColor( 0, 0, 0, 1 );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        _spriteBatch.setProjectionMatrix( _camera.combined );

        _spriteBatch.begin();

        _spriteBatch.draw( _backgroundTexture, 0, 0, 500, 500 );

        _spriteBatch.draw( _circleTexture, posX, posY, 10, 10 );

        _spriteBatch.end();

        _spriteBatch.setProjectionMatrix( _UICamera.combined );

        _spriteBatch.begin();

        _bitmapFont.draw( _spriteBatch, "FPS: " + _fps, 0, 15 );

        _spriteBatch.end();
    }

    private void countFPS()
    {
        long deltaNano = TimeUtils.timeSinceNanos( _lastNanoTimeCounted );
        _lastNanoTimeCounted = TimeUtils.nanoTime();

        _changeTimeSeconds += deltaNano;
        if( _changeTimeSeconds >= 1000000000 )
        {
            _changeTimeSeconds = 0;
            _fps = Gdx.graphics.getFramesPerSecond();
        }
    }


    @Override
    public void resize( int width, int height )
    {
        _camera.viewportWidth = VIEWPORT_WIDTH;
        _camera.viewportHeight = VIEWPORT_WIDTH * (float)height / (float)width;

        _UICamera.setToOrtho( false, _camera.viewportWidth, _camera.viewportHeight );
    }

    private void updateCamera( int posX, int posY )
    {
        _camera.position.set( posX, posY, 0 );
        _camera.update();
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
