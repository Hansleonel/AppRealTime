package com.example.codehans.apprealtime;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private Button btn_Accept;
    private EditText txt_User;
    private EditText txt_Password;

    //parametros usados para el uso de Json y la libreria Volley
    private static String IP = "http://realtimeapp.hol.es/connectionphp/Login_GetID.php?id=";

    private RequestQueue mRequest;
    private VolleyToResponse volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instanciando las variables para el uso de volley
        volley = VolleyToResponse.getInstance(this);
        mRequest = volley.getRequestque();

        txt_User = (EditText)findViewById(R.id.txt_user);
        txt_Password = (EditText)findViewById(R.id.txt_password);
        btn_Accept = (Button)findViewById(R.id.btn_accept);

        btn_Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerificarLogin(txt_User.getText().toString(),txt_Password.getText().toString());
                //Toast.makeText(MainActivity.this,"los datos son",Toast.LENGTH_LONG).show();
                //Snackbar.make(v,"Ingresando",Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    public void VerificarLogin(String user, String password) {
        //USANDO EL VOLLEY PARA MANEJO DE JSON
        //Toast.makeText(this,"ek usuario es "+user+" el password es "+password+" la url es "+IP,Toast.LENGTH_LONG).show();
        SolicitudJson(IP+user);
    }

    public void SolicitudJson(String URL){
        JsonObjectRequest solicitud = new JsonObjectRequest(URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject respuesta) {
                //est emetodo se ejecuta cuando existe una correcta respuesta de la url
                VerificandoPassword(respuesta);
            }
        },new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                //este metodo se ejecuta cuando existe un error en la respuesta de la url
                //RECORDAR QUE POR SER METODOS ANNMS DEVEMOS ESPECIFICAR EL CONTEXTO EN CASO USEMOS ALGUN METODO QUE
                //REQUIERA DICHO CONTEXTO
                Toast.makeText(MainActivity.this,"ERROR PLEASE CONTACT WITH THE MANAGER",Toast.LENGTH_LONG).show();
            }
        });
        VolleyToResponse.addToQueque(solicitud,mRequest,this,volley);
    }

    private void VerificandoPassword(JSONObject datosRespuesta) {
        //Control del Json recivido como respuesta de la URL
        Toast.makeText(this,"Los datos son"+datosRespuesta.toString(), Toast.LENGTH_LONG).show();
        //COMO NECESITAMOS UNA CONEXION A INTERNET CUANDO CONECTEMOS LA APLICACION CON LA URL PARA
        //OBTENER EL JSON NECESITAMOS DARLE PERMISOS A LA APLICACION EN EL MANIFEST
    }
}
