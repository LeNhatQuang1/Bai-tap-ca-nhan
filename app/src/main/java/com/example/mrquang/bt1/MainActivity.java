package com.example.mrquang.bt1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private Spinner snFromCurrency;
    private Spinner snToCurrency;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    private void addEvents() {
        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncGetCurrencyConvert(snFromCurrency.getSelectedItem().toString().substring(0,3)
                        ,snToCurrency.getSelectedItem().toString().substring(0,3)
                        ,tvResult).execute();
            }
        });
    }

    private void addControls() {
        findId();
        addDataToSpinner();
    }

    private void addDataToSpinner() {
        List<String> list = new ArrayList<>();
        list.add("USD - Đô La Mỹ");
        list.add("EUR - Đồng Euro");
        list.add("GBP - Bảng Anh");
        list.add("JPY - Đồng Yên Nhật");
        list.add("CAD - Đồng Canada");
        list.add("AUD - Đô La Úc");
        list.add("CNY - Đồng Nhân Dân Tệ");
        list.add("CHF - Đồng Franc Thụy Sĩ");
        list.add("SGD - Đô La Singapore");
        list.add("HKD - Đô La Hồng Kông");
        list.add("VND - Việt Nam Đồng");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        snFromCurrency.setAdapter(adapter);
        snToCurrency.setAdapter(adapter);
    }

    private void findId() {
        tvResult = (TextView)findViewById(R.id.tvResult);
        snFromCurrency =(Spinner)findViewById(R.id.snFromCurrency);
        snToCurrency =(Spinner)findViewById(R.id.snToCurrency);
        btnConvert = (Button)findViewById(R.id.btnConvert);
    }
}
