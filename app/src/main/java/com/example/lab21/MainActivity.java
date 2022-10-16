package com.example.lab21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab21.utils.TxtCounter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView textCounterView;
    EditText EditText;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Words counter");
        arrayList.add("Symbols counter");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        this.button = findViewById(R.id.btnCounter);
        this.EditText = findViewById(R.id.editText);
        this.textCounterView = findViewById(R.id.textCounterView);


    }


    public void onBtnClick(View view) {


        if (EditText.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "EditText is empty!", Toast.LENGTH_SHORT).show();
        } else {
            if (spinner.getSelectedItem().toString().equals("Words counter")) {
                String phrase = this.EditText.getText().toString();
                int symbolsCount = TxtCounter.getWordsCount(phrase);
                String fromattedResult = String.valueOf(symbolsCount);
                this.textCounterView.setText(fromattedResult);
            }
            else {
                String phrase = this.EditText.getText().toString();
                int wordsCount = TxtCounter.getSymbolsCount(phrase);
                String fromattedResult = String.valueOf(wordsCount);
                this.textCounterView.setText(fromattedResult);
            }
        }
    }
}
