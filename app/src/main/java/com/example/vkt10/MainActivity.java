package com.example.vkt10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    Button seach;
    Button back;
    Button forward;
    Button refresh;
    Button js_bt1;
    Button js_bt2;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        web = findViewById(R.id.browser);
        editText = findViewById(R.id.url);

        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);   //enable javascript

        web.loadUrl("http://www.google.fi");    //adding Google as the default page

        //allow to go back and forward in browser
        web.canGoBack();
        web.canGoForward();

    }

    //seach from browser
    public void searchStuff(View v) {

        //load an url every time user clicks search
        String url = editText.getText().toString();
        if (url.contains("https://")) {  //if search contains http(s):// we load url, else we add it so user doesn't have to use http(s)://
            web.loadUrl(url);
        } else if (url.contains("http://")) {
            web.loadUrl(url);
        } else if(url.contains("index.html")){
            web.loadUrl("file:///android_asset/index.html");
        } else {
            web.loadUrl("http://" + url);
        }
    }

    //back button
    public void backButton(View v){
        web.goBack();
    }

    //forward button
    public void forwardButton(View v){
        web.goForward();
    }

    public void refreshButton(View v){
        web.reload();
    }

    public void weirdJsButton1(View v){
        web.evaluateJavascript("javascript:shoutOut()", null);
    }

    public void weirdJsButton2(View v){
        web.evaluateJavascript("javascript:initialize()", null);
    }

}