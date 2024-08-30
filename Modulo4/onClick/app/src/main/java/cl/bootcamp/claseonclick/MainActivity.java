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

public class MainActivity extends AppCompatActivity {

    EditText texto;
    TextView mostrar;
    Button btnMostrar, btnNotify, btnValidarCb, btnValidarRb;
    CheckBox cbOpcion1, cbOpcion2;
    RadioButton rbOpcion1, rbOpcion2, rbOpcion3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (EditText) findViewById(R.id.etMostrar);
        mostrar = (TextView) findViewById(R.id.tvMostrar);
        btnMostrar = (Button) findViewById(R.id.btnMostrar);
        btnNotify = (Button) findViewById(R.id.btnNotify);
        btnValidarCb = (Button) findViewById(R.id.btnValidarCb);
        btnValidarRb = (Button) findViewById(R.id.btnValidarRb);
        cbOpcion1 = (CheckBox) findViewById(R.id.cb1);
        cbOpcion2 = (CheckBox) findViewById(R.id.cb2);
        rbOpcion1 = (RadioButton) findViewById(R.id.rb1);
        rbOpcion2 = (RadioButton) findViewById(R.id.rb2);
        rbOpcion3 = (RadioButton) findViewById(R.id.rb3);

        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrar.setText(texto.getText());
            }
        });
        mostrarNotificacion();
        validarCheckBox();
        validarRadioButtons();
    }

    public void mostrarNotificacion() {
        btnNotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), texto.getText(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void validarCheckBox() {
        btnValidarCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "Seleccionado: ";

                if (cbOpcion1.isChecked()) {
                    cadena += cbOpcion1.getText();
                }
                if (cbOpcion2.isChecked()) {
                    cadena += cbOpcion2.getText();
                }
                if (!cbOpcion1.isChecked() && !cbOpcion2.isChecked()) {
                    cadena += "-";
                }

                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_LONG).show();
            }
        });
    }

    public void validarRadioButtons() {
        btnValidarRb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cadena = "Seleccionado: ";

                if (rbOpcion1.isChecked()) {
                    cadena += rbOpcion1.getText();
                }
                if (rbOpcion2.isChecked()) {
                    cadena += rbOpcion2.getText();
                }
                if (rbOpcion3.isChecked()) {
                    cadena += rbOpcion3.getText();
                }

                Toast.makeText(MainActivity.this, cadena, Toast.LENGTH_LONG).show();

            }
        });
    }
}