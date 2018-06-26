package com.example.kunalfarmah.kalculator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Gravity;
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
    FrameLayout fl;

    boolean framelayoutisvisible = false;

    boolean n1isfilled = false;
    boolean n2isfilled = false;
    boolean equalispressed = false;
    int f = 0;
    int g = 0;
    String oldops;

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


    LinearLayout calc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        calc = (LinearLayout) findViewById(R.id.display);

        fl = findViewById(R.id.scibuttons);


        res = (TextView) findViewById(R.id.result);
        n1 = (TextView) findViewById(R.id.n1);
        ops = (TextView) findViewById(R.id.operator);
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
        sq = findViewById(R.id.square);
        sq.setOnClickListener(this);
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


        getSupportFragmentManager().beginTransaction().add(R.id.scibuttons, scientific).commit();

//        if (!framelayoutisvisible) {
//            getSupportFragmentManager().beginTransaction().remove(scientific);
//        }


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.sci_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.sci1:

                fl.setVisibility(View.VISIBLE);
//                framelayoutisvisible = true;
                //adding the fragment to the frame layout


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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("1");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("1");

                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("2");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("2");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("3");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("4");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("4");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("5");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("5");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("6");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("6");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("7");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("7");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("8");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("8");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("9");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());


                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("9");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (g == 1) {
                        if (!n2isfilled) {
                            n2.setText("9");
                            n2isfilled = true;
                        }
                        if (n2isfilled)
                            n2.append("9");

                    }

                    g = 0;

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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append(".");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
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
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append(".");
                        res.setText(result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString()).toString());
                    }
                }

                break;


            case R.id.add:
                visual();
                if (!n1isfilled)
                    n1.setText("0");
                oldops = ops.getText().toString();
                ops.setText("+");

                if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) || equalispressed)
                        ) {
                    Double ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    ops.setText("+");
                    n2.setText("0");
                    n2isfilled = false;
                }


                break;

            case R.id.sub:

                if (!n1isfilled)
                    n1.setText("");
                oldops = ops.getText().toString();
                ops.setText("-");

                if ((n1isfilled && n2isfilled && !(ops.getText().toString().equals(".")) && !equalispressed)
                        ) {
                    Double ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    ops.setText("-");
                    n2.setText("0");
                    n2isfilled = false;
                } else if (equalispressed && !calc.isShown()) {
                    g = 1;
                    Double ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    n1isfilled = true;
                    ops.setText("-");
                    n2.setText("0");
                    n2isfilled = false;
                    visual();
                }


                break;

            case R.id.mul:
                visual();
                if (!n1isfilled)
                    n1.setText("0");
                oldops = ops.getText().toString();
                ops.setText("X");

                if (n1isfilled && n2isfilled && !(ops.getText().toString().equals(".") && !equalispressed)
                        ) {
//                    if(oldops.equals("+") || oldops.equals("-"))
                    Double ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    ops.setText("X");
                    n2.setText("");
                    n2isfilled = false;
                }


                break;

            case R.id.div:
                visual();
                if (!n1isfilled)
                    n1.setText("0");
                oldops = ops.getText().toString();
                ops.setText("/");

                if (n1isfilled && n2isfilled && !(ops.getText().toString().equals(".") && !equalispressed)
                        ) {


                    Double ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
                    n1.setText(ans.toString());
                    ops.setText("/");
                    n2.setText("");
                    n2isfilled = false;
                }


                break;

            case R.id.perc:
                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = false;
                }
                visual();
                if (!n1isfilled)
                    throw new ArithmeticException("Please supply an argument");
                else
                    ops.setText("%");
                break;


            case R.id.sqrt:
                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = false;
                }
                visual();

                ops.setText("sqrt");


                break;

            case R.id.rem:
                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = false;
                }
                visual();

                ops.setText("REM");

            case R.id.log:
                visual();
                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = false;
                }

                ops.setText("log");


                break;


            case R.id.ln:
                visual();
                if (n1.getText().toString().equals("0")) {
                    n1.setText("");
                    n1isfilled = false;
                }

                ops.setText("ln");


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

                break;


            case R.id.equals:

                Double ans;
                calc.setVisibility(View.GONE);
                angle.setVisibility(View.GONE);
                res.setTextSize(60f);


                if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
                    if (ans != -999999999d)
                        res.setText(ans.toString());
                    else
                        res.setText("NaNi");
                } else if (!n2isfilled) {
                    res.setText(n1.getText().toString());

                } else if (!n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    res.setText(n2.getText().toString());

                } else if (!n2isfilled && !n1isfilled)
                    res.setText("0");

                equalispressed = true;
                f = 0;
                break;


            case R.id.c:
                resetall();
        }


        back.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                resetall();
                return true;
            }
        });
    }


    Double result(String n1, String n2, String ops) {

        Double ans_d = 0d;
        Integer ans_i = 0;


        switch (ops) {

            case "+":
                if (!n1.contains(".") && !n2.contains("."))
                    ans_i = Integer.parseInt(n1) + Integer.parseInt(n2);
                else
                    ans_d = Double.parseDouble(n1) + Double.parseDouble(n2);

                break;
            case "-":
                if (!n1.contains(".") && !n2.contains("."))
                    ans_i = Integer.parseInt(n1) - Integer.parseInt(n2);
                else
                    ans_d = Double.parseDouble(n1) - Double.parseDouble(n2);

                break;
            case "X":
                if (!n1.contains(".") && !n2.contains("."))
                    ans_i = Integer.parseInt(n1) * Integer.parseInt(n2);
                else
                    ans_d = Double.parseDouble(n1) * Double.parseDouble(n2);

                break;

            case "/":
                if (!n2.equals("0")) {

                    ans_d = Double.parseDouble(n1) / Double.parseDouble(n2);
                } else ans_d = -999999999d;
                break;


            case "REM":
                if (!n1.contains(".") && !n2.contains("."))
                    ans_i = Integer.parseInt(n1) % Integer.parseInt(n2);
                else
                    ans_d = Double.parseDouble(n1) % Double.parseDouble(n2);

                break;

            case "sqrt":

                    ans_d = Double.parseDouble(n1) * (java.lang.Math.sqrt(Double.parseDouble(n2)));
                break;

            case "log":
                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.log10(Double.parseDouble(n2)))
                        : java.lang.Math.log10(Double.parseDouble(n2));
                break;

            case "ln":
                ans_d = !n1.equals("") ? Double.parseDouble(n1) * (java.lang.Math.log(Double.parseDouble(n2)))
                        : java.lang.Math.log(Double.parseDouble(n2));
                break;


        }
        return (ans_i != 0 ? ans_i : ans_d);

    }


    void reset() {

        ops.setText(".");
        n2.setText("0");
        n2isfilled = false;
    }

    void resetall() {

        if (n1isfilled) {
            n1.setText("0");
            n1isfilled = false;
        }

        if (n2isfilled) {
            n2.setText("0");
            n2isfilled = false;
        }

        if (!ops.getText().toString().equals("."))
            ops.setText(".");

        res.setText("0");
    }


    void visual() {
        res.setTextSize(50f);
        calc.setVisibility(View.VISIBLE);
        angle.setVisibility(View.VISIBLE);
    }
}



