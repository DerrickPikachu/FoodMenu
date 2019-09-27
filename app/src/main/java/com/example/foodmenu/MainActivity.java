package com.example.foodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView resultPrint;
    int boxesId[] = {R.id.hamburger, R.id.frenchFries, R.id.cola, R.id.cornSoup};
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultPrint = findViewById(R.id.result);
        orderBtn = findViewById(R.id.orderBtn);

        orderBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String result = "你點購的餐點是:\n";
        CheckBox box;

        for (int i:boxesId) {
            box = findViewById(i);
            if (box.isChecked())
                result = result + box.getText() + "\n";
        }

        resultPrint.setText(result);
    }
}
