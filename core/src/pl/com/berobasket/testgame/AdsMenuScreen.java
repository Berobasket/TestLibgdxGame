package pl.com.berobasket.testgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by bero on 2018-10-05.
 */

public class AdsMenuScreen implements Screen
{
    private AdsManager _adsManager;
    private Stage _stage;
    private Skin _skin;

    public AdsMenuScreen( AdsManager adsManager )
    {
        _adsManager = adsManager;

        _stage = new Stage( new ScreenViewport() );
        Gdx.input.setInputProcessor( _stage );

        _skin = new Skin( Gdx.files.internal( "uiskin.json" ) );

        Table table = new Table( _skin );
        table.setFillParent( true );
        _stage.addActor( table );

        TextButton interstitialTextButton = new TextButton( "Show interstitial", _skin );
        interstitialTextButton.addListener( new ClickListener()
        {
            @Override
            public void touchUp( InputEvent event, float x, float y, int pointer, int button )
            {
                super.touchUp( event, x, y, pointer, button );
                _adsManager.showInterstitial();
            }
        } );

        table.row();
        table.add( interstitialTextButton );
    }

    @Override
    public void show()
    {
        _adsManager.showBanner();
    }

    @Override
    public void render( float delta )
    {
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );
        _stage.act( delta );
        _stage.draw();
    }

    @Override
    public void resize( int width, int height )
    {
        _stage.getViewport().update( width, height, true );
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
        _stage.dispose();
    }
}
