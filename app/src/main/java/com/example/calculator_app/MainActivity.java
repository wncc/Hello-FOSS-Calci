package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button zero,one,two,three,four,five,six,seven,eight,nine;
    private Button add,sub,mul,div,equal,clear;
    private TextView info;
    private TextView result;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char EQU = 0;
    private double val1 = Double.NaN;
    private double val2= Double.NaN;
    private char ACTION='n';



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





            setupUIViews();
//        zero.setOnClickListener((View.OnClickListener) this);


            zero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "0");
                }
            });

            one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "1");
                }
            });

            two.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "2");
                }
            });

            three.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "3");
                }
            });


            four.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "4");
                }
            });

            five.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "5");
                }
            });

            six.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "6");
                }
            });

            seven.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "7");
                }
            });

            eight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "8");
                }
            });

            nine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    info.setText(info.getText().toString() + "9");
                }
            });

            sub.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION = SUBTRACTION;
                    result.setText(String.valueOf(val1) + "-");
                    info.setText(null);
                }
            });

            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION = ADDITION;
                    if (!Double.isNaN(val1))
                        result.setText(String.valueOf(val1) + "+");
                    info.setText(null);
                }
            });

            mul.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION = MULTIPLICATION;
                    if (!Double.isNaN(val1))
                        result.setText(String.valueOf(val1) + "*");
                    info.setText(null);
                }
            });

            div.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    compute();
                    ACTION = DIVISION;
                    if (!Double.isNaN(val1))
                        result.setText(String.valueOf(val1) + "/");
                    info.setText(null);
                }
            });

            equal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (ACTION != EQU && ACTION != 'n'){
                        if (!Double.isNaN(val1)) {
                            compute();
                            if (!info.getText().toString().isEmpty()) {
                                ACTION = EQU;
                                result.setText(result.getText().toString() + String.valueOf(val2) + "=" + String.valueOf(val1));
                                // 5 + 4 = 9
                                info.setText(null);
                            }
                        }
                    }
                }
            });

            clear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (info.getText().length() > 0) {
                        CharSequence name = info.getText().toString();
                        info.setText(name.subSequence(0, name.length() - 1));
                    } else {
                        ACTION='n';
                        val1 = Double.NaN;
                        val2 = Double.NaN;
                        info.setText(null);
                        result.setText(null);
                    }
                }
            });

        }

        private void setupUIViews() {
            zero = (Button) findViewById(R.id.btn0);
            one = (Button) findViewById(R.id.btn1);
            two = (Button) findViewById(R.id.btn2);
            three = (Button) findViewById(R.id.btn3);
            four = (Button) findViewById(R.id.btn4);
            five = (Button) findViewById(R.id.btn5);
            six = (Button) findViewById(R.id.btn6);
            seven = (Button) findViewById(R.id.btn7);
            eight = (Button) findViewById(R.id.btn8);
            nine = (Button) findViewById(R.id.btn9);
            add = (Button) findViewById(R.id.btnadd);
            sub = (Button) findViewById(R.id.btnsub);
            mul = (Button) findViewById(R.id.btnmul);
            div = (Button) findViewById(R.id.btndivide);
            equal = (Button) findViewById(R.id.btnequal);
            info = (TextView) findViewById(R.id.tvControl);
            result = (TextView) findViewById(R.id.tvResult);
            clear = (Button) findViewById(R.id.btnclear);
        }

        private void compute() {
            if (info.getText().toString().isEmpty() && ACTION!=EQU) {
                Toast.makeText(MainActivity.this, "Please Enter All Parameters", Toast.LENGTH_SHORT).show();
            }
            else if (info.getText().toString().isEmpty() && ACTION==EQU){
                result.setText(String.valueOf(val1));
            }
            else {
                if (!Double.isNaN(val1)) {

                    val2 = Double.parseDouble(info.getText().toString());

                    switch (ACTION) {
                        case ADDITION:
                            val1 = val1 + val2;
                            break;
                        case SUBTRACTION:
                            val1 = val1 - val2;
                            break;
                        case MULTIPLICATION:
                            val1 = val1 * val2;
                            break;
                        case DIVISION:
                            val1 = val1 / val2;
                            break;
                        case EQU:
                            break;
                    }

                } else {
                    val1 = Double.parseDouble(info.getText().toString());
                }
            }
        }



        //The following code can be used to switch to another activity
//    public void changeactivity() {
//        Intent intent = new Intent(MainActivity.this, calculator.class);
//        startActivity(intent);
//    }




    }
