package com.ar6.proyecto2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.DatePickerDialog;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    TextInputEditText varV1tiName;
    TextInputEditText varV1tiDate;
    DatePickerDialog.OnDateSetListener varV1ltDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        varV1tiName = findViewById(R.id.v1_tiname);
        varV1tiDate = findViewById(R.id.v1_tidate);

        varV1tiDate.setInputType(InputType.TYPE_NULL);
        varV1tiDate.setKeyListener(null);

        varV1tiDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(view);
            }
        });

        varV1ltDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                i1 = i1 +1;
                String varDate = i2 + "/" + i1 + "/" + i;
                varV1tiDate.setText(varDate);
            }
        };
    }

    public void showDatePickerDialog(View v) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog varDataPicker = new DatePickerDialog(MainActivity.this,varV1ltDate , year, month, day);
        varDataPicker.show();
    }

    public void onClickBoton1(View v){
        varV1tiName.setText("Hola");
    }
}