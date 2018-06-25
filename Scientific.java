package com.example.kunalfarmah.kalculator;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class Scientific extends Fragment  implements View.OnClickListener {

    String angleval ="DEG";


    Button sin;
    Button cos;
    Button tan;
    Button sec;
    Button cosec;
    Button cot;
    Button inv;
    Button rad;
    Button equals;
    ImageButton backspace;
    Button close;

    FrameLayout fl;
    TextView res;
    TextView n1;
    TextView ops;
    TextView n2;
    TextView angle;


    public Scientific() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View fragment = inflater.inflate(R.layout.sci_main,container,false);

        fl=getActivity().findViewById(R.id.scibuttons);
        res = getActivity().findViewById(R.id.result);
        n1 = getActivity().findViewById(R.id.n1);
        n2 =getActivity().findViewById(R.id.n2);
        ops =getActivity().findViewById(R.id.operator);
        angle = getActivity().findViewById(R.id.angle);


        sin =fragment.findViewById(R.id.sin);
        cos =fragment.findViewById(R.id.cos);
        tan =fragment.findViewById(R.id.tan);
        sec =fragment.findViewById(R.id.sec);
        cosec =fragment.findViewById(R.id.cosec);
        cot =fragment.findViewById(R.id.cot);
        backspace = fragment.findViewById(R.id.backsp_);
        inv =fragment.findViewById(R.id.inv);
        rad =fragment.findViewById(R.id.rad);
        close =fragment.findViewById(R.id.close);
        equals = fragment.findViewById(R.id.eq);

        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        cot.setOnClickListener(this);
        cosec.setOnClickListener(this);
        sec.setOnClickListener(this);
        inv.setOnClickListener(this);
        rad.setOnClickListener(this);
        equals.setOnClickListener(this);
        backspace.setOnClickListener(this);
        close.setOnClickListener(this);
        
        return fragment;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.rad:
                angleval="RAD";
                angle.setText(angleval);
            case R.id.close: fl.setVisibility(View.GONE);

        }

    }
}
