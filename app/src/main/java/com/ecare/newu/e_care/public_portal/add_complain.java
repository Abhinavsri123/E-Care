package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ecare.newu.e_care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_complain extends Fragment {
    private EditText editText1,editText2;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
   // private Button btnDisplay;
    View v;

    public add_complain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_add_complain, container, false);
        //addListenerOnButton();

        radioSexGroup = (RadioGroup) v.findViewById(R.id.radioSex);
        int selectedId = radioSexGroup.getCheckedRadioButtonId();

        // find the radiobutton by returned id
        //   radioSexButton = (RadioButton) v.findViewById(selectedId);

        radioSexGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton button = (RadioButton) v.findViewById(checkedId);
                String m = button.getText().toString();
                Toast.makeText(getContext(), ""+m, Toast.LENGTH_SHORT).show();

            }
        });


        return v;

    }
}



