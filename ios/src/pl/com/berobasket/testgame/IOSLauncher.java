package pl.com.berobasket.testgame;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIAlertAction;
import org.robovm.apple.uikit.UIAlertActionStyle;
import org.robovm.apple.uikit.UIAlertController;
import org.robovm.apple.uikit.UIAlertControllerStyle;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationLaunchOptions;

public class IOSLauncher extends IOSApplication.Delegate
{
    private IOSAdsManager _iosAdsManager;

    @Override
    protected IOSApplication createApplication()
    {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        config.orientationPortrait = true;
        _iosAdsManager = new IOSAdsManager();
        TestGame testGame = new TestGame( _iosAdsManager );
        IOSApplication iosApplication = new IOSApplication( testGame, config );
        _iosAdsManager.setIosApplication( iosApplication );
        return iosApplication;
    }

    public static void main( String[] argv )
    {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main( argv, null, IOSLauncher.class );
        pool.close();
    }
}
