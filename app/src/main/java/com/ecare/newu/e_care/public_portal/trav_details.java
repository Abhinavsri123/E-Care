package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class trav_details extends Fragment {

    Spinner s1;
    String type[] = {"Select Vehical Type","Taxi","Auto","Rickshaw","Private Car","Rental Car"};
    TextView t1,t2,t3;
    String user = "shubham";
    EditText e1;
    Button b1;

    public trav_details() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_trav_details, container, false);

        s1 = (Spinner) v.findViewById(R.id.spinner);
        t1= (TextView) v.findViewById(R.id.textView27);
        t2= (TextView) v.findViewById(R.id.textView28);
        e1= (EditText) v.findViewById(R.id.textView31);
        t1.setText(getdate());
        t2.setText(gettime());
        ArrayAdapter a1 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,type);
        s1.setAdapter(a1);
        b1 = (Button) v.findViewById(R.id.button5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (b1.getText().toString().equalsIgnoreCase("Stop tracking")) {
                    b1.setText("Start Tracking");
                } else {
                    server();
                }
            }
        });
        return v;
    }

    public String getdate()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    public String gettime()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String currentDateandTime = sdf.format(new Date());
        return currentDateandTime;
    }

    public void server() {

        ip_url u   = new ip_url();

        // Toast.makeText(getContext(), "enter", Toast.LENGTH_SHORT).show();

        String ip = u.geturl();
        String json_url_name = ip+"trav.php";
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, json_url_name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //    Toast.makeText(getContext(), ""+response, Toast.LENGTH_SHORT).show();
                    if(response.equals("1")) {
                        Toast.makeText(getContext(), "Your Location is monitored by Police Control Room", Toast.LENGTH_SHORT).show();
                        b1.setText("Stop Tracking");
                    }
                    else
                        Toast.makeText(getContext(), "Error.. try again"+response, Toast.LENGTH_SHORT).show();
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
                params.put("date", t1.getText().toString());
                params.put("time", t2.getText().toString());
                params.put("type", s1.getSelectedItem().toString());
                params.put("number", e1.getText().toString());
                params.put("location", "Patia");
                return params;
            }
        };
        RequestQueue re = Volley.newRequestQueue(getContext());
        re.add(stringRequest1);
    }
}
