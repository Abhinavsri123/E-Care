package com.ecare.newu.e_care.Ambulance;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ecare.newu.e_care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class emergancy extends Fragment {

    int x;
    Button b1;

    public emergancy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_emergancy, container, false);

        b1 = (Button) v.findViewById(R.id.button8);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(x==0)
                {
                    Toast.makeText(getContext(), "Emergency Services Started", Toast.LENGTH_SHORT).show();
                    b1.setText("Stop Emergency Service");
                    x++;
                }
                else
                {
                    b1.setText("Start Emergency Service");
                    x=0;

                }
            }
        });
        return v;
    }

}
