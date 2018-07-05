package com.apps.kunalfarmah.kalculator;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Scientific scientific = new Scientific();

    TextView res;
    TextView n1;
    TextView ops;
    TextView n2;
    TextView angle;
    TextView operator2;
    FrameLayout fl;
    FrameLayout frag;


    AboutFragment about = new AboutFragment();
    UsageFragment usage = new UsageFragment();


    boolean sci_used = false;
    boolean n1isfilled = false;
    boolean n2isfilled = false;
    boolean equalispressed = false;
    boolean sci_ops = false;
    int f = 0;
    int g = 0;
    int eq = 0;
    String oldops;

    public Double temp = 0d;
    public String val = "";


    Double ans_d = 0d;
    Integer ans_i = 0;
    Double ans = 0d;


    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b0;
    Button close;

    Button pi;
    Button add;
    Button sub;
    Button mul;
    Button div;
    Button perc;
    Button sq;
    Button sqrt;
    Button pow;
    Button rem;
    Button C;
    Button ln;
    Button log;
    ImageButton back;
    Button dot;
    Button equals;
    Button extra;
    Button e;
    Button pow10;


    LinearLayout calc;


//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        setContentView(R.layout.activity_main);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        calc = (LinearLayout) findViewById(R.id.display);

        fl = findViewById(R.id.scibuttons);
        frag = findViewById(R.id.frag);


        res = (TextView) findViewById(R.id.result);
        n1 = (TextView) findViewById(R.id.n1);
        ops = (TextView) findViewById(R.id.operator);
        operator2 = (TextView) findViewById(R.id.operator2);
        n2 = (TextView) findViewById(R.id.n2);
        angle = (TextView) findViewById(R.id.angle);


        b1 = findViewById(R.id.num1);
        b1.setOnClickListener(this);
        b2 = findViewById(R.id.num2);
        b2.setOnClickListener(this);
        b3 = findViewById(R.id.num3);
        b3.setOnClickListener(this);
        b4 = findViewById(R.id.num4);
        b4.setOnClickListener(this);
        b5 = findViewById(R.id.num5);
        b5.setOnClickListener(this);
        b6 = findViewById(R.id.num6);
        b6.setOnClickListener(this);
        b7 = findViewById(R.id.num7);
        b7.setOnClickListener(this);
        b8 = findViewById(R.id.num8);
        b8.setOnClickListener(this);
        b9 = findViewById(R.id.num9);
        b9.setOnClickListener(this);
        b0 = findViewById(R.id.num0);
        b0.setOnClickListener(this);
        extra = findViewById(R.id.sci1);
        extra.setOnClickListener(this);


        pi = findViewById(R.id.pi);
        pi.setOnClickListener(this);
        add = findViewById(R.id.add);
        add.setOnClickListener(this);
        sub = findViewById(R.id.sub);
        sub.setOnClickListener(this);
        mul = findViewById(R.id.mul);
        mul.setOnClickListener(this);
        div = findViewById(R.id.div);
        div.setOnClickListener(this);
        perc = findViewById(R.id.perc);
        perc.setOnClickListener(this);
        rem = findViewById(R.id.rem);
        rem.setOnClickListener(this);
        sqrt = findViewById(R.id.sqrt);
        sqrt.setOnClickListener(this);
        ln = findViewById(R.id.ln);
        ln.setOnClickListener(this);
        log = findViewById(R.id.log);
        log.setOnClickListener(this);
        back = findViewById(R.id.backsp);
        back.setOnClickListener(this);
        C = findViewById(R.id.c);
        C.setOnClickListener(this);
        pow = findViewById(R.id.pow);
        pow.setOnClickListener(this);
        dot = findViewById(R.id.numdot);
        dot.setOnClickListener(this);
        equals = findViewById(R.id.equals);
        equals.setOnClickListener(this);
        e = findViewById(R.id.e);
        e.setOnClickListener(this);
        pow10 = findViewById(R.id.pow10);
        pow10.setOnClickListener(this);


        getSupportFragmentManager().beginTransaction().add(R.id.scibuttons, scientific).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.howtouse) {
            frag.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.frag, usage).addToBackStack("usage").commit();
            return true;
        }

        if (id == R.id.about) {
            frag.setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction().add(R.id.frag, about).addToBackStack("about").commit();
            return true;
        }

        return true;
    }


   /* @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"onResume",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"onPause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"onrRstart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"onStop",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"onDestroy",Toast.LENGTH_SHORT).show();
    }
*/

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.sci1:

                fl.setVisibility(View.VISIBLE);


                break;

            case R.id.num0:

                visual();

                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("0");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("0");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("0");
                        n2isfilled = true;
                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");

                        if (!operator2.isShown()) {

                            if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());
                        }

                        //res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                        else if (operator2.isShown()) {
                            ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());
                        }

                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("0");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("0");

                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("0");
                        n2isfilled = true;
                        if(ops.getText().toString().equals("/")) {
                            res.setText("NaNi");
                            break;
                        }
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");
                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }

                }

                break;

            case R.id.pi:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("\u03C0");
                        n1isfilled = true;

//                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
//                        n1.append("\u03C0");
//                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("\u03C0");
                        n2isfilled = true;
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


//                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
//                            ) {
//                        n2.append("\u03C0");
//                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("\u03C0");
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("\u03C0");

                    } else if (n1isfilled && !n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("\u03C0");
                        n2isfilled = true;
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("\u03C0");

                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                }
                break;


            case R.id.e:

                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("e");
                        n1isfilled = true;

                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        ops.setText("e");

                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("e");
                        n2isfilled = true;
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals(".") && !(ops.getText().toString().equals("e")))) {
                        n2.append("e");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                    if (!operator2.isShown() && n2.length()>=3)
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    else if (operator2.isShown() && n2.length()>=3)
                        res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("e");
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        ops.setText("e");

                    } else if (n1isfilled && !n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("e");
                        n2isfilled = true;
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals(".") && !(ops.getText().toString().equals("e")))) {
                        n2.append("e");

                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown() && n2.length()>=3)
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    else if (operator2.isShown() && n2.length()>=3)
                        res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                }

                break;


            case R.id.num1:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("1");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("1");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("1");
                        n2isfilled = true;
                        //    res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("1");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("1");
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("1");

                    } else if (n1isfilled && !n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("1");
                        n2isfilled = true;
                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("1");

                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }
                break;

            case R.id.num2:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("2");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("2");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("2");
                        n2isfilled = true;
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("2");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("2");
                        f = 1;
                        n1isfilled = true;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("2");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("2");
                        n2isfilled = true;
                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("2");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }

                break;

            case R.id.num3:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("3");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("3");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("3");
                        n2isfilled = true;
                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("3");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }

                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("3");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("3");
                        n1isfilled = true;
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("3");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("3");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }

                break;

            case R.id.num4:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("4");

                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("4");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("4");
                        n2isfilled = true;
//                        if (!n2.getText().toString().contains("%"))
//                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("4");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used)  ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("4");
                        f = 1;
                        n1isfilled = true;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("4");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("4");
                        n2isfilled = true;
//                        if (!n2.getText().toString().contains("%"))
//                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("4");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }
                f = 0;
                break;


            case R.id.num5:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("5");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("5");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("5");
                        n2isfilled = true;
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("5");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("5");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("5");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("5");
                        n2isfilled = true;


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("5");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }

                break;


            case R.id.num6:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("6");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("6");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("6");
                        n2isfilled = true;
                        //  res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("6");
                        //  res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("6");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("6");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("6");
                        n2isfilled = true;
                        //      res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("6");
                        //  res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }

                break;

            case R.id.num7:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("7");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("7");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("7");
                        n2isfilled = true;
                        //     res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("7");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }


                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("7");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("7");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("7");
                        n2isfilled = true;
                        //     res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("7");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }

                break;


            case R.id.num8:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("8");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("8");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("8");
                        //    res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("8");
                        //res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                } else if (equalispressed) {
                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("8");
                        n1isfilled = true;
                        f = 1;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("8");
                        n1isfilled = true;

                    } else if (!n2isfilled && !ops.getText().toString().equals(".") && f == 1) {
                        n2.setText("8");
                        n2isfilled = true;
                        //   res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("8");
                        //  res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                }

                break;

            case R.id.num9:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("9");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("9");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("9");
                        n2isfilled = true;
//                        if (operator2.equals(""))
//                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("9");
                        //  if(operator2.equals("")) res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    }
                    if (!operator2.isShown() ) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (!operator2.getText().toString().equals("") ) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }
                } else if (equalispressed) {


                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0 && g == 0) {
                        n1.setText("9");
                        f = 1;
                        //n1isfilled=true;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("9");
//                        n1isfilled = true;
                    } else if (!n2isfilled && !(ops.getText().toString().equals(".")) && f == 1) {
                        n2.setText("9");
                        n2isfilled = true;
//                        if (operator2.equals(""))
//                            res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("9");
                        //  if(operator2.equals("")) res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


//                    } else if (g == 1) {
//                        if (!n2isfilled) {
//                            n2.setText("9");
//                            n2isfilled = true;
//                        }
//                        if (n2isfilled)
//                            n2.append("9");
//
//                    }
//
//                    g = 0;
                    }

                    if (!operator2.isShown()) {

                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    } else if (operator2.isShown()) {
                        ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                        ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                        res.setText(ans.toString());
                    }

                }


                break;

            case R.id.numdot:
                visual();
                if (!equalispressed) {
                    if (!n1isfilled && ops.getText().toString().equals(".")) {
                        n1.setText("0");
                        n1.append(".");
                        n1isfilled = true;
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append(".");
                        n1isfilled = true;
                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("0");
                        n2.append(".");
                        n2isfilled = true;
                        //     res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append(".");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown())
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    else if (operator2.isShown())
                        res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                } else if (equalispressed) {


                    if (n1isfilled && !ops.getText().toString().equals(".") && f == 0) {
                        n1.setText("0");
                        n1.append(".");
                        f = 1;

                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append(".");

                    } else if (!n2isfilled && !(ops.getText().toString().equals(".")) && f == 1) {
                        n2.setText("0");
                        n2.append(".");

                        n2isfilled = true;
                        //  res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append(".");
                        // res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }

                    if (!operator2.isShown())
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    else if (operator2.isShown())
                        res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());

                }

                break;


            case R.id.add:
                visual();


                oldops = ops.getText().toString();
                ops.setText("+");

                if (!n1isfilled && !sci_ops) {
                    n1.setText("0");
                    n1isfilled=true;
                }

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    n1.setText(res.getText().toString());
                    ops.setText("+");
                    n2.setText("0");
                    n2isfilled = false;
                    f = 1;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {
                    ans = result(n1.getText().toString(), n2.getText().toString(), oldops);

                    ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                    n1.setText(ans.toString());
                    n1isfilled = true;
                    ops.setText("+");
                    n2.setText("0");

                    n2isfilled = false;
                }

                // for case sin(x)+n

                else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
//                    double ans_final = ans.doubleValue();
//                    String foo = String .format("%.4f",ans_final);
//                    n1.setText(foo);
                    ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                    n1.setText(ans.toString());
                    n1isfilled = true;
                    ops.setText("+");
                    n2.setText("0");
                    n2isfilled = false;

                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                }


                break;

            case R.id.sub:

                visual();


                oldops = ops.getText().toString();


                if (!n1isfilled && scientific.invpressed % 2 == 0) {
                    ops.setText("-");
                    n1.setText("0");
                    n1isfilled=true;

                } else if (n1isfilled && ops.getText().toString().equals(".") && !sci_used) {
                    ops.setText("-");
                    n2.setText("0");
                    break;
                }

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    n1.setText(res.getText().toString());
                    ops.setText("-");
                    n2.setText("0");
                    n2isfilled = false;
                    f = 1;
                } else if ((!n1.getText().toString().equals("0") && (n2.getText().toString().equals("0") || n2.getText().toString().equals("")) && ((!ops.getText().toString().equals(".") && !sci_ops) || ((!operator2.getText().equals("")) && sci_ops)) || scientific.invpressed % 2 != 0)) {

                    n2.setText("-");
                    n2isfilled = true;
                    break;
                } else if (n1.getText().toString().equals("") && n2.getText().toString().equals("0") && scientific.trigo) {
                    n2.setText("-");
                    n2isfilled = true;
                    scientific.trigo = false;
                    break;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {
                    ans = result(n1.getText().toString(), n2.getText().toString(), oldops);

                    ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                    n1.setText(ans.toString());
                    n1isfilled = true;
                    ops.setText("-");
                    n2.setText("0");

                    n2isfilled = false;
                }

                // for case sin(x)+n

                else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
//                    double ans_final = ans.doubleValue();
//                    String foo = String .format("%.4f",ans_final);
//                    n1.setText(foo);
                    ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                    n1.setText(ans.toString());
                    n1isfilled = true;
                    ops.setText("-");
                    n2.setText("0");
                    n2isfilled = false;

                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                }


                break;

            case R.id.mul:
                visual();
                oldops = ops.getText().toString();

                ops.setText("X");
                if (!n1isfilled) {
                    n1.setText("");
                    res.setText("Syntax Error");

                }

                if (equalispressed && !n2.getText().toString().equals("0")) {
                    n1.setText(res.getText().toString());
                    ops.setText("X");
                    n2.setText("0");
                    n2isfilled = false;
                    f = 1;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {
//                    if(oldops.equals("+") || oldops.equals("-"))
                    ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    ops.setText("X");
                    n2.setText("");
                    n2isfilled = false;
                } else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
//                    double ans_final = ans.doubleValue();
//                    String foo = String .format("%.4f",ans_final);
//                    n1.setText(foo);
                    ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                    n1.setText(ans.toString());
                    n1isfilled = true;
                    ops.setText("X");
                    n2.setText("0");
                    n2isfilled = false;
                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                    scientific.trigo = false;
                }

                break;

            case R.id.div:
                visual();

                oldops = ops.getText().toString();
                ops.setText("/");
                if (!n1isfilled) {
                    n1.setText("");
                    res.setText("Syntax Error");


                }
                if (equalispressed && !n2.getText().toString().equals("0")) {
                    n1.setText(res.getText().toString());
                    ops.setText("/");
                    n2.setText("0");
                    n2isfilled = false;
                    f = 1;
                } else if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !sci_ops)
                        ) {


                    ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    ops.setText("/");
                    n2.setText("");
                    n2isfilled = false;
                } else if (sci_ops) {
                    //   n1.setText("");
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), oldops, operator2.getText().toString());
//                    double ans_final = ans.doubleValue();
//                    String foo = String .format("%.4f",ans_final);
//                    n1.setText(foo);
                    ans = Math.round(ans.doubleValue() * 100.0) / 100.0;
                    n1.setText(ans.toString());
                    ops.setText("/");
                    n2.setText("0");
                    n2isfilled = false;
                    eq = 1;
                    // resetting the scientific state
                    sci_ops = false;
                }

                break;

            case R.id.perc:
                if (!n1isfilled) {
                    res.setText("Syntax Error");
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    ops.setText("%");
                } else if (n1isfilled && n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.append("%");
                }

                if (!operator2.isShown())
                    res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                else if (operator2.isShown())
                    res.setText(scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString()).toString());


                break;

            case R.id.sqrt:

                scientific.trigo=true;


                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;

                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("sqrt");
                    sci_ops = true;

                } else if (!ops.getText().toString().equals(".") && !ops.getText().toString().equals("sqrt")) {

                    sci_used = true;
                    operator2.setText("sqrt");
                    operator2.setVisibility(View.VISIBLE);

                }


                break;

            case R.id.rem:
                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();
                ops.setText("REM");

                break;

            case R.id.pow:
                visual();

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                    n2.setText("");
                }


                ops.setText("^");
                n2.setText("");
                break;

            case R.id.pow10:

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("10^");

                } else if (!ops.getText().toString().equals(".") && !ops.getText().toString().equals("10^")) {

                    sci_used = true;
                    operator2.setText("10^");
                    operator2.setVisibility(View.VISIBLE);

                }
                break;


            case R.id.log:

                scientific.trigo=true;

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("log");
                    sci_ops = true;

                } else if (!ops.getText().toString().equals(".") && !ops.getText().toString().equals("log")) {

                    sci_used = true;
                    operator2.setText("log");
                    operator2.setVisibility(View.VISIBLE);

                }
                break;


            case R.id.ln:

                scientific.trigo=true;

                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = true;
                }

                visual();

                if (ops.getText().toString().equals(".")) {


                    ops.setText("ln");
                    sci_ops = true;

                } else if (!ops.getText().toString().equals(".") && !ops.getText().toString().equals("ln")) {

                    sci_used = true;
                    operator2.setText("ln");
                    operator2.setVisibility(View.VISIBLE);

                }

                break;

            case R.id.backsp:
                visual();

                if (n2isfilled) {

                    String str = n2.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);      //deleting 1 element with every touch
                        n2.setText(str);
                    } else if (str.length() <= 1) {
                        n2.setText("0");
                        n2isfilled = false;
                    }


                } else if (!n2isfilled && !operator2.getText().toString().equals("")) {
                    operator2.setText("");
                    operator2.setVisibility(View.GONE);
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    ops.setText(".");

                } else if (!n2isfilled && ops.getText().toString().equals(".") && n1isfilled) {
                    String str = n1.getText().toString();
                    if (str.length() > 1) {
                        str = str.substring(0, str.length() - 1);
                        n1.setText(str);
                    } else if (str.length() <= 1) {
                        n1.setText("0");
                        n1isfilled = false;
                    }
                } else if (!n1isfilled && !n2isfilled) {
                    n1.setText("0");
                    n2.setText("0");
                }


                if (!operator2.isShown()) {
                    if(n2.getText().toString().equals("-")) {
                        n2.setText("0");
                        n2isfilled = false;
                    }
                    if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                    else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else if (operator2.isShown()) {
                    if(n2.getText().toString().equals("-")) {
                        n2.setText("0");
                        n2isfilled = false;
                    }
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                }




                break;


            case R.id.equals:

                Double ans = 0d;
                calc.setVisibility(View.GONE);
                angle.setVisibility(View.GONE);
                //res.setTextSize(55f);

                // if we r using scientific calculator or have 2 operators nested, use the fragment's result method
                if ((sci_used || operator2.isShown()) && eq != 1) {
                    ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(), operator2.getText().toString());
                    ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                    res.setText(ans.toString());
                } else {

                    if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        if(!sci_used) ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                        else if(sci_used) ans = scientific.result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString(),operator2.getText().toString());
                        if (ans != -999999999d) {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText(ans.toString());
                        } else {
                            ans = Math.round(ans.doubleValue() * 1000000.0) / 1000000.0;
                            res.setText("NaNi");
                        }
                    } else if (!n2isfilled) {
                        res.setText(n1.getText().toString());

                    } else if (!n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        res.setText(n2.getText().toString());
                    }

//                    } else if (!n2isfilled && !n1isfilled)
//                        res.setText("0");
                }

                equalispressed = true;
                f = 0;
                sci_used = false;
                sci_ops = false;
                eq = 0;

//                ops.setText(".");
//                n1.setText("");
//               // n1isfilled=true;
//                n2.setText("");

                operator2.setText("");
                operator2.setVisibility(View.GONE);


                break;


            case R.id.c:
                resetall();
                equalispressed = false;
                break;
        }


        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                resetall();
                equalispressed = false;
                return true;
            }
        });
    }


    Double result(String n1, String n2, String ops) {

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

            int len = n2.length();

            int index = n2.indexOf("e");

            String num = n2.substring(0, (index));  // getting percentage
            String pow = n2.substring(index + 1, len);  // getting number to process

            temp = Double.parseDouble(num) * Math.pow(10d,Double.parseDouble(pow));

            n2 = temp.toString();

        }


        switch (ops) {

            case "+":
                // if (!n1.contains(".") && !n2.contains("."))
                //  ans_i = Integer.parseInt(n1) + Integer.parseInt(n2);
                ///  else
                ans_d = Double.parseDouble(n1) + Double.parseDouble(n2);

                break;
            case "-":
                //  if (!n1.contains(".") && !n2.contains("."))
                //   ans_i = Integer.parseInt(n1) - Integer.parseInt(n2);
                //  else
                ans_d = Double.parseDouble(n1) - Double.parseDouble(n2);

                break;
            case "X":
                //  if (!n1.contains(".") && !n2.contains("."))
                //      ans_i = Integer.parseInt(n1) * Integer.parseInt(n2);
                //   else
                ans_d = Double.parseDouble(n1) * Double.parseDouble(n2);

                break;

            case "/":
                if (!n2.equals("0")) {

                    ans_d = Double.parseDouble(n1) / Double.parseDouble(n2);
                } else ans_d = -999999999d;
                break;


            case "REM":
//                if (!n1.contains(".") && !n2.contains("."))
//                    ans_i = Integer.parseInt(n1) % Integer.parseInt(n2);
//                else
                ans_d = Double.parseDouble(n1) % Double.parseDouble(n2);

                break;

            case "sqrt":

                if(Integer.parseInt(n2)<0){
                    res.setText("NaNi");
                    break;
                }


                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.sqrt(Double.parseDouble(n2)))
                        : java.lang.Math.sqrt(Double.parseDouble(n2));
                break;

            case "log":

                if(Integer.parseInt(n2)<0){
                    res.setText("NaNi");
                    break;
                }

                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.log10(Double.parseDouble(n2)))
                        : java.lang.Math.log10(Double.parseDouble(n2));
                break;

            case "ln":

                if(Integer.parseInt(n2)<0){
                    res.setText("NaNi");
                    break;
                }

                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.log(Double.parseDouble(n2)))
                        : java.lang.Math.log(Double.parseDouble(n2));
                break;

            case "^":
//                if (!n1.contains(".") && n2.contains("."))
//                    ans_i = (int) java.lang.Math.pow(Double.parseDouble(n1), Double.parseDouble(n2));

                //   else
                ans_d = java.lang.Math.pow(Double.parseDouble(n1), Double.parseDouble(n2));
                break;

            case "e":

//                if (!n1.contains(".") && n2.contains("."))
//                    ans_i = (int)(Integer.parseInt(n1)* java.lang.Math.pow(10d, Double.parseDouble(n2)));
//
//                else
                ans_d = Double.parseDouble(n1) * java.lang.Math.pow(10d, Double.parseDouble(n2));
                break;

            case "10^":

                ans_d = java.lang.Math.pow(10d, Double.parseDouble(n2));
                break;

            case "%":
                if (!n2isfilled) {
                    ans_d = Double.parseDouble(n1) / 100d;
                } else if (n2isfilled && !n2.contains("%")) {
                    ans_d = (Double.parseDouble(n1) / 100d) * Double.parseDouble(n2);
                }

                break;


//            default:  // if nothing matches go to the fragments function
//                scientific.result(n1, n2, ops, operator2.getText().toString());

        }

        if(ans_d < -9E12)
            ans_d = -999999d;
        return (ans_i != 0 ? ans_i : ans_d);

    }


    void reset() {

        ops.setText(".");
        n2.setText("0");
        n2isfilled = false;
    }

    void resetall() {

//        if (n1isfilled) {
        n1.setText("0");
        n1isfilled = false;
//        }

//         if (n2isfilled) {
        n2.setText("0");
        n2isfilled = false;
//        }

//        if (!ops.getText().toString().equals("."))
        ops.setText(".");

        res.setText("0");

        if (operator2.getVisibility() == View.VISIBLE) {
            operator2.setText("");
            operator2.setVisibility(View.GONE);
        }

        sci_used = false;
        sci_ops = false;


    }


    void visual() {
       /* //res.setTextSize(45f);
        n1.setText("0");
        n1isfilled=false;
        ops.setText(".");
        n2.setText("0");
        n2isfilled=false;*/

        calc.setVisibility(View.VISIBLE);
        angle.setVisibility(View.VISIBLE);
//        if (operator2.isShown()) {
//            operator2.setText("");
//            operator2.setVisibility(View.GONE);
//        }

    }
}