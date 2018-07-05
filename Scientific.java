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

public class Scientific extends Fragment implements View.OnClickListener {

    String angleval = "DEG";

    final Double PI = Math.PI;

    boolean isinverse = false;
    boolean trigo = false;

    public Double temp = 0d;
    public String val = "";

    Integer ans_i= 0;
    Double ans_d = 0d;


    int invpressed=0;
    int radpressed = 0;

    Button sin;
    Button cos;
    Button tan;
    Button sec;
    Button cosec;
    Button cot;
    Button inv;
    Button rad;
    ImageButton backspace;
    Button close;
    Button pi;


    FrameLayout fl;
    TextView res;
    TextView n1;
    TextView ops;
    TextView n2;
    TextView angle;
    TextView operator2;

    MainActivity var;


    public Scientific() {
        // Required empty public constructor
    }

//
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Toast.makeText(getContext(), "onCreate_frag", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        Toast.makeText(getContext(), "onActivityCreated", Toast.LENGTH_SHORT).show();
//    }

   /* @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getContext(), "onStart_frag", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getContext(), "onResume_frag", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getContext(), "onResume_frag", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getContext(), "onStop_frag", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Toast.makeText(getContext(), "onAttatch", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getContext(), "onDestroy_frag", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDetach() {
        super.onDetach();
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_SHORT).show();
    }
*/


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        var = (MainActivity) getActivity();

        View fragment = inflater.inflate(R.layout.sci_main, container, false);

        fl = getActivity().findViewById(R.id.scibuttons);
        res = getActivity().findViewById(R.id.result);
        n1 = getActivity().findViewById(R.id.n1);
        n2 = getActivity().findViewById(R.id.n2);
        ops = getActivity().findViewById(R.id.operator);
        angle = getActivity().findViewById(R.id.angle);
        operator2 = getActivity().findViewById(R.id.operator2);


        pi= fragment.findViewById(R.id.pi);
        sin = fragment.findViewById(R.id.sin);
        cos = fragment.findViewById(R.id.cos);
        tan = fragment.findViewById(R.id.tan);
        sec = fragment.findViewById(R.id.sec);
        cosec = fragment.findViewById(R.id.cosec);
        cot = fragment.findViewById(R.id.cot);
        backspace = fragment.findViewById(R.id.backsp_);
        inv = fragment.findViewById(R.id.inv);
        rad = fragment.findViewById(R.id.rad);
        close = fragment.findViewById(R.id.close);




        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        cot.setOnClickListener(this);
        cosec.setOnClickListener(this);
        sec.setOnClickListener(this);
        inv.setOnClickListener(this);
        rad.setOnClickListener(this);
        pi.setOnClickListener(this);

        backspace.setOnClickListener(this);
        close.setOnClickListener(this);

        return fragment;
    }

    @Override
    public void onClick(View v) {

        var.sci_used=true;

        switch (v.getId()) {

            case R.id.pi:

                visualsci();
                if (!var.equalispressed) {
                    if (!var.n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("\u03C0");
                        var.n1isfilled = true;
                    } else if (var.n1isfilled && !n1.getText().toString().equals("\u03C0")&& ops.getText().toString().equals(".")) {
                        n1.append("\u03C0");
                        var.n1isfilled = true;
                    } else if (!var.n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("\u03C0");
                        var.n2isfilled = true;
                        res.setText(var.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (var.n1isfilled && var. n2isfilled &&!n2.getText().toString().equals("\u03C0")&& !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("\u03C0");
                        res.setText(var.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                } else if (var.equalispressed) {
                    if (var.n1isfilled && !ops.getText().toString().equals(".") && var.f == 0) {
                        n1.setText("\u03C0");
                        var.f = 1;
                        var.reset();
                    } else if (var.n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("\u03C0");

                    } else if (var.n1isfilled && !var.n2isfilled && !ops.getText().toString().equals(".") && var.f == 1) {
                        n2.setText("\u03C0");
                        var.n2isfilled = true;
                        res.setText(var.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (var.n1isfilled && var.n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("\u03C0");

                        res.setText(var.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                }
                break;

            case R.id.rad:
                visualsci();
                ++radpressed;
                if(radpressed%2!=0) {
                    angleval = "RAD";
                    angle.setText(angleval);
                    rad.setText("DEG");
                }

                else{
                    angleval="DEG";
                    angle.setText("DEG");
                    rad.setText("RAD");
                }
                break;

            case R.id.close:

                fl.setVisibility(View.GONE);
                break;

            case R.id.sin:


                visualsci();

                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if(ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("sin");
                    else
                        ops.setText("(arc)sin");

                    trigo=true;
                    var.sci_ops=true;
                }
                else if(!ops.getText().toString().equals(".") && !ops.getText().toString().equals("sin")){



                    if (!isinverse) {
                        operator2.setText("sin");
                        operator2.setVisibility(View.VISIBLE);
                    }
                    else {
                        operator2.setText("(arc)sin");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }
                break;


            case R.id.cos:

                visualsci();

                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if(ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("cos");
                    else
                        ops.setText("(arc)cos");

                    trigo=true;
                    var.sci_ops=true;
                }
                else if(!ops.getText().toString().equals(".") && !ops.getText().toString().equals("cos")){



                    if (!isinverse) {
                        operator2.setText("cos");
                        operator2.setVisibility(View.VISIBLE);
                    }
                    else {
                        operator2.setText("(arc)cos");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }
                break;


            case R.id.tan:

                visualsci();

                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if(ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("tan");
                    else
                        ops.setText("(arc)tan");

                    var.sci_ops=true;
                    trigo=true;
                }
                else if(!ops.getText().toString().equals(".") && !ops.getText().toString().equals("tan")){



                    if (!isinverse) {
                        operator2.setText("tan");
                        operator2.setVisibility(View.VISIBLE);
                    }
                    else {
                        operator2.setText("(arc)tan");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }
                break;


            case R.id.sec:

                visualsci();

                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if(ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("sec");
//                    else
//                        ops.setText("(arc)sec");

                    trigo=true;
                    var.sci_ops=true;

                }
                else if(!ops.getText().toString().equals(".") && !ops.getText().toString().equals("sec")){



                    if (!isinverse) {
                        operator2.setText("sec");
                        operator2.setVisibility(View.VISIBLE);
                    }
//                    else {
//                        operator2.setText("(arc)sec");
//                        operator2.setVisibility(View.VISIBLE);
//                    }
                }
                break;

            case R.id.cosec:

                visualsci();

                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if(ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("cosec");
//                    else
//                        ops.setText("(arc)cosec");

                    trigo=true;
                    var.sci_ops=true;
                }
                else if(!ops.getText().toString().equals(".") && !ops.getText().toString().equals("cosec")){



                    if (!isinverse) {
                        operator2.setText("cosec");
                        operator2.setVisibility(View.VISIBLE);
                    }
//                    else {
//                        operator2.setText("(arc)cosec");
//                        operator2.setVisibility(View.VISIBLE);
//                    }
                }
                break;

            case R.id.cot:

                visualsci();

                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if(ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("cot");
//                    else
//                        ops.setText("(arc)cot");

                    trigo=true;
                    var.sci_ops=true;
                }
                else if(!ops.getText().toString().equals(".") && !ops.getText().toString().equals("cot")){



                    if (!isinverse) {
                        operator2.setText("cot");
                        operator2.setVisibility(View.VISIBLE);
                    }
//                    else {
//                        operator2.setText("(arc)cot");
//                        operator2.setVisibility(View.VISIBLE);
//                    }
                }

                break;

            case R.id.inv:
                ++invpressed;
                if(invpressed%2!=0) {
                    isinverse = true;
                    inv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    sec.setBackgroundColor(getResources().getColor(R.color.not_allowed));
                    cosec.setBackgroundColor(getResources().getColor(R.color.not_allowed));
                    cot.setBackgroundColor(getResources().getColor(R.color.not_allowed));


                }
                else{
                    isinverse=false;
                    inv.setBackgroundColor(getResources().getColor(R.color.bck));
                    sec.setBackgroundColor(getResources().getColor(R.color._default));
                    cosec.setBackgroundColor(getResources().getColor(R.color._default));
                    cot.setBackgroundColor(getResources().getColor(R.color._default));
                }

                break;

            case R.id.backsp_:

                visualsci();

                if (var.n2isfilled) {

                    String str = n2.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);      //deleting 1 element with every touch
                        n2.setText(str);
                    } else if (str.length() <= 1) {
                        n2.setText("0");
                        var.n2isfilled = false;
                    }
                }

                else if(!var.n2isfilled && !operator2.getText().toString().equals("")){
                    operator2.setText("");
                    operator2.setVisibility(View.GONE);
                }
                else if (!var.n2isfilled && !ops.getText().toString().equals(".")) {
                    ops.setText(".");

                } else if (!var.n2isfilled && ops.getText().toString().equals(".") && var.n1isfilled) {
                    String str = n1.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);
                        n1.setText(str);
                    } else if (str.length() <= 1) {
                        n1.setText("0");
                        var.n1isfilled = false;
                    }
                } else if (!var.n1isfilled && !var.n2isfilled) {
                    n1.setText("0");
                    n2.setText("0");
                }

                break;


        }

    }


    public Double result(String n1, String n2, String ops, String ops2) {

        Double ans = 0d;

        if(n1.equals("\u03C0"))
            n1=PI.toString();

        if(n2.equals("\u03C0"))
            n2=PI.toString();

        if(!ops2.equals("")){
            String temp = ops2;
            ops2=ops;
            ops=temp;
        }

        switch (ops) {
            case "sin":
                if (angleval.equals("DEG")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2))) :
                                java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }


                    else if(!ops2.equals("")){

                        temp = java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());

                } else if (angleval.equals("RAD")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.sin((Double.parseDouble(n2))) :
                                java.lang.Math.sin((Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){

                        temp = java.lang.Math.sin((Double.parseDouble(n2)));    // calculating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }


                }

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());

                break;

            case "cos":
                if (angleval.equals("DEG")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2))) :
                                java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }


                    else if(!ops2.equals("")){

                        temp = java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());

                } else if (angleval.equals("RAD")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.cos((Double.parseDouble(n2))) :
                                java.lang.Math.cos((Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){

                        temp = java.lang.Math.cos((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }


                }

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "tan":
                if (angleval.equals("DEG")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2))) :
                                java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }


                    else if(!ops2.equals("")){

                        temp = java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());

                } else if (angleval.equals("RAD")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.tan((Double.parseDouble(n2))) :
                                java.lang.Math.tan((Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){

                        temp = java.lang.Math.tan((Double.parseDouble(n2)));    // calculating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }


                }

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());

                break;

            case "sec":
                if (angleval.equals("DEG")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d/java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)))) :
                                1d/ java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }


                    else if(!ops2.equals("")){

                        temp = 1d/java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());

                } else if (angleval.equals("RAD")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d/java.lang.Math.cos((Double.parseDouble(n2)))) :
                                1d/ java.lang.Math.cos((Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){

                        temp = 1d/java.lang.Math.cos((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }


                }

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;


            case "cosec":
                if (angleval.equals("DEG")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d/java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)))) :
                                1d/ java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }


                    else if(!ops2.equals("")){

                        temp = 1d/java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());

                } else if (angleval.equals("RAD")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d/java.lang.Math.sin((Double.parseDouble(n2)))) :
                                1d/ java.lang.Math.sin((Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){

                        temp = 1d/java.lang.Math.sin((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }


                }

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;
            case "cot":
                if (angleval.equals("DEG")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d/java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)))) :
                                1d/ java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }


                    else if(!ops2.equals("")){

                        temp = 1d/java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());

                } else if (angleval.equals("RAD")) {

                    if(ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d/java.lang.Math.tan((Double.parseDouble(n2)))) :
                                1d/ java.lang.Math.tan((Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){

                        temp = 1d/java.lang.Math.tan((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString() , ops2);   // passing to the parent activity result function

                    }


                }

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "(arc)sin":

                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.asin(Double.parseDouble(n2))) :
                                Math.toDegrees(java.lang.Math.asin(Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = Math.toDegrees(java.lang.Math.asin(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }
                }
                else if(angleval.equals("RAD")) {

                    if(ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.asin(Double.parseDouble(n2)) :
                                (java.lang.Math.asin(Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){
                        temp = (java.lang.Math.asin(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "(arc)cos":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.acos(Double.parseDouble(n2))) :
                                Math.toDegrees(java.lang.Math.acos(Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = Math.toDegrees(java.lang.Math.acos(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }
                }
                else if(angleval.equals("RAD")) {

                    if(ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.acos(Double.parseDouble(n2)) :
                                (java.lang.Math.acos(Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){
                        temp = (java.lang.Math.acos(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "(arc)tan":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.atan(Double.parseDouble(n2))) :
                                Math.toDegrees(java.lang.Math.atan(Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = Math.toDegrees(java.lang.Math.atan(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }
                }
                else if(angleval.equals("RAD")) {

                    if(ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.atan(Double.parseDouble(n2)) :
                                (java.lang.Math.atan(Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){
                        temp = (java.lang.Math.atan(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

/*
            case "(arc)sec":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.acos(1d/Double.parseDouble(n2))) :
                                Math.toDegrees(java.lang.Math.acos(1d/Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = Math.toDegrees(java.lang.Math.acos(1d/Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }
                }
                else if(angleval.equals("RAD")) {

                    if(ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) *(java.lang.Math.acos(1d/Double.parseDouble(n2))) :
                               (java.lang.Math.acos( 1d/Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){
                        temp = (java.lang.Math.acos(1d/Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                res.setText(ans.toString());
                break;

            case "arc(cosec)":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.asin(1d/Double.parseDouble(n2))) :
                                Math.toDegrees(java.lang.Math.asin(1d/Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = Math.toDegrees(java.lang.Math.asin(1d/Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }
                }
                else if(angleval.equals("RAD")) {

                    if(ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) *(java.lang.Math.asin(1d/Double.parseDouble(n2))) :
                                (java.lang.Math.asin(1d/Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){
                        temp = (java.lang.Math.asin(1d/Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                res.setText(ans.toString());
                break;

            case "(arc)cot":

                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.atan(1d/Double.parseDouble(n2))) :
                                Math.toDegrees(java.lang.Math.atan(1d/Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = Math.toDegrees(java.lang.Math.atan(1d/Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }
                }
                else if(angleval.equals("RAD")) {

                    if(ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) *(java.lang.Math.atan(1d/Double.parseDouble(n2))) :
                                (java.lang.Math.atan(1d/Double.parseDouble(n2)));
                    }

                    else if(!ops2.equals("")){
                        temp = (java.lang.Math.atan(1d/Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                res.setText(ans.toString());
                break;
*/



            case "sqrt":

                temp = java.lang.Math.sqrt(Double.parseDouble(n2));
                val = temp.toString();

                ans = var.result(n1, val, ops2);

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "log":
                temp = java.lang.Math.log10(Double.parseDouble(n2));
                val = temp.toString();

                ans = var.result(n1,temp.toString(), ops2);
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "ln":
                temp = java.lang.Math.log(Double.parseDouble(n2));

                ans = var.result(n1,temp.toString(), ops2);
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "10^":
                temp = java.lang.Math.pow(10d,Double.parseDouble(n2));
                val = temp.toString();
                ans = var.result(n1,val,ops2);
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;
        }

        return ans;

    }


    private void visualsci(){
        
//        if(var.equalispressed){
//            if(!ops.getText().toString().equals("."))
//                ops.setText(".");
//        }
            
        var.calc.setVisibility(View.VISIBLE);
        var.angle.setVisibility(View.VISIBLE);
    }
}