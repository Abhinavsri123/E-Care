package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.ecare.newu.e_care.R;
import com.ecare.newu.e_care.ip_url;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class view_challan extends Fragment {
    ListView l1;
    ArrayList<String> chlno;
    ArrayList<String> date;
    ArrayList<String> vehical;
    ArrayList<String> resone;
    ArrayList<String> fine;
    String user = "shubham";
    public view_challan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_view_challan, container, false);

        l1 = (ListView) v.findViewById(R.id.list);



        chlno  = new ArrayList<String>();
        date  = new ArrayList<String>();
        vehical = new ArrayList<String>();
        resone = new ArrayList<String>();
        fine = new ArrayList<String>();
/*

        chlno.add("1");
        date.add("10/10/2015");
        vehical.add("JH-01BN 0192");
        resone.add("Helment");
        fine.add("Rs 500");


        chlno.add("2");
        date.add("10/12/2015");
        vehical.add("JH-01BN 0192");
        resone.add("Triplr");
        fine.add("Rs 1500");
*/
    //    CustomAdapter customAdapter = new CustomAdapter();
  //      l1.setAdapter(customAdapter);
        server();
        return v;
    }


    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return chlno.size();
        }

        @Override
        public Object getItem(int position) {
           // Toast.makeText(getContext(), "" + position, Toast.LENGTH_SHORT).show();
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_challan, null);
            TextView t1 = (TextView) convertView.findViewById(R.id.textView4);
            TextView t2 = (TextView) convertView.findViewById(R.id.textView6);
            TextView t3 = (TextView) convertView.findViewById(R.id.textView8);
            TextView t4 = (TextView) convertView.findViewById(R.id.textView10);
            TextView t5 = (TextView) convertView.findViewById(R.id.textView12);
            Button b1 = (Button) convertView.findViewById(R.id.button4);
            t1.setText(chlno.get(position));
            t2.setText(date.get(position));
            t3.setText(vehical.get(position));
            t4.setText(resone.get(position));
            t5.setText(fine.get(position));

            final int pos = position;

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "Paid", Toast.LENGTH_SHORT).show();
                }
            });


            return convertView;

        }
    }


    public void server() {

        ip_url u   = new ip_url();
        String ip = u.geturl();
        String json_url_name = ip+"challan.php";

        JSONObject params = new JSONObject();
        try {
            params.put("user", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, json_url_name, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
           //     Toast.makeText(getContext(), "he"+response, Toast.LENGTH_SHORT).show();
                try {

                    JSONArray jsonArray = response.getJSONArray("server_response");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject student = jsonArray.getJSONObject(i);
                        String sn1 = student.getString("ch");
                        String date1 = student.getString("date");
                        String vehical1 = student.getString("vehical");
                        String resone1 = student.getString("resone");
                        String fine1 = student.getString("fine");
                        chlno.add(""+sn1);
                        date.add("" + date1);
                        vehical.add(""+vehical1);
                        resone.add(""+resone1);
                        fine.add(""+fine1);
                    }
                } catch (JSONException e) {

                }
                CustomAdapter customAdapter = new CustomAdapter();
                l1.setAdapter(customAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getContext(), ""+error, Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue re = Volley.newRequestQueue(getContext());
        re.add(jsonObjectRequest);
    }

}
