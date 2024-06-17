package com.example.a123456;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Titulo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String[] datos = new String[]{"Primero",
                "Segundo", "Tercero", "Cuarto",
                "Quinto", "Sexto", "Septimo", "Octavo",
                "Noveno", "Decimo"};
        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, datos);

        AutoCompleteTextView textView =
                findViewById(R.id.listalumno);
        textView.setAdapter(adapter);


        /*String[] datoslista = new String[]{"Stalin",
                "Dayra", "Yumeida", "Kerly",
                "Cristhian"
        };

        ArrayAdapter<String> adaptador2 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1,
                        datoslista);
                        */

         Alumno[] Alumnos =
                new Alumno[]{
                        new Alumno("STALIN  1", "jestradat2@gmail.com"),
                        new Alumno("Dayra   2", "Dayra@gmail.com"),
                        new Alumno("Yumeida 3", "yumeida@gmail.com"),
                        new Alumno("Kerly 4", "kerly@gmail.com"),
                        new Alumno("Cristhian 5", "ortega@gmail.com")};
    AdaptadorAlumno adaptadorAlumno =
            new AdaptadorAlumno(this, Alumnos);

    ListView lstlistaAlumno = findViewById(R.id.actlistacurso);
        lstlistaAlumno.setAdapter(adaptadorAlumno);
        lstlistaAlumno.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Alumno Seleccionado" +
                                ((Alumno)adapterView.getItemAtPosition(position)).getNombre()
                ,Toast.LENGTH_LONG).show();
            }
        });




    }
}
