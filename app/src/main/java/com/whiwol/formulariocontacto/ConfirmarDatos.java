package com.whiwol.formulariocontacto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvCorreo;
    private TextView tvDescripcion;
    private TextView tvNacimiento;

    String nombre;
    String telefono;
    String correo;
    String descripcion;
    String nacimiento;

    private static final int OK_RESULT_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        //Recibiendo los parametros enviados enviados en la pantalla anterior
        recibirParametros();

    }

    public void ejecutarEdit(View view) {
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("enombre", nombre);
        i.putExtra("etelefono", telefono);
        i.putExtra("ecorreo", correo);
        i.putExtra("edescripcion", descripcion);
        i.putExtra("enacimiento", nacimiento);
        setResult(OK_RESULT_CODE, i);
        finish();
    }

    public void recibirParametros(){
        Bundle parametros = getIntent().getExtras();
        nombre = parametros.getString(getResources().getString(R.string.nombreConfirmar)); //nombre
        telefono = parametros.getString(getResources().getString(R.string.telefonoConfirmar)); //telefono
        correo = parametros.getString(getResources().getString(R.string.correoConfirmar)); //correo
        descripcion = parametros.getString(getResources().getString(R.string.descripcionConfirmar)); //descripcion
        nacimiento = parametros.getString(getResources().getString(R.string.nacimientoConfirmar)); //descripcion

        tvNombre = (TextView) findViewById(R.id.tvNombreConfirmar);
        tvTelefono = (TextView) findViewById(R.id.tvTelefonoConfirmar);
        tvCorreo = (TextView) findViewById(R.id.tvCorreoConfirmar);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcionConfirmar);
        tvNacimiento = (TextView) findViewById(R.id.tvNacimientoConfirmar);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvNacimiento.setText(nacimiento);
        tvCorreo.setText(correo);
        tvDescripcion.setText(descripcion);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
