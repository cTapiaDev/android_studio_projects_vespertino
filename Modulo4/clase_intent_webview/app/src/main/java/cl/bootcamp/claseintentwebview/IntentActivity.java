package cl.bootcamp.claseintentwebview;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import cl.bootcamp.claseintentwebview.databinding.ActivityIntentBinding;

public class IntentActivity extends AppCompatActivity {

    ActivityIntentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        binding = ActivityIntentBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String data = getIntent().getExtras().getString("campo");

        binding.tvDato.setText(data);





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