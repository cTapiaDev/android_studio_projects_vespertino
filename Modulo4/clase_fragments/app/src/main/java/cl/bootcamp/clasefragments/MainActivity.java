package cl.bootcamp.clasefragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity {

    Toolbar appbar;
    FragmentTransaction transaction;
    Fragment primaryFragment, secondFragment, treeFragment, fourFragment;
    Button btnFrame1, btnFrame2, btnFrame3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFrame1 = (Button) findViewById(R.id.btnFrame1);
        btnFrame2 = (Button) findViewById(R.id.btnFrame2);
        btnFrame3 = (Button) findViewById(R.id.btnFrame3);

        primaryFragment = new PrimaryFragment();
        secondFragment = new SecondFragment();
        treeFragment = new treeFragment();
        fourFragment = new FourFragment();

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.flContainer, primaryFragment).commit();


        btnFrame1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, secondFragment).commit();
            }
        });

        btnFrame2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, treeFragment).commit();
            }
        });

        btnFrame3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.flContainer, fourFragment).commit();
            }
        });


        appbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(appbar);

    }
}