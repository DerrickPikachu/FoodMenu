package com.example.foodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    private ArrayList<String> checked;
    TextView resultPrint;
    int boxesId[] = {R.id.hamburger, R.id.frenchFries, R.id.cola, R.id.cornSoup};
    Button orderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultPrint = findViewById(R.id.result);
        orderBtn = findViewById(R.id.orderBtn);
        checked = new ArrayList<>();

        orderBtn.setOnClickListener(this);

        for (int i:boxesId) {
            CheckBox box = findViewById(i);
            box.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        String result = "您訂購的餐點是:\n";
        CheckBox box;

        for (int i:boxesId) {
            box = findViewById(i);
            if (box.isChecked())
                result = result + box.getText() + "\n";
        }

        resultPrint.setText(result);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String result = "您點的餐點是:\n";

        if (b)
            checked.add(compoundButton.getText().toString());
        else
            checked.remove(compoundButton.getText().toString());

        for (int i=0; i<checked.size(); i++)
            result = result + checked.get(i) + "\n";

        resultPrint.setText(result);
    }
}
