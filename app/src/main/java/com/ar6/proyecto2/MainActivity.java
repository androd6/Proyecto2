package com.ar6.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Definicion de las variables que se emparejaran con los objetos de la vista
    private TextInputEditText varV1tiName;
    private TextInputEditText varV1tiDate;
    private TextInputEditText varV1tiPhone;
    private TextInputEditText varV1tiEmail;
    private TextInputEditText varV1tiDesc;

    // Definicion de la variable con la que se controlara el listener del DatePicker
    DatePickerDialog.OnDateSetListener varV1ltDate;

    // Definicion de las constantes que se usaran para definir la clave que identificara
    // los parametros que se enviaran a la actividad Mainactivity2
    // Como buena practica la clave se define con el nombre del paquete + el nombre del
    // parametro, para garantizar que las claves sean unicas en caso de que la app
    // interactue con otras apps
    public static final String prmV2Name = "com.ar6.proyecto2.PrmV2Name";
    public static final String prmV2Date = "com.ar6.proyecto2.PrmV2Date";
    public static final String prmV2Phone = "com.ar6.proyecto2.PrmV2Phone";
    public static final String prmV2Email = "com.ar6.proyecto2.PrmV2Email";
    public static final String prmV2Desc = "com.ar6.proyecto2.PrmV2Desc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Emparejamiento de las variables con los objetos de la vista
        varV1tiName = findViewById(R.id.v1_tiname);
        varV1tiDate = findViewById(R.id.v1_tidate);
        varV1tiPhone = findViewById(R.id.v1_phone);
        varV1tiEmail = findViewById(R.id.v1_tiemail);
        varV1tiDesc = findViewById(R.id.v1_tidesc);

        // Bloqueo de la aparicion del teclado y se impide la escritura en el objeto
        varV1tiDate.setInputType(InputType.TYPE_NULL);
        varV1tiDate.setKeyListener(null);

        // Definicion del evento OnClickListener del objeto de la fecha de nacimiento
        // este evento es el que llama al metodo que crea y muestra el Date Picker al usuario
        varV1tiDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showDatePickerDialog(view);
            }
        });

        // Definicion del evento onDateSet del objeto DatePicker, este es el evento
        // con el que se escribe en el objeto fecha de nacimiento,la fecha seleccionada
        // por el ususario
        varV1ltDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 +1;
                String varDate = i2 + "/" + i1 + "/" + i;
                varV1tiDate.setText(varDate);
            }
        };

        // Definicion de la variable Intent que recibe los parametros
        Intent varPrmIntent = getIntent();

        // Verifica que llegaron parametros, si llega al menos 1 se signan a sus
        // respectivos objetos
        if (varPrmIntent.getExtras() != null){
            varV1tiName.setText(varPrmIntent.getStringExtra(MainActivity2.prmV1Name));
            varV1tiDate.setText(varPrmIntent.getStringExtra(MainActivity2.prmV1Date));
            varV1tiPhone.setText(varPrmIntent.getStringExtra(MainActivity2.prmV1Phone));
            varV1tiEmail.setText(varPrmIntent.getStringExtra(MainActivity2.prmV1Email));
            varV1tiDesc.setText(varPrmIntent.getStringExtra(MainActivity2.prmV1Desc));
        }

    }

    // Define el metodo que crea y muestra el DatePicker al usuario
    public void showDatePickerDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog varDataPicker = new DatePickerDialog(MainActivity.this,varV1ltDate , year, month, day);
        varDataPicker.show();
    }

    // Define el metodo que se configura en la propiedad onClick del objeto boton y que hace
    // el carge de la MainActivity2 y le envia los parametros
    public void onClickBoton1(View v){
        Intent varIntent = new Intent(this, MainActivity2.class);
        varIntent.putExtra(prmV2Name, varV1tiName.getText().toString().trim());
        varIntent.putExtra(prmV2Date, varV1tiDate.getText().toString().trim());
        varIntent.putExtra(prmV2Phone, varV1tiPhone.getText().toString().trim());
        varIntent.putExtra(prmV2Email, varV1tiEmail.getText().toString().trim());
        varIntent.putExtra(prmV2Desc, varV1tiDesc.getText().toString().trim());
        startActivity(varIntent);
    }
}