package com.whiwol.formulariocontacto;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText edtNombre;
    EditText edtTelefono;
    EditText edtCorreo;
    EditText edtDescripcion;
    DatePicker dpfecha;
    protected static final int REQUEST_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejecutarNext(View view) {
        String nombre;
        String diaNacimiento;
        String telefono;
        String correo;
        String descripcion;

        dpfecha = (DatePicker) findViewById(R.id.datePickerNacimiento);
        diaNacimiento = DateFormat.getDateInstance().format(dpfecha.getCalendarView().getDate());

        edtNombre = (EditText) findViewById(R.id.tiNombre);
        nombre = edtNombre.getText().toString();
        Log.v("EditText", nombre);

        edtTelefono = (EditText) findViewById(R.id.tiTelefono);
        telefono = edtTelefono.getText().toString();

        edtCorreo = (EditText) findViewById(R.id.tiCorreo);
        correo = edtCorreo.getText().toString();

        edtDescripcion = (EditText) findViewById(R.id.tiDescripcion);
        descripcion = edtDescripcion.getText().toString();

        Intent intent = new Intent(this, ConfirmarDatos.class );
        intent.putExtra("nombre", nombre);
        intent.putExtra("telefono", telefono);
        intent.putExtra("correo", correo);
        intent.putExtra("descripcion", descripcion);
        intent.putExtra("nacimiento", diaNacimiento);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
