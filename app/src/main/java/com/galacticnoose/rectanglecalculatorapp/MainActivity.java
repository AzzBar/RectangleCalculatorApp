package com.galacticnoose.rectanglecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;



import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;

import android.os.Bundle;
import android.widget.Toast;

import static java.util.Locale.US;

public class MainActivity extends AppCompatActivity implements OnEditorActionListener {


    EditText widthEdit;
    EditText heightEdit;
    TextView perimeterResult;
    TextView areaResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        widthEdit = (EditText) findViewById(R.id.widthEdit);
        heightEdit = (EditText) findViewById(R.id.heightEdit);
        perimeterResult = (TextView) findViewById(R.id.perimeterResult);
        areaResult = (TextView) findViewById(R.id.areaResult);

        widthEdit.setOnEditorActionListener(this);
        heightEdit.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE) {

            checkIsEmpty();
            calculate();
        }
        return false;
    }

    public void checkIsEmpty() {

        String heightCheck = heightEdit.getText().toString();
        String widthCheck = widthEdit.getText().toString();

        if (widthCheck.equals("")) {
            widthEdit.setText("0");
            return;
        }
        if (heightCheck.equals(""))  {
            heightEdit.setText("0");
            return;
        }
    }

    public void calculate(){

        double height = Double.parseDouble(heightEdit.getText().toString());
        double width = Double.parseDouble(widthEdit.getText().toString());
        if( width == 0 ) {
            widthEdit.setError("Entry cannot be zero or empty");
            return;
        }
        if( height == 0 ) {
            heightEdit.setError("Entry cannot be zero or empty");
            return;
        }


        double area = height * width;
        double perimeter = (2 * height) + (2 * width);

        areaResult.setText(String.format(US, "%.2f", area));
        perimeterResult.setText(String.format(US, "%.2f", perimeter));
    }
}
