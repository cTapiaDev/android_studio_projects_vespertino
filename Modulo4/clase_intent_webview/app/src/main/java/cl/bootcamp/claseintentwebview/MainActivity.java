package cl.bootcamp.claseintentwebview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import cl.bootcamp.claseintentwebview.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    ActivityMainBinding binding;

    String texto = "Texto de un intent a otro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), WebViewActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        binding.btnIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), IntentActivity.class);
                intent.putExtra("campo", texto);
                view.getContext().startActivity(intent);
            }
        });

    }
}