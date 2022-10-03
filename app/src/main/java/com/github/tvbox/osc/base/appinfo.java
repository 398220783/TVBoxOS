package com.github.tvbox.osc.base;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.tvbox.osc.base.BaseActivity;
import com.github.tvbox.osc.ui.activity.HomeActivity;
import com.kongzue.baseokhttp.HttpRequest;
import com.kongzue.baseokhttp.listener.ResponseListener;

public class appinfo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HttpRequest.build(appinfo.this,"https://a.dawwiqingyi.repl.co/app/url.html")
                .addHeaders("Charset", "UTF-8")
                .setResponseListener(new ResponseListener() {
                    @Override
                    public void onResponse(String response, Exception error) {
                       HomeActivity.api = response;
                       startActivity(new Intent(appinfo.this,HomeActivity.class));
finish();
                    }
                })
                .doGet();
    }
}
