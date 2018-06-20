package com.example.kunalfarmah.kalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView res;
    TextView n1;
    TextView ops;
    TextView n2;

    boolean n1isfilled = false;
    boolean n2isfilled = false;
    boolean equalispressed = false;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        res = (TextView) findViewById(R.id.result);
        n1 = (TextView) findViewById(R.id.n1);
        ops = (TextView) findViewById(R.id.operator);
        n2 = (TextView) findViewById(R.id.n2);


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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {

            case R.id.num0:

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

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");
                    }
                }
                else if(equalispressed){
                    if (n1isfilled && !ops.getText().toString().equals(".")) {
                        n1.setText("0");
                        n1isfilled=true;
                        reset();
                    } else if (n1isfilled && ops.getText().toString().equals(".")) {
                        n1.append("0");

                    } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                        n2.setText("0");
                        n2isfilled = true;

                    } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                            ) {
                        n2.append("0");
                    }
                }

                break;


        case R.id.num1:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("1");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("1");
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("1");

                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("1");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("1");
                }
            }

            break;

        case R.id.num2:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("2");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("2");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("2");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("2");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("2");
                }
            }

            break;

        case R.id.num3:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("3");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("3");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("3");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("3");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("3");
                }
            }

            break;

        case R.id.num4:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("4");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("4");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("4");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("4");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("4");
                }
            }

            break;


        case R.id.num5:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("5");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("5");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("5");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("5");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("5");
                }
            }

            break;


        case R.id.num6:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("6");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("6");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("6");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("6");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("6");
                }
            }

            break;

        case R.id.num7:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("7");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("7");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("7");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("7");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("7");
                }
            }

            break;


        case R.id.num8:
            if (!equalispressed) {
                if (!n1isfilled && ops.getText().toString().equals(".")) {
                    n1.setText("8");
                    n1isfilled = true;
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("8");
                    n1isfilled = true;
                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("8");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("8");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("8");
                    n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("8");
                    n1isfilled = true;

                } else if (!n2isfilled && !ops.getText().toString().equals(".")) {
                    n2.setText("8");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("8");
                }
            }

            break;

        case R.id.num9:
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

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("9");
                }
            } else if(equalispressed){
                if (n1isfilled && !ops.getText().toString().equals(".")) {
                    n1.setText("9");
                   //n1isfilled=true;
                    reset();
                } else if (n1isfilled && ops.getText().toString().equals(".")) {
                    n1.append("9");
                    n1isfilled = true;
                } else if (n1isfilled && !n2isfilled && !(ops.getText().toString().equals("."))) {
                    n2.setText("9");
                    n2isfilled = true;

                } else if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                        ) {
                    n2.append("9");
                }
            }

            break;

        case R.id.add:
        if (!n1isfilled)
            n1.setText("0");
       oldops=ops.getText().toString();
        ops.setText("+");

        if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                ) {
            Integer ans = result(n1.getText().toString(), n2.getText().toString(),oldops);
            n1.setText(ans.toString());
            ops.setText("+");
            n2.setText("0");
            n2isfilled=false;
        }

        break;

        case R.id.sub:
        if (!n1isfilled)
            n1.setText("");
            oldops =ops.getText().toString();
        ops.setText("-");

        if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                ) {
            Integer ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
            n1.setText(ans.toString());
            ops.setText("-");
            n2.setText("");
            n2isfilled=false;
        }
        break;

        case R.id.mul:
        if (!n1isfilled)
            n1.setText("0");
            oldops =ops.getText().toString();
        ops.setText("X");

        if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                ) {
            Integer ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
            n1.setText(ans.toString());
            ops.setText("X");
            n2.setText("");
            n2isfilled=false;
        }

        break;

        case R.id.div:
        if (!n1isfilled)
            n1.setText("0");
            oldops =ops.getText().toString();
        ops.setText("/");

        if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                ) {


            Integer ans = result(n1.getText().toString(), n2.getText().toString(), oldops);
            n1.setText(ans.toString());
            ops.setText("/");
            n2.setText("");
            n2isfilled=false;
        }

        break;

        case R.id.perc:
        if (!n1isfilled)
            throw new ArithmeticException("Please supply an argument");
        else
            ops.setText("%");
        break;

        //  case R.id.numdot : ops.setText(".");

        case R.id.sqrt:
        if (!n1isfilled)
            ops.setText("sqrt");
        else
            res.setText("Error");

        break;

        case R.id.rem:
        ops.setText("REM");

        case R.id.log:
        if (!n1isfilled)
            ops.setText("log");
        else
            res.setText("Error");

        break;


        case R.id.ln:
        if (!n1isfilled)
            ops.setText("ln");
        else res.setText("Error");

        break;

        case R.id.backsp:

        if (n2isfilled) {

            String str = n2.getText().toString();
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 1);      //deleting 1 element with every touch
                n2.setText(str);
            } else if (str.length() <= 1) {
                n2.setText("0");
                n2isfilled = false;
            }
        }


        if (!n2isfilled && !ops.getText().toString().equals(".")) {
            ops.setText(".");

        }


        if (!n2isfilled && ops.getText().toString().equals(".") && n1isfilled) {
            String str = n1.getText().toString();
            if (str.length() > 1) {
                str = str.substring(0, str.length() - 1);
                n1.setText(str);
            } else if (str.length() <= 1) {
                n1.setText("0");
                n1isfilled = false;
            }
        }


        case R.id.equals:

            equalispressed = true;
            Integer ans;

        if (n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                ) {
            ans = result(n1.getText().toString(), n2.getText().toString(), ops.getText().toString());
            if (ans != -999999999)
                res.setText(ans.toString());
            else
                res.setText("NaNi");
        } else if (!n2isfilled) {
            res.setText(n1.getText().toString());

        } else if (!n1isfilled && n2isfilled && !(ops.getText().toString().equals("."))
                ) {
            res.setText(n2.getText().toString());

        } else
            res.setText("Nani");
    }

}

    Integer result(String n1, String n2, String ops) {

        Integer ans = 0;

        switch (ops) {

            case "+":
                ans = Integer.parseInt(n1) + Integer.parseInt(n2);
                break;
            case "-":
                ans = Integer.parseInt(n1) - Integer.parseInt(n2);
                break;
            case "X":
                ans = Integer.parseInt(n1) * Integer.parseInt(n2);
                break;
            case "/":
                if (!n2.equals("0"))
                    ans = Integer.parseInt(n1) / Integer.parseInt(n2);

                else if (n2.equals(0))
                    ans = -999999999;
                break;
            case "REM":
                ans = Integer.parseInt(n1) % Integer.parseInt(n2);
                break;
        }

        return ans;
    }

    void reset() {

        ops.setText(".");
        n2.setText("0");
        n2isfilled=false;
    }
}
