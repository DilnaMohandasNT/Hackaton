package everytasc.nineleaps.com.hackaton.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import everytasc.nineleaps.com.hackaton.R;

public class AnswerDetailsActivity extends AppCompatActivity {
    WebView webview;
    String url;
    String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        url=getIntent().getStringExtra("url");
        title=getIntent().getStringExtra("title");
        title="title";
        //url="http://10.0.1.55/navi/pages/2-sports/2-sports.html";
        webview = (WebView) findViewById(R.id.webview1);
        webview.setWebViewClient(new MyWebViewClient());
        openURL(url);
    }

    private void openURL(String url) {
        //getDelegate().getSupportActionBar().setTitle(title);
        webview.loadUrl(url);
        webview.requestFocus();

    }


    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}