package com.owen.webscroller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {
    //step 1 . set and define views
    NumberPicker mNumberPickerPosibilities;
    WebView mWebView;
    Button mBtnpreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //step 2. find the Ids
        mNumberPickerPosibilities = findViewById(R.id.number_picker);
        mWebView = findViewById(R.id.webview);
        mBtnpreview = findViewById(R.id.btnPreview);
        //Step 3 . create array of String possible selection items and cast them
        String[] posibilities = {
                "Andriod",
                "Andela",
                "Coursera",
                "Github Owen"
        };
        mNumberPickerPosibilities.setDisplayedValues(posibilities);
        mNumberPickerPosibilities.setMinValue(0);
        mNumberPickerPosibilities.setMaxValue(posibilities.length-1);
    }
    //step 4 create the Display possibilities function
    public void displayPosibilities(View view)
    {
        //Step 5 . get the view at hand. (interger). Add the html values on app->new
        int selectedChoice = mNumberPickerPosibilities.getValue();

        //check for the selected index and preview it on the app
        if (selectedChoice == 0)
        {
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("https://developer.android.com/");
        }
        else if (selectedChoice == 1)
        {
            mWebView.getSettings().setJavaScriptEnabled(true);
            mWebView.getSettings().setLoadWithOverviewMode(true);
            mWebView.getSettings().setUseWideViewPort(true);
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("https://andela.com/");
        }
        else if(selectedChoice==2)
        {
            mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("https://www.coursera.org/");
        }
        else if(selectedChoice ==  3)
        {   mWebView.setWebViewClient(new WebViewClient());
            mWebView.loadUrl("https://github.com/TimzOwen");
        }
        //step 6 . Allow internet permision on app->manifest
    }
}