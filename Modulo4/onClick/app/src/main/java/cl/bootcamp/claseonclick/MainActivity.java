package cl.bootcamp.claseonclick;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import cl.bootcamp.claseonclick.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

//    EditText texto;
//    TextView mostrar;
//    Button btnMostrar, btnNotify, btnValidarCb, btnValidarRb;
//    CheckBox cbOpcion1, cbOpcion2;
//    RadioButton rbOpcion1, rbOpcion2, rbOpcion3;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* texto = (EditText) findViewById(R.id.etMostrar);
        mostrar = (TextView) findViewById(R.id.tvMostrar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnNotify = (Button) findViewById(R.id.btnNotify);
        btnValidarCb = (Button) findViewById(R.id.btnValidarCb);
        btnValidarRb = (Button) findViewById(R.id.btnValidarRb);
        cbOpcion1 = (CheckBox) findViewById(R.id.cb1);
        cbOpcion2 = (CheckBox) findViewById(R.id.cb2);
        rbOpcion1 = (RadioButton) findViewById(R.id.rb1);
        rbOpcion2 = (RadioButton) findViewById(R.id.rb2);
        rbOpcion3 = (RadioButton) findViewById(R.id.rb3); */

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvMostrar.setText(binding.etMostrar.getText());
            }
        });
        mostrarNotificacion();
        validarCheckBox();
        validarRadioButtons();
    }

    public void mostrarNotificacion() {
        binding.btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), binding.etMostrar.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void validarCheckBox() {
        binding.btnValidarCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "Seleccionado: ";

                if (binding.cb1.isChecked()) {
                    cadena += binding.cb1.getText();
                }
                if (binding.cb2.isChecked()) {
                    cadena += binding.cb2.getText();
                }
                if (!binding.cb1.isChecked() && !binding.cb2.isChecked()) {
                    cadena += "-";
                }

                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void validarRadioButtons() {
        binding.btnValidarRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "Seleccionado: ";

                if (binding.rb1.isChecked()) {
                    cadena += binding.rb1.getText();
                }
                if (binding.rb2.isChecked()) {
                    cadena += binding.rb2.getText();
                }
                if (binding.rb3.isChecked()) {
                    cadena += binding.rb3.getText();
                }

                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_LONG).show();

            }
        });
    }
}