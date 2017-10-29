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
public class view_history extends Fragment {

    ListView l1;
    ArrayList<String> sn;
    ArrayList<String> date;
    ArrayList<String> status;
    ArrayList<String> point;
    String user = "shubham";

    public view_history() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_view_history, container, false);

        l1 = (ListView) v.findViewById(R.id.list);



        sn  = new ArrayList<String>();
        date  = new ArrayList<String>();
        status = new ArrayList<String>();
        point = new ArrayList<String>();

        server();
        /*

        sn.add("1");
        date.add("10/10/2015");
        status.add("Action Taken");
        point.add("288");



        sn.add("2");
        date.add("10/12/2015");
        status.add("Under Process");
        point.add("0");
*/
       // CustomAdapter customAdapter = new CustomAdapter();
     //   l1.setAdapter(customAdapter);

        return v;
    }
    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return sn.size();
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

            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_viewhistory, null);
            TextView t1 = (TextView) convertView.findViewById(R.id.textView18);
            TextView t2 = (TextView) convertView.findViewById(R.id.textView19);
            TextView t3 = (TextView) convertView.findViewById(R.id.textView20);
            TextView t4 = (TextView) convertView.findViewById(R.id.textView21);
            t1.setText(sn.get(position));
            t2.setText(date.get(position));
            t3.setText(status.get(position));
            t4.setText(point.get(position));

            return convertView;

        }
    }

    public void server() {

        ip_url u   = new ip_url();
        String ip = u.geturl();
        String json_url_name = ip+"history.php";

        JSONObject params = new JSONObject();
        try {
            params.put("user", user);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, json_url_name, params, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("server_response");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject student = jsonArray.getJSONObject(i);
                        String sn1 = student.getString("sn");
                        String date1 = student.getString("date");
                        String status1 = student.getString("status");
                        String point1 = student.getString("point");
                        sn.add(""+sn1);
                        date.add("" + date1);
                        status.add("" + status1);
                        point.add("" + point1);

                    }
                } catch (JSONException e) {

                }
                CustomAdapter customAdapter = new CustomAdapter();
                l1.setAdapter(customAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue re = Volley.newRequestQueue(getContext());
        re.add(jsonObjectRequest);
    }

}
