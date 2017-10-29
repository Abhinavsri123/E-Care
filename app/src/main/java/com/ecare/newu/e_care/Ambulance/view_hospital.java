package com.ecare.newu.e_care.Ambulance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ecare.newu.e_care.R;
import com.ecare.newu.e_care.public_portal.view_history;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class view_hospital extends Fragment {

    ArrayList<String> name;
    ArrayList<String> type;
    ArrayList<String> address;
    ArrayList<String> phone;
    ArrayList<String> email;
    ArrayList<String> website;

    ListView l1;
    public view_hospital() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_view_hospital, container, false);
        l1 = (ListView) v.findViewById(R.id.list);
        name = new ArrayList<String>();
        type = new ArrayList<String>();
        address= new ArrayList<String>();
        phone= new ArrayList<String>();
        email= new ArrayList<String>();
        website= new ArrayList<String>();


        adddata();

       CustomAdapter customAdapter = new CustomAdapter();
        l1.setAdapter(customAdapter);

        return v;
    }

    public void adddata()
    {
        name.add("Kalinga Institute of Medical Sciences");
        type.add("Public");
        address.add("Shikhar Chandi Road, Patia");
        phone.add("0674-2725415");
        email.add("info@kims.ac.in");
        website.add("www.kims.ac.in");


        name.add("Institute of Medical Asciences");
        type.add("Private");
        address.add("IMS & SUM Hospital, K-8,Kalinga Nagar");
        phone.add("0674-2386292");
        email.add("sumhospital@soauniversity.ac.in");
        website.add("www.ims.ac.in");

        name.add("Hi Tech Medical College, Bhubaneswar");
        type.add("Public");
        address.add("Pandara, Rasulgarh, Bhubaneswar");
        phone.add("0674-2371407");
        email.add("info@hi-techmedical.org");
        website.add("www.hi-techmedical.org");

        name.add("AIIMS, Bhubaneswar");
        type.add("Public");
        address.add("Sijua Patrapada, Bhubaneshwar");
        phone.add("0674-2114400");
        email.add("NA");
        website.add("www.aiimsbhubaneswar.edu.in");


    }

    class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return name.size();
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

            convertView = getActivity().getLayoutInflater().inflate(R.layout.list_hospital, null);
            TextView t1 = (TextView) convertView.findViewById(R.id.textView37);
            TextView t2 = (TextView) convertView.findViewById(R.id.textView38);
            TextView t3 = (TextView) convertView.findViewById(R.id.textView39);
            TextView t4 = (TextView) convertView.findViewById(R.id.textView40);
            TextView t5 = (TextView) convertView.findViewById(R.id.textView41);
            TextView t6 = (TextView) convertView.findViewById(R.id.textView42);
            t1.setText(name.get(position));
            t2.setText(type.get(position));
            t3.setText(address.get(position));
            t4.setText(phone.get(position));
            t5.setText(email.get(position));
            t6.setText(website.get(position));
            return convertView;

        }
    }

}
