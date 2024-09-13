package cl.bootcamp.claseintentwebview;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import cl.bootcamp.claseintentwebview.databinding.ActivityWebViewBinding;

public class WebViewActivity extends AppCompatActivity {

    ActivityWebViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        binding = ActivityWebViewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.wvContainer.getSettings().setJavaScriptEnabled(true);
        //binding.wvContainer.loadUrl("https://github.com/cTapiaDev/repo_bootcamp_android_vespertino");

        binding.wvContainer.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView web, WebResourceRequest request) {
                return false;
            }
        });

        binding.wvContainer.loadUrl("https://youtube.com");







        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}