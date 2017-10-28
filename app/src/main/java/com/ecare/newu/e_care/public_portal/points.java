package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ecare.newu.e_care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class points extends Fragment {
    TextView t1;
    public points() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_points, container, false);
        t1 = (TextView) v.findViewById(R.id.textView22);
        t1.setText("288");
        return v;
    }

}
