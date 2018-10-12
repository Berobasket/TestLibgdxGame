package pl.com.berobasket.testgame;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;

import org.robovm.apple.uikit.UIViewController;
import org.robovm.pods.google.mobileads.GADAdSize;
import org.robovm.pods.google.mobileads.GADBannerView;
import org.robovm.pods.google.mobileads.GADRequest;

import java.util.Arrays;

/**
 * Created by bero on 2018-10-05.
 */

public class IOSAdsManager implements AdsManager
{
    private static final String BANNER_AD_UNIT_ID = "ca-app-pub-3940256099942544/2934735716";

    private GADBannerView _bannerAdView;

    private IOSApplication _iosApplication;

    public void setIosApplication( IOSApplication iosApplication )
    {
        _iosApplication = iosApplication;
    }

    public void initialize()
    {
        createBannerAd();

        loadBannerAd();
    }

    private void createBannerAd()
    {
        _bannerAdView = new GADBannerView( GADAdSize.SmartBannerPortrait() );

        _bannerAdView.setAdUnitID( BANNER_AD_UNIT_ID );

        UIViewController uiViewController = _iosApplication.getUIViewController();

        uiViewController.getView().addSubview( _bannerAdView );

        _bannerAdView.setRootViewController( uiViewController );
    }

    private void loadBannerAd()
    {
        _bannerAdView.loadRequest( createGADRequest() );
    }

    private GADRequest createGADRequest()
    {
        GADRequest gadRequest = new GADRequest();

        gadRequest.setTestDevices( Arrays.asList( "edcb9f1cea2fe48ae256db65851c6f35" ) );

        return gadRequest;
    }
}
