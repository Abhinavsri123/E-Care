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

import com.ecare.newu.e_care.R;

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

        CustomAdapter customAdapter = new CustomAdapter();
        l1.setAdapter(customAdapter);
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

                }
            });


            return convertView;

        }
    }

}
