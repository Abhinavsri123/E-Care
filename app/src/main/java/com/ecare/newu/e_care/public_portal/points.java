package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class points extends Fragment {
    TextView t1;
    String user = "shubham";
    public points() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_points, container, false);
        t1 = (TextView) v.findViewById(R.id.textView22);
        t1.setText("");
         server();
         //t1.setText("288");
        return v;
    }

    public void server() {
        ip_url u   = new ip_url();

        // Toast.makeText(getContext(), "enter", Toast.LENGTH_SHORT).show();

        String ip = u.geturl();
        String json_url_name = ip+"points.php";
        StringRequest stringRequest1 = new StringRequest(Request.Method.POST, json_url_name, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                   t1.setText(""+response);
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
                return params;
            }
        };
        RequestQueue re = Volley.newRequestQueue(getContext());
        re.add(stringRequest1);
    }


}
