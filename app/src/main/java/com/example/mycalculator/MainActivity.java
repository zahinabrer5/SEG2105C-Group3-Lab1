package com.example.mycalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnDot, btnComma, btnClear, btnPlus, btnMinus, btnMult, btnDivision, btnEqual, btnLeftParen, btnRightParen, btnSqrt, btnPower, btnLog10, btnLn, btnFloor, btnCeil, btnSin, btnCos, btnExp;
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
        btnComma = findViewById(R.id.btn_comma);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMult = findViewById(R.id.btn_mult);
        btnDivision = findViewById(R.id.btn_division);
        btnLeftParen = findViewById(R.id.btn_left_paren);
        btnRightParen = findViewById(R.id.btn_right_paren);
        btnSqrt = findViewById(R.id.btn_sqrt);
        btnPower = findViewById(R.id.btn_power);
        btnLog10 = findViewById(R.id.btn_log10);
        btnLn = findViewById(R.id.btn_ln);
        btnFloor = findViewById(R.id.btn_floor);
        btnCeil = findViewById(R.id.btn_ceil);
        btnSin = findViewById(R.id.btn_sin);
        btnCos = findViewById(R.id.btn_cos);
        btnExp = findViewById(R.id.btn_exp);
        btnEqual = findViewById(R.id.btn_equal);
        btnClear = findViewById(R.id.btn_clear);
        textDisplay = findViewById(R.id.textview_input_display);
        textDisplay.setMovementMethod(new ScrollingMovementMethod());

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
        btnComma.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnLeftParen.setOnClickListener(this);
        btnRightParen.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);
        btnPower.setOnClickListener(this);
        btnLog10.setOnClickListener(this);
        btnLn.setOnClickListener(this);
        btnFloor.setOnClickListener(this);
        btnCeil.setOnClickListener(this);
        btnSin.setOnClickListener(this);
        btnCos.setOnClickListener(this);
        btnExp.setOnClickListener(this);
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
            case R.id.btn_comma:
                addNumber(",");
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
            case R.id.btn_log10:
                addNumber("log10(");
                break;
            case R.id.btn_ln:
                addNumber("log(");
                break;
            case R.id.btn_floor:
                addNumber("floor(");
                break;
            case R.id.btn_ceil:
                addNumber("ceil(");
                break;
            case R.id.btn_sin:
                addNumber("sin(");
                break;
            case R.id.btn_cos:
                addNumber("cos(");
                break;
            case R.id.btn_exp:
                addNumber("e^(");
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
                scrollToBottom();
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
        scrollToBottom();
    }

    private void clearDisplay() {
        textDisplay.setText("");
        scrollToBottom();
    }

    private void scrollToBottom() {
        textDisplay.post(() -> {
            int scrollAmount = textDisplay.getLayout().getLineTop(textDisplay.getLineCount()) - textDisplay.getHeight();
            textDisplay.scrollTo(0, Math.max(scrollAmount, 0));
        });
    }
}
