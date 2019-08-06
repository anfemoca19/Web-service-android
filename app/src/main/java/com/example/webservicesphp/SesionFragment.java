package com.example.webservicesphp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;


public class SesionFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {

    //Instanciamos lo sobjetos para tomar los datos en formato de json
    RequestQueue rq; // cola de solicitud
    JsonRequest jrq;


    EditText usr, clave, correo, nombre;
    Button iniciar, registrar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sesion, container, false);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista = inflater.inflate(R.layout.fragment_sesion,container,false);
        usr = vista.findViewById(R.id.etusr);
        clave = vista.findViewById(R.id.etclave);
        nombre= vista.findViewById(R.id.etnombre);
        correo = vista.findViewById(R.id.etcorreo);
        iniciar = vista.findViewById(R.id.btniniciar);
        rq = Volley.newRequestQueue(getContext());//requerimiento Volley
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarse();
            }
        });
        return vista;

    }
    private void iniciarse() {
        String url = "http://172.16.22.5:8081/ServiciosWebAndroidPHP/sesion.php?usr="+usr.getText().toString()+"&clave="+clave.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        rq.add(jrq);
    }



    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(),"Usuario no encontrado  ...", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(),"Usuario encontrado...", Toast.LENGTH_SHORT).show();
    }
}
