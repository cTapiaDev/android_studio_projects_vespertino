package cl.bootcamp.claserecyclerview;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ListElement> element;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    public void init() {
        element = new ArrayList<>();
        element.add(new ListElement(
                "#11212D",
                "Contenedor",
                "#11212D",
                "Actividad del contenedor",
                "Contenedor",
                "Activo")
        );

        ListAdapter listAdapter = new ListAdapter(element, this);
        RecyclerView recyclerView = findViewById(R.id.rvList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


    }
}