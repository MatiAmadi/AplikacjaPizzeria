package com.example.aplikacjapizzeria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button przyciskpodsumowanie = findViewById(R.id.podsumowanie);
        CheckBox grube = findViewById(R.id.grubeciasto);
        RadioButton mala = findViewById(R.id.mala);
        RadioButton srednia = findViewById(R.id.srednia);
        RadioButton duza = findViewById(R.id.duza);
        EditText sztuki = findViewById(R.id.sztuki);



        przyciskpodsumowanie.setOnClickListener(v -> {
            int sztuki_liczba = Integer.parseInt(sztuki.getText().toString());
            boolean mala_wybor = mala.isChecked();
            boolean srednia_wybor = srednia.isChecked();
            boolean duza_wybor = duza.isChecked();
            boolean grube_wybor = grube.isChecked();

            if (sztuki.getText().toString().isEmpty()){

                Toast.makeText(this, "Nie wolno nie masz sztuk", Toast.LENGTH_SHORT).show();
                return;
            }


            Intent intent = new Intent(MainActivity.this, PodsumowanieZamowienia.class);

            intent.putExtra("sztuki",sztuki_liczba);
            intent.putExtra("srednia",srednia_wybor);
            intent.putExtra("mala",mala_wybor);
            intent.putExtra("duza",duza_wybor);
            intent.putExtra("grube",grube_wybor);

            startActivity(intent);





        });

    }
}