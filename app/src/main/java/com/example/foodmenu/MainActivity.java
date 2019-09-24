package com.example.foodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultPrint;
    CheckBox boxes[];
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boxes = new CheckBox[4];
        resultPrint = findViewById(R.id.result);
        orderBtn = findViewById(R.id.orderBtn);
        boxes[0] = findViewById(R.id.hamburger);
        boxes[1] = findViewById(R.id.frenchFries);
        boxes[2] = findViewById(R.id.cola);
        boxes[3] = findViewById(R.id.cornSoup);

        orderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String result = "你點購的餐點是:\n";

        for (int i=0; i<4; i++) {
            if (boxes[i].isChecked())
                result = result + boxes[i].getText() + "\n";
        }

        resultPrint.setText(result);
    }
}
