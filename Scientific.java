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

import static java.lang.Double.NaN;


/**
 * A simple {@link Fragment} subclass.
 */

public class Scientific extends Fragment implements View.OnClickListener {

    String angleval = "DEG";

    final Double PI = Math.PI;

    boolean isinverse = false;
    boolean trigo = false;

    public Double temp = 0d;
    Double NaNi = NaN;
    public String val = "";

    Double ans = 0d;


    int invpressed = 0;
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


        pi = fragment.findViewById(R.id.pi);
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

        var.sci_used = true;

        switch (v.getId()) {

            case R.id.pi:

                visualsci();
                if (!var.equalispressed) {
                    if (!var.n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("\u03C0");
                        var.n1isfilled = true;
                    } else if (var.n1isfilled && !n1.getText().toString().equals("\u03C0") && ops.getText().toString().equals(".")) {
                        n1.append("\u03C0");
                        var.n1isfilled = true;
                    } else if (!var.n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("\u03C0");
                        var.n2isfilled = true;


                    } else if (var.n1isfilled && var.n2isfilled && !n2.getText().toString().equals("\u03C0") && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("\u03C0");
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

                    } else if (var.n1isfilled && var.n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("\u03C0");

                    }
                }

                if (!operator2.isShown()) {

                    if(!var.sci_used) ans = var.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                    else if(var.sci_used) ans =result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    if(ans.toString().contains("E"))
                        res.setText(var.ans_setting(ans));

                    else
                        res.setText(ans.toString());;
                } else if (operator2.isShown()) {
                    ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    if(ans.toString().contains("E"))
                        res.setText(var.ans_setting(ans));

                    else
                        res.setText(ans.toString());;
                }
                break;

            case R.id.rad:
                visualsci();
                ++radpressed;
                if (radpressed % 2 != 0) {
                    angleval = "RAD";
                    angle.setText(angleval);
                    rad.setText("DEG");
                } else {
                    angleval = "DEG";
                    angle.setText("DEG");
                    rad.setText("RAD");
                }
                break;

            case R.id.close:

                fl.setVisibility(View.GONE);

                break;

            case R.id.sin:


                visualsci();

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    var.n1isfilled = true;
                }

                if (ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("sin");
                    else
                        ops.setText("(arc)sin");

                    trigo = true;
                    var.sci_ops = true;
                } else if ((var.n1isfilled && var.n2isfilled && !ops.getText().toString().equals("."))) {

                    trigo = true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    if (!isinverse)
                        ops.setText("sin");

                    else ops.setText("(arc)sin");

                    if (!var.equalispressed) {

                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;
                    } else if (var.equalispressed) {
                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;

                        var.f = 1;


                    }
                } else if (!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot") && !ops.getText().toString().equals("sec") && !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos") && !ops.getText().toString().equals("(arc)tan")) && !ops.getText().toString().equals("log") && !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt") && !ops.getText().toString().equals("10^")) {


                    if (!isinverse) {
                        operator2.setText("sin");
                        operator2.setVisibility(View.VISIBLE);
                    } else {
                        operator2.setText("(arc)sin");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }
                break;


            case R.id.cos:

                visualsci();

                if (n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled = true;

                if (ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("cos");
                    else
                        ops.setText("(arc)cos");

                    trigo = true;
                    var.sci_ops = true;
                } else if ((var.n1isfilled && var.n2isfilled && !ops.getText().toString().equals("."))) {

                    trigo = true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    if (!isinverse)
                        ops.setText("cos");

                    else ops.setText("(arc)cos");

                    if (!var.equalispressed) {

                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;
                    } else if (var.equalispressed) {
                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;

                        var.f = 1;

                    }
                } else if (!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot") && !ops.getText().toString().equals("sec") && !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos") && !ops.getText().toString().equals("(arc)tan")) && !ops.getText().toString().equals("log") && !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt") && !ops.getText().toString().equals("10^")) {


                    if (!isinverse) {
                        operator2.setText("cos");
                        operator2.setVisibility(View.VISIBLE);
                    } else {
                        operator2.setText("(arc)cos");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }
                break;


            case R.id.tan:

                visualsci();

                if (n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled = true;

                if (ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("tan");
                    else
                        ops.setText("(arc)tan");

                    var.sci_ops = true;
                    trigo = true;
                } else if ((var.n1isfilled && var.n2isfilled && !ops.getText().toString().equals("."))) {

                    trigo = true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    if (!isinverse)
                        ops.setText("tan");

                    else ops.setText("(arc)tan");

                    if (!var.equalispressed) {

                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;
                    } else if (var.equalispressed) {
                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;

                        var.f = 1;

                    }
                } else if (!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot") && !ops.getText().toString().equals("sec") && !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos") && !ops.getText().toString().equals("(arc)tan")) && !ops.getText().toString().equals("log") && !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt") && !ops.getText().toString().equals("10^")) {


                    if (!isinverse) {
                        operator2.setText("tan");
                        operator2.setVisibility(View.VISIBLE);
                    } else {
                        operator2.setText("(arc)tan");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }
                break;


            case R.id.sec:

                visualsci();

                if (n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled = true;

                if (ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("sec");

                    trigo = true;
                    var.sci_ops = true;

                } else if ((var.n1isfilled && var.n2isfilled && !ops.getText().toString().equals("."))) {

                    trigo = true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    ops.setText("sec");

                    if (!var.equalispressed) {

                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;
                    } else if (var.equalispressed) {
                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;

                        var.f = 1;

                    }
                } else if (!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot") && !ops.getText().toString().equals("sec") && !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos") && !ops.getText().toString().equals("(arc)tan")) && !ops.getText().toString().equals("log") && !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt") && !ops.getText().toString().equals("10^")) {


                    if (!isinverse) {
                        operator2.setText("sec");
                        operator2.setVisibility(View.VISIBLE);
                    }

                }
                break;

            case R.id.cosec:

                visualsci();

                if (n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled = true;

                if (ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("cosec");


                    trigo = true;
                    var.sci_ops = true;
                } else if ((var.n1isfilled && var.n2isfilled && !ops.getText().toString().equals("."))) {

                    trigo = true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    ops.setText("cosec");

                    if (!var.equalispressed) {

                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;
                    } else if (var.equalispressed) {
                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;

                        var.f = 1;

                    }
                } else if (!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot") && !ops.getText().toString().equals("sec") && !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos") && !ops.getText().toString().equals("(arc)tan")) && !ops.getText().toString().equals("log") && !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt") && !ops.getText().toString().equals("10^")) {


                    if (!isinverse) {
                        operator2.setText("cosec");
                        operator2.setVisibility(View.VISIBLE);
                    }

                }
                break;

            case R.id.cot:

                visualsci();

                if (n1.getText().toString().equals("0"))
                    n1.setText("");
                var.n1isfilled = true;

                if (ops.getText().toString().equals(".")) {

                    if (!isinverse)
                        ops.setText("cot");


                    trigo = true;
                    var.sci_ops = true;
                } else if ((var.n1isfilled && var.n2isfilled && !ops.getText().toString().equals("."))) {
                    trigo = true;
                    if (operator2.isShown()) {
                        operator2.setText("");
                        operator2.setVisibility(View.GONE);
                    }

                    ops.setText("cot");

                    if (!var.equalispressed) {

                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;
                    } else if (var.equalispressed) {
                        n1.setText("");
                        var.n1isfilled = true;

                        n2.setText("0");
                        var.n2isfilled = false;

                        var.f = 1;

                    }
                } else if (!ops.getText().toString().equals(".") && (!ops.getText().toString().equals("sin") && !ops.getText().toString().equals("cos") && !ops.getText().toString().equals("tan")
                        && !ops.getText().toString().equals("cot") && !ops.getText().toString().equals("sec") && !ops.getText().toString().equals("cosec") && !ops.getText().toString().equals("(arc)sin")
                        && !ops.getText().toString().equals("(arc)cos") && !ops.getText().toString().equals("(arc)tan")) && !ops.getText().toString().equals("log") && !ops.getText().toString().equals("ln") && !ops.getText().toString().equals("sqrt") && !ops.getText().toString().equals("10^")) {


                    if (!isinverse) {
                        operator2.setText("cot");
                        operator2.setVisibility(View.VISIBLE);
                    }
                }

                break;

            case R.id.inv:
                ++invpressed;
                if (invpressed % 2 != 0) {
                    isinverse = true;
                    inv.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                    sec.setBackgroundColor(getResources().getColor(R.color.not_allowed));
                    cosec.setBackgroundColor(getResources().getColor(R.color.not_allowed));
                    cot.setBackgroundColor(getResources().getColor(R.color.not_allowed));


                } else {
                    isinverse = false;
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
                } else if (!var.n2isfilled && !operator2.getText().toString().equals("")) {
                    operator2.setText("");
                    operator2.setVisibility(View.GONE);
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


                if (!operator2.isShown()) {
                    if (n2.getText().toString().equals("-")) {
                        n2.setText("0");
                        var.n2isfilled = false;
                    }
                    if (!var.sci_used)
                        ans = var.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                    else if (var.sci_used)
                        ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else if (operator2.isShown()) {
                    if (n2.getText().toString().equals("-")) {
                        n2.setText("0");
                        var.n2isfilled = false;
                    }
                    ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                }

                break;


        }

    }


    public Double result(String n1, String n2, String ops, String ops2) {


        if (!ops2.equals("")) {
            String temp = ops2;
            ops2 = ops;
            ops = temp;
        }

        if (n1.equals("\u03C0")) {
            Double PI = Math.PI;
            n1 = PI.toString();
        }

        if (n1.equals("e")) {
            Double E = Math.E;
            n1 = E.toString();
        }

        if (n2.equals("\u03C0")) {
            Double PI = Math.PI;
            n2 = PI.toString();
        }

        if (n2.equals("e")) {
            Double E = Math.E;
            n2 = E.toString();
        }

        if (n2.contains("%")) {

            Double temp = 0d;

            int len = n2.length();

            if (n2.charAt(len - 1) == '%') {
                String val = n2.substring(0, len - 1);

                temp = (Double.parseDouble(val) / 100d) * Double.parseDouble(n1);

                n2 = temp.toString();

            } else if (n2.charAt(len - 1) != '%') {

                int index = n2.indexOf("%");

                String perc = n2.substring(0, (index));  // getting percentage
                String num = n2.substring(index + 1, len);  // getting number to process

                temp = Double.parseDouble(perc) / 100d * Double.parseDouble(num);

                n2 = temp.toString();

            }
        }

        if(n2.contains("e")){


            if(n2.charAt(0) == 'e'){
                res.setText("Syntax Error");
                return Double.parseDouble(n1);
            }

            int len = n2.length();

            int index = n2.indexOf("e");

            String num = n2.substring(0, (index));  // getting percentage
            String pow = n2.substring(index + 1, len);  // getting number to process

            if(!pow.equals(""))
                temp = Double.parseDouble(num) * Math.pow(10d,Double.parseDouble(pow));

            else
                temp = Double.parseDouble(num)*Math.E;

            n2 = temp.toString();

        }

        if(n2.contains("\u03C0")){


            if(n2.charAt(0) == '\u03C0'){
                res.setText("Syntax Error");
                return Double.parseDouble(n1);
            }

            int len = n2.length();

            int index = n2.indexOf("\u03C0");

            String num = n2.substring(0, (index));  // getting percentage


            temp = Double.parseDouble(num)*Math.round(Math.PI*1000000.0)/1000000.0;

            n2 = temp.toString();

        }
        if (n2.contains("^")) {

            int len = n2.length();

            int index = n2.indexOf("^");

            String num = n2.substring(0, (index));  // getting percentage
            String pow = n2.substring(index + 1, len);  // getting number to process

            if (!pow.equals(""))

                temp = Math.pow(Double.parseDouble(num), Double.parseDouble(pow));

            else
                temp = Double.parseDouble(num);

            n2 = temp.toString();

        }


        switch (ops) {
            case "sin":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2))) :
                                java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!ops2.equals("")) {

                        temp = java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }
                    if (!ans.equals(NaNi)) {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else {
                        res.setText("Nani");
                        return NaN;
                    }

                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.sin((Double.parseDouble(n2))) :
                                java.lang.Math.sin((Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {

                        temp = java.lang.Math.sin((Double.parseDouble(n2)));    // calculating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }


                }

                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
                break;

            case "cos":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2))) :
                                java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!ops2.equals("")) {

                        temp = java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }
                    if (!ans.equals(NaNi)) {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else {
                        res.setText("Nani");
                        return NaN;
                    }
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.cos((Double.parseDouble(n2))) :
                                java.lang.Math.cos((Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {

                        temp = java.lang.Math.cos((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }


                }

                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
                break;

            case "tan":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {

                        if(n2.equals("90"))
                            return NaN;

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2))) :
                                java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!ops2.equals("")) {

                        temp = java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }
                    if (!ans.equals(NaNi)) {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else {
                        res.setText("Nani");
                        return NaN;
                    }
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.tan((Double.parseDouble(n2))) :
                                java.lang.Math.tan((Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {

                        temp = java.lang.Math.tan((Double.parseDouble(n2)));    // calculating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }


                }
                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }

                break;

            case "sec":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {

                        if(n2.equals("90"))
                            return NaN;

                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)))) :
                                1d / java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!ops2.equals("")) {

                        temp = 1d / java.lang.Math.cos(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }
                    if (!ans.equals(NaNi)) {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else {
                        res.setText("Nani");
                        return NaN;
                    }
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.cos((Double.parseDouble(n2)))) :
                                1d / java.lang.Math.cos((Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {

                        temp = 1d / java.lang.Math.cos((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }


                }

                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
                break;


            case "cosec":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {

                        if(n2.equals("0"))
                            return NaN;
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)))) :
                                1d / java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!ops2.equals("")) {

                        temp = 1d / java.lang.Math.sin(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }
                    if (!ans.equals(NaNi)) {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else {
                        res.setText("Nani");
                        return NaN;
                    }
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.sin((Double.parseDouble(n2)))) :
                                1d / java.lang.Math.sin((Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {

                        temp = 1d / java.lang.Math.sin((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }


                }
                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
                break;
            case "cot":
                if (angleval.equals("DEG")) {

                    if (ops2.equals("")) {

                        if(n2.equals("0"))
                            return NaN;

                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)))) :
                                1d / java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!ops2.equals("")) {

                        temp = 1d / java.lang.Math.tan(Math.toRadians(Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }
                    if (!ans.equals(NaNi)) {
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else {
                        res.setText("Nani");
                        return NaN;
                    }
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {
                        ans = !n1.equals("") ? Double.parseDouble(n1) * (1d / java.lang.Math.tan((Double.parseDouble(n2)))) :
                                1d / java.lang.Math.tan((Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {

                        temp = 1d / java.lang.Math.tan((Double.parseDouble(n2)));    // calcuating the sin result

                        ans = var.result(n1, temp.toString(), ops2);   // passing to the parent activity result function

                    }


                }

                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
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
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.asin(Double.parseDouble(n2)) :
                                (java.lang.Math.asin(Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = (java.lang.Math.asin(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
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
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.acos(Double.parseDouble(n2)) :
                                (java.lang.Math.acos(Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = (java.lang.Math.acos(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
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
                } else if (angleval.equals("RAD")) {

                    if (ops2.equals("")) {

                        ans = !n1.equals("") ? Double.parseDouble(n1) * java.lang.Math.atan(Double.parseDouble(n2)) :
                                (java.lang.Math.atan(Double.parseDouble(n2)));
                    } else if (!ops2.equals("")) {
                        temp = (java.lang.Math.atan(Double.parseDouble(n2)));
                        ans = var.result(n1, temp.toString(), ops2);
                    }

                }
                if (!ans.equals(NaNi)) {
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {
                    res.setText("Nani");
                    return NaN;
                }
                break;

            case "sqrt":

                if (Double.parseDouble(n2) < 0) {
                    res.setText("NaNi");
                    return NaN;
                }


                temp = java.lang.Math.sqrt(Double.parseDouble(n2));
                val = temp.toString();

                ans = var.result(n1, val, ops2);

                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "log":
                if (Double.parseDouble(n2) <= 0) {
                    res.setText("NaNi");
                    return NaN;
                }


                temp = java.lang.Math.log10(Double.parseDouble(n2));
                val = temp.toString();

                ans = var.result(n1, temp.toString(), ops2);
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "ln":
                if (Double.parseDouble(n2) <= 0) {
                    res.setText("NaNi");
                    return NaN;
                }

                temp = java.lang.Math.log(Double.parseDouble(n2));

                ans = var.result(n1, temp.toString(), ops2);
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            case "10^":
                temp = java.lang.Math.pow(10d, Double.parseDouble(n2));
                val = temp.toString();
                ans = var.result(n1, val, ops2);
                ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                res.setText(ans.toString());
                break;

            default:
                ans = var.result(n1, n2, ops);
        }


        return ans;

    }


    private void visualsci() {

        var.calc.setVisibility(View.VISIBLE);
        var.angle.setVisibility(View.VISIBLE);
    }
}