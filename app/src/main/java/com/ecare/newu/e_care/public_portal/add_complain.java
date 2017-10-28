package com.ecare.newu.e_care.public_portal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ecare.newu.e_care.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class add_complain extends Fragment {

    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    private Button btnDisplay;

    public add_complain() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_add_complain, container, false);
        addListenerOnButton();
        return v;
    }

    public void addListenerOnButton() {

        radioSexGroup = (RadioGroup) getActivity().findViewById(R.id.radioSex);
        btnDisplay = (Button) getActivity().findViewById(R.id.btnDisplay);

        btnDisplay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // get selected radio button from radioGroup
                int selectedId = radioSexGroup.getCheckedRadioButtonId();

                // find the radiobutton by returned id
                radioSexButton = (RadioButton) v.findViewById(selectedId);

                Toast.makeText(getContext(),
                        radioSexButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });
    }
}



