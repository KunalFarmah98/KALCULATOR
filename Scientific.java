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
    boolean isinverse = false;

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
    Button equals;
    ImageButton backspace;
    Button close;

    FrameLayout fl;
    TextView res;
    TextView n1;
    TextView ops;
    TextView n2;
    TextView angle;

    MainActivity var;


    public Scientific() {
        // Required empty public constructor
    }


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
        switch (v.getId()) {
            case R.id.rad:
                var.visual();
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
                var.visual();
                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;

                if (!isinverse)
                    ops.setText("sin");
                else
                    ops.setText("(arc)sin");
                break;
            case R.id.cos:
                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled=true;
                var.visual();
                if (!isinverse)
                    ops.setText("cos");
                else
                    ops.setText("(arc)cos");
                break;
            case R.id.tan:
                var.visual();
                if(n1.getText().toString().equals("0"))
                    n1.setText("");

                if (!isinverse)
                    ops.setText("tan");
                else
                    ops.setText("(arc)tan");
                break;
            case R.id.sec:
                var.visual();
                if(n1.getText().toString().equals("0"))
                    n1.setText("");

                if (!isinverse)
                    ops.setText("sec");
                else
                    ops.setText("(arc)sec");
                break;
            case R.id.cosec:
                var.visual();
                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                if (!isinverse)
                    ops.setText("cosec");
                else
                    ops.setText("(arc)cosec");
                break;
            case R.id.cot:
                var.visual();
                if(n1.getText().toString().equals("0"))
                    n1.setText("");
                if (!isinverse)
                    ops.setText("cot");
                else
                    ops.setText("(arc)cot");
                break;

            case R.id.inv:
                ++invpressed;
                if(invpressed%2!=0) {
                    isinverse = true;
                    inv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                }
                else{
                    isinverse=false;
                    inv.setBackgroundColor(getResources().getColor(R.color.bck));

                }

                break;
            case R.id.eq:
                Double ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                var.equalispressed = true;
                res.setText(ans.toString());
                var.resetall();
                break;

            case R.id.backsp_:

                var.visual();

                if (var.n2isfilled) {

                    String str = n2.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);      //deleting 1 element with every touch
                        n2.setText(str);
                    } else if (str.length() <= 1) {
                        n2.setText("0");
                        var.n2isfilled = false;
                    }
                } else if (!var.n2isfilled && !ops.getText().toString().equals(".")) {
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


    private Double result(String n1, String n2, String ops) {

        Double ans = 0d;

        switch (ops) {
            case "sin":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.sin(Math.toDegrees(Double.parseDouble(n2))) :
                            java.lang.Math.sin(Math.toDegrees(Double.parseDouble(n2)));

                } else if (angleval.equals("RAD")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.sin((Double.parseDouble(n2))) :
                            java.lang.Math.sin((Double.parseDouble(n2)));

                }

                res.setText(ans.toString());

                break;

            case "cos":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.cos(Math.toDegrees(Double.parseDouble(n2))) :
                            java.lang.Math.cos(Math.toDegrees(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.cos((Double.parseDouble(n2))) :
                            java.lang.Math.cos((Double.parseDouble(n2)));
                }

                res.setText(ans.toString());
                break;

            case "tan":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.tan(Math.toDegrees(Double.parseDouble(n2))) :
                            java.lang.Math.tan(Math.toDegrees(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.tan((Double.parseDouble(n2))) :
                            java.lang.Math.tan((Double.parseDouble(n2)));
                }

                res.setText(ans.toString());
                break;


            case "sec":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.cos(Math.toDegrees(Double.parseDouble(n2)))) :
                            1d / java.lang.Math.cos(Math.toDegrees(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.cos((Double.parseDouble(n2)))) :
                            1d / java.lang.Math.cos((Double.parseDouble(n2)));

                }
                res.setText(ans.toString());
                break;


            case "cosec":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.sin(Math.toDegrees(Double.parseDouble(n2)))) :
                            1d / java.lang.Math.sin(Math.toDegrees(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.sin((Double.parseDouble(n2)))) :
                            1d / java.lang.Math.sin((Double.parseDouble(n2)));

                }
                res.setText(ans.toString());
                break;

            case "cot":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.tan(Math.toDegrees(Double.parseDouble(n2)))) :
                            1d / java.lang.Math.tan(Math.toDegrees(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.tan((Double.parseDouble(n2)))) :
                            1d / java.lang.Math.tan((Double.parseDouble(n2)));

                }
                res.setText(ans.toString());
                break;

            case "(arc)sin":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.asin(Double.parseDouble(n2))) :
                            Math.toDegrees(java.lang.Math.asin(Double.parseDouble(n2)));
                } else if(angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) *(java.lang.Math.asin(Double.parseDouble(n2))) :
                          (java.lang.Math.asin(Double.parseDouble(n2)));

                }
                res.setText(ans.toString());

                break;
            case "(arc)cos":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.acos(Double.parseDouble(n2))) :
                            Math.toDegrees(java.lang.Math.acos(Double.parseDouble(n2)));
                } else if(angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.acos(Double.parseDouble(n2)) :
                            (java.lang.Math.acos(Double.parseDouble(n2)));

                }
                res.setText(ans.toString());
                break;

            case "(arc)tan":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(java.lang.Math.atan(Double.parseDouble(n2))) :
                            Math.toDegrees(java.lang.Math.atan(Double.parseDouble(n2)));
                } else if(angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.atan(Double.parseDouble(n2)) :
                           (java.lang.Math.atan(Double.parseDouble(n2)));

                }
                res.setText(ans.toString());
                break;

            case "(arc)sec":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(1d / java.lang.Math.acos(Double.parseDouble(n2))) :
                            Math.toDegrees(1d / java.lang.Math.cos(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.acos((Double.parseDouble(n2)))) :
                            1d / java.lang.Math.acos((Double.parseDouble(n2)));

                }
                res.setText(ans.toString());
                break;

            case "arc(cosec)":
                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(1d / java.lang.Math.asin(Double.parseDouble(n2))) :
                            Math.toDegrees(1d / java.lang.Math.asin(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.asin((Double.parseDouble(n2)))) :
                            1d / java.lang.Math.asin(Double.parseDouble(n2));

                }
                res.setText(ans.toString());
                break;

            case "(arc)cot":

                if (angleval.equals("DEG")) {
                    ans = !n1.equals("") ? Double.parseDouble(n1) * Math.toDegrees(1d / java.lang.Math.atan(Double.parseDouble(n2))) :
                            Math.toDegrees(1d / java.lang.Math.atan(Double.parseDouble(n2)));
                } else if (angleval.equals("RAD")) {

                    ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.atan((Double.parseDouble(n2)))) :
                            1d / java.lang.Math.atan(Double.parseDouble(n2));

                }
                res.setText(ans.toString());
                break;

        }

        return ans;

    }
}
