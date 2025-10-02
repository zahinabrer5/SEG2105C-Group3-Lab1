package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot, btnClear, btnPlus, btnMinus, btnMult, btnDivision, btnEqual, btnLeftParen, btnRightParen, btnSqrt, btnPower;
    TextView textDisplay;

    // This is to evaluate the math expression

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);
        btnDot = findViewById(R.id.btn_dot);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMult = findViewById(R.id.btn_mult);
        btnDivision = findViewById(R.id.btn_division);
        btnLeftParen = findViewById(R.id.btn_left_paren);
        btnRightParen = findViewById(R.id.btn_right_paren);
        btnSqrt = findViewById(R.id.btn_sqrt);
        btnPower = findViewById(R.id.btn_power);
        btnEqual = findViewById(R.id.btn_equal);
        btnClear = findViewById(R.id.btn_clear);
        textDisplay = findViewById(R.id.textview_input_display);

        setClickListeners();
    }

    private void setClickListeners() {
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnLeftParen.setOnClickListener(this);
        btnRightParen.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnPower.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                addNumber("1");
                break;
            case R.id.btn2:
                addNumber("2");
                break;
            case R.id.btn3:
                addNumber("3");
                break;
            case R.id.btn4:
                addNumber("4");
                break;
            case R.id.btn5:
                addNumber("5");
                break;
            case R.id.btn6:
                addNumber("6");
                break;
            case R.id.btn7:
                addNumber("7");
                break;
            case R.id.btn8:
                addNumber("8");
                break;
            case R.id.btn9:
                addNumber("9");
                break;
            case R.id.btn0:
                addNumber("0");
                break;
            case R.id.btn_plus:
                addNumber("+");
                break;
            case R.id.btn_minus:
                addNumber("-");
                break;
            case R.id.btn_mult:
                addNumber("*");
                break;
            case R.id.btn_division:
                addNumber("/");
                break;
            case R.id.btn_dot:
                addNumber(".");
                break;
            case R.id.btn_left_paren:
                addNumber("(");
                break;
            case R.id.btn_right_paren:
                addNumber(")");
                break;
            case R.id.btn_sqrt:
                addNumber("sqrt(");
                break;
            case R.id.btn_power:
                addNumber("^");
                break;
            case R.id.btn_equal:
                String result;
                try {
                    result = evaluate(textDisplay.getText().toString());
                    textDisplay.setText(result);
                } catch (Exception e) {
                    textDisplay.setText("Error");
//                    clearDisplay();
                }
                break;
            case R.id.btn_clear:
                clearDisplay();
                break;
        }
    }

    private String evaluate(String expression) {
        String result = MathEval.eval(expression);
        BigDecimal decimal = new BigDecimal(result);
        return decimal/*.setScale(2, RoundingMode.HALF_UP)*/.toPlainString();
    }

    @SuppressLint("SetTextI18n")
    private void addNumber(String number) {
        textDisplay.setText(textDisplay.getText() + number);
    }

    private void clearDisplay() {
        textDisplay.setText("");
    }
}
