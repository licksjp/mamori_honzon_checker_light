package mamori.honzon.checker.light;

//import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/*
import jp.co.fullspeed.polymorphicads.PolymorphicAds;
import jp.co.fullspeed.polymorphicads.PolymorphicAdsCallback;
*/
public class Manual extends Activity /*implements  PolymorphicAdsCallback.Callbackable,
        PolymorphicAdsCallback.InitializeCallback,
        PolymorphicAdsCallback.RequestCallback,
        PolymorphicAdsCallback.DisplayCallback,
        PolymorphicAdsCallback.ClickCallback*/

{

    // private static final String AD_UNIT_ID ="9dc96440523d02fdd33a8bfee9e4ef1c";
    // private static final String AD_UNIT_ID = "3c4aca888f9ba1e601826cf7f2b9bf9a";

    /**
     * Called when the activity is first created.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help_manual);

        //      setTitle(R.string.Help_Manual_Title);
        // one.wav をロードしておく

        //AdstirView adstirView = new AdstirView(Iwaigoto_checker_light.this, "MEDIA-52f15a5", 1);


        final WebView webView = (WebView) findViewById(R.id.webview);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        //webView.setInitialScale(100);
        webView.loadUrl("file:///android_asset/index.html");
        //PolymorphicAds.setLoggingMode(true);
 /*
        PolymorphicAds.setTestMode(false);
        // ① 広告ユニット初期化
        PolymorphicAds.init(this, AD_UNIT_ID, PolymorphicAds.AdType.BANNER, R.id.ad_container);

        // ② 広告ロード（Ad情報取得、表示）
        PolymorphicAds.load(AD_UNIT_ID);
*/

    }

    @Override
    protected void onPause() {
        super.onPause();
        // 広告ローテーション中断
        //       PolymorphicAds.pause(AD_UNIT_ID);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 広告ローテーション再開
        //       PolymorphicAds.resume(AD_UNIT_ID);

        // （任意） コールバックセット
/*
        PolymorphicAds.setCallback(
                AD_UNIT_ID,
                this,
                PolymorphicAdsCallback.CallbackType.INITIALIZE,
                PolymorphicAdsCallback.CallbackType.REQUEST,
                PolymorphicAdsCallback.CallbackType.DISPLAY,
                PolymorphicAdsCallback.CallbackType.CLICK);
    }
    @Override
    public void onSuccessClickAd(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onFailureClickAd(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onSuccessShowAd(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onFailureShowAd(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onSkipShowAd(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onCloseAd(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onFailureUseOverlay(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onSuccessInitRequest(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onFailureInitRequest(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onFailureSendAdRequest(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onSuccessResponseAdRequest(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onFailureResponseAdRequest(String s, PolymorphicAds.AdType adType) {

    }

    @Override
    public void onReceiveNoAds(String s, PolymorphicAds.AdType adType) {

    }
    */
    }
}