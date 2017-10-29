package com.ecare.newu.e_care.police;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ecare.newu.e_care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ambulances_near_you extends Fragment {


    public ambulances_near_you() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_ambulances_near_you, container, false);
        return v;
    }

}
