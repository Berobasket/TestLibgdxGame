package pl.com.berobasket.testgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

/**
 * Created by bero on 2018-10-05.
 */

public class AdsMenuScreen implements Screen
{
    private TestGame _testGame;
    private Array<String> strings = new Array<String>();
    private long _lastGCTime;
    private long _createTime;
    private long _lastLogTime;
    private BitmapFont _font;
    private SpriteBatch _spriteBatch;

    public AdsMenuScreen( TestGame testGame )
    {
        _testGame = testGame;

        _createTime = System.currentTimeMillis();

        _font = new BitmapFont();

        _spriteBatch = new SpriteBatch();
    }

    @Override
    public void show()
    {
        _testGame.getAdsManager().initialize();
    }

    @Override
    public void render( float delta )
    {
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );

        long currentTime = System.currentTimeMillis();

        if( currentTime - _lastGCTime > 100 )
        {
            causeGC();
            _lastGCTime = currentTime;
        }

        int timeSinceCreate = (int)( ( System.currentTimeMillis() - _createTime ) / 1000 );
        if( currentTime - _lastLogTime > 1000 )
        {
            Gdx.app.log( TestGame.GAME_LOG, "Alive time: " + timeSinceCreate + " sec" );
            _lastLogTime = currentTime;
        }

        _spriteBatch.begin();
        _font.draw( _spriteBatch, timeSinceCreate + "s", 100, 100 );
        _spriteBatch.end();
    }

    private void causeGC()
    {
        strings.clear();

        for( int i = 0; i < 700000; i++ )
        {
            strings.add( String.valueOf( i ) );
        }
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

    }
}
