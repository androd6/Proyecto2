package com.ar6.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {

    // Definicion de las variables que se emparejaran con los objetos de la vista
    private TextInputEditText varV2tiName;
    private TextInputEditText varV2tiDate;
    private TextInputEditText varV2tiPhone;
    private TextInputEditText varV2tiEmail;
    private TextInputEditText varV2tiDesc;

    // Definicion de las constantes que se usaran para definir la clave que identificara
    // los parametros que se enviaran a la actividad Mainactivity1
    // Como buena practica la clave se define con el nombre del paquete + el nombre del
    // parametro, para garantizar que las claves sean unicas en caso de que la app
    // interactue con otras apps
    public static final String prmV1Name = "com.ar6.proyecto2.PrmV1Name";
    public static final String prmV1Date = "com.ar6.proyecto2.PrmV1Date";
    public static final String prmV1Phone = "com.ar6.proyecto2.PrmV1Phone";
    public static final String prmV1Email = "com.ar6.proyecto2.PrmV1Email";
    public static final String prmV1Desc = "com.ar6.proyecto2.PrmV1Desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Emparejamiento de las variables con los objetos de la vista
        varV2tiName = findViewById(R.id.v2_tiname);
        varV2tiDate = findViewById(R.id.v2_tidate);
        varV2tiPhone = findViewById(R.id.v2_phone);
        varV2tiEmail = findViewById(R.id.v2_tiemail);
        varV2tiDesc = findViewById(R.id.v2_tidesc);

        // Definicion de la variable Intent que recibe los parametros
        Intent varPrmIntent = getIntent();

        // Verifica que llegaron parametros, si llega al menos 1 se signan a sus
        // respectivos objetos
        if (varPrmIntent.getExtras() != null){
            varV2tiName.setText(varPrmIntent.getStringExtra(MainActivity.prmV2Name));
            varV2tiDate.setText(varPrmIntent.getStringExtra(MainActivity.prmV2Date));
            varV2tiPhone.setText(varPrmIntent.getStringExtra(MainActivity.prmV2Phone));
            varV2tiEmail.setText(varPrmIntent.getStringExtra(MainActivity.prmV2Email));
            varV2tiDesc.setText(varPrmIntent.getStringExtra(MainActivity.prmV2Desc));
        }
    }

    // Define el metodo que se configura en la propiedad onClick del objeto v2_button y que hace
    // el carge de la MainActivity1 y le envia los parametros
    public void onClickBoton1(View v){
        Intent varIntent = new Intent(this, MainActivity.class);
        varIntent.putExtra(prmV1Name, varV2tiName.getText().toString().trim());
        varIntent.putExtra(prmV1Date, varV2tiDate.getText().toString().trim());
        varIntent.putExtra(prmV1Phone, varV2tiPhone.getText().toString().trim());
        varIntent.putExtra(prmV1Email, varV2tiEmail.getText().toString().trim());
        varIntent.putExtra(prmV1Desc, varV2tiDesc.getText().toString().trim());
        startActivity(varIntent);
    }

}