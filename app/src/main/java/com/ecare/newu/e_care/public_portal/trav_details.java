package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.ecare.newu.e_care.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class trav_details extends Fragment {

    Spinner s1;
    String type[] = {"Select Vehical Type","Taxi","Auto","Ricksaw","Private Car","Rental Car"};
    TextView t1,t2;

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
        t1.setText(getdate());
        t2.setText(gettime());
        ArrayAdapter a1 = new ArrayAdapter(getContext(),R.layout.support_simple_spinner_dropdown_item,type);
        s1.setAdapter(a1);
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
}
