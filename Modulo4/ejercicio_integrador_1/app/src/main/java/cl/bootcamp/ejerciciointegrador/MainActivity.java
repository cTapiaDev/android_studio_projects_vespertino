package cl.bootcamp.ejerciciointegrador;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import cl.bootcamp.ejerciciointegrador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Glide
                .with(this)
                .load("https://i.pinimg.com/564x/45/7e/23/457e23ba64ca4d2d0c3d7d35dda1a356.jpg")
                .into(binding.ivUsuario);

        goWsp();
        goGit();
        goEmail();
    }

    public void goWsp() {
        binding.btnWsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://wa.me/56974141523");
                intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
    }

    public void goGit() {
        binding.btnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://github.com/cTapiaDev/repo_bootcamp_android_vespertino");
                intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
    }

    public void goEmail() {
        binding.btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                email.putExtra(Intent.EXTRA_TEXT, binding.etText.getText());
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"juanito@gmail.com"});
                startActivity(email);
            }
        });
    }
}