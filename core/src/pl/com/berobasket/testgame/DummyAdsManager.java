package pl.com.berobasket.testgame;

import com.badlogic.gdx.Gdx;

/**
 * Created by bero on 2018-10-05.
 */

public class DummyAdsManager implements AdsManager
{
    @Override
    public void showBanner()
    {
        Gdx.app.log( TestGame.GAME_LOG, "Show banner" );
    }

    @Override
    public void showInterstitial()
    {
        Gdx.app.log( TestGame.GAME_LOG, "Show interstitial" );
    }
}
