package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ecare.newu.e_care.R;
import com.ecare.newu.e_care.ip_url;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_complain extends Fragment {
    private EditText editText1,editText2;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    String user = "shubham";
    String allow = "";
    String type[] = {"Select","Yes","No"};
   // private Button btnDisplay;
    View v;
    Spinner s1;

    public add_complain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_add_complain, container, false);
        //addListenerOnButton();
        editText1 = (EditText) v.findViewById(R.id.editText6) ;
        editText2 = (EditText) v.findViewById(R.id.editText7) ;


        s1 = (Spinner) v.findViewById(R.id.spinner2);
        ArrayAdapter a1 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,type);
        s1.setAdapter(a1);

        Button b1 = (Button) v.findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                server();
            }
        });
        return v;

    }

    public void server() {

        ip_url u   = new ip_url();
        Toast.makeText(getContext(), ""+ s1.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        // Toast.makeText(getContext(), "enter", Toast.LENGTH_SHORT).show();

        String ip = u.geturl();
        String json_url_name = ip+"complain.php";
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, json_url_name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //    Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
                    if(response.equals("1")) {
                        Toast.makeText(getContext(), "Your Complain is Registered", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getContext(), "Error.. try again", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Server Error"+error, Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("user", user);
                params.put("com", editText2.getText().toString());
                params.put("allow", s1.getSelectedItem().toString());
                params.put("loc", editText1.getText().toString());
                return params;
            }
        };
        RequestQueue re = Volley.newRequestQueue(getContext());
        re.add(stringRequest1);
    }
}



