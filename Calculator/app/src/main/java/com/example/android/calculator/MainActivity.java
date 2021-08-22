package com.example.android.calculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.mXparser;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private TextView previousCalculation;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display =findViewById(R.id.displayEditText);
        previousCalculation=findViewById(R.id.previousCalculationView);

        display.setShowSoftInputOnFocus(false);
    }

    public void updateText(String strToAdd)
    {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
        display.setSelection(cursorPos + strToAdd.length());

    }
    public void zeroBTNPush(View view) { updateText(getResources().getString(R.string.zeroButton)); }
    public void oneBTNPush(View view) { updateText(getResources().getString(R.string.oneButton)); }
    public void twoBTNPush(View view) { updateText(getResources().getString(R.string.twoButton)); }
    public void threeBTNPush(View view) { updateText(getResources().getString(R.string.threeButton)); }
    public void fourBTNPush(View view) { updateText(getResources().getString(R.string.fourButton));}
    public void fiveBTNPush(View view) { updateText(getResources().getString(R.string.fiveButton)); }
    public void sixBTNPush(View view) { updateText(getResources().getString(R.string.sixButton)); }
    public void sevenBTNPush(View view) { updateText(getResources().getString(R.string.sevenButton)); }
    public void eightBTNPush(View view) { updateText(getResources().getString(R.string.eightButton)); }
    public void nineBTNPush(View view) { updateText(getResources().getString(R.string.nineButton)); }
    public void paranthesisOpenBTNPush(View view) { updateText(getResources().getString(R.string.paranthesisOpenButton)); }
    public void paranthesisCloseBTNPush(View view) { updateText(getResources().getString(R.string.paranthesisCloseButton)); }
    public void dotBTNPush(View view) { updateText(getResources().getString(R.string.dotButton)); }
    public void divideBTNPush(View view) { updateText(getResources().getString(R.string.divideButton)); }
    public void multiplyBTNPush(View view) { updateText(getResources().getString(R.string.multiplyButton)); }
    public void subtractBTNPush(View view) { updateText(getResources().getString(R.string.subtractButton)); }
    public void addBTNPush(View view) { updateText(getResources().getString(R.string.addButton)); }
    public void clearBTNPush(View view)
    {
        display.setText("");
        previousCalculation.setText("");
    }
    public void backspaceBTNPush(View view)
    {
        int cursorPos=display.getSelectionStart();
        int textLen=display.getText().length();

        if(cursorPos!=0 && textLen!=0)
        {
            SpannableStringBuilder selection= (SpannableStringBuilder)display.getText();
            selection.replace(cursorPos-1,cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }
    public void equalsBTNPush(View view) {
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideButton), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyButton), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }

        public void trigSinBTNPush(View view) { updateText("sin("); }
        public void trigCosBTNPush(View view) { updateText("cos("); }
        public void trigTanBTNPush(View view) { updateText("tan("); }
        public void trigSArcSinBTNPush(View view) { updateText("arcsin("); }
        public void trigSArcCosBTNPush(View view) { updateText("arccos("); }
        public void trigSArcTanBTNPush(View view) { updateText("arctan("); }
        public void naturalLogBTNPush(View view) { updateText("ln("); }
        public void logBTNPush(View view) { updateText("log10("); }
        public void sqrtBTNPush(View view) { updateText("sqrt("); }
        public void absBTNPush(View view) { updateText("abs("); }
        public void piBTNPush(View view) { updateText("pi"); }
        public void eBTNPush(View view) { updateText("e"); }
        public void xSquareBTNPush(View view) { updateText("^(2)"); }
        public void xPowerBTNPush(View view) { updateText("^("); }
        public void degBTNPush(View view) { updateText("deg(");}
        public void trigSecBTNPush(View view) { updateText("sec("); }
        public void trigCosecBTNPush(View view) { updateText("cosec("); }
        public void trigCotBTNPush(View view) { updateText("cot("); }
}