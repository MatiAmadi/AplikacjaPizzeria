package com.example.aplikacjapizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PodsumowanieZamowienia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_podsumowanie_zamowienia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button prz = findViewById(R.id.powrot);
        TextView wynik = findViewById(R.id.wynik);
        TextView rozmiar = findViewById(R.id.rozmiarpizzy);
        TextView ciasto = findViewById(R.id.ciastopizzy);
        TextView sztuk = findViewById(R.id.sztutuki);


        Intent intent = getIntent();
        int sztuki = intent.getIntExtra("sztuki", 1);
        boolean male = intent.getBooleanExtra("mala", false);
        boolean duze = intent.getBooleanExtra("duza", false);
        boolean srednie = intent.getBooleanExtra("srednia", false);
        boolean grube = intent.getBooleanExtra("grube", false);
        double cena = 0.0;
        double cake = 0.0;

        if (male)
        {
            rozmiar.setText("Rozmiar: Mała");
            cena = 25.0;

        }
        else if (srednie) {
            rozmiar.setText("Rozmiar: Średnia");
            cena = 35.0;

        } else if (duze) {
            rozmiar.setText("Rozmiar: Duża");
            cena = 45.0;

        }

        if(grube)
        {
            ciasto.setText("Ciasto: Grube");
            cake = 5.0;
        }   else {
            ciasto.setText("Ciasto Cienkie");
            cake = 0.0;

        }

        if(sztuki>0){
            sztuk.setText("Sztuk: " + sztuki);
        }

        double wyniczek = sztuki * cena + cake ;

        wynik.setText("Razem: " + wyniczek + " PLN");




        prz.setOnClickListener(v -> {
            Intent powr = new  Intent(PodsumowanieZamowienia.this , MainActivity.class);
            startActivity(powr);
        });


    }
}