package com.example.foodmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ArrayList<String> checked;
    TextView resultPrint;
    int boxesId[] = {R.id.hamburger, R.id.frenchFries, R.id.cola, R.id.cornSoup};
    int checkedNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultPrint = findViewById(R.id.result);
        checked = new ArrayList<>();

        for (int i:boxesId) {
            CheckBox box = findViewById(i);
            box.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        int visible = 0;
        int id = compoundButton.getId();
        ImageView tem = null;

        if (b) {
            visible = View.VISIBLE;
            checkedNum++;
        }
        else {
            visible = View.GONE;
            checkedNum--;
        }

        if (id == R.id.hamburger) {
            tem = findViewById(R.id.outputImg1);
        }
        else if (id == R.id.frenchFries) {
            tem = findViewById(R.id.outputImg2);
        }
        else if (id == R.id.cola) {
            tem = findViewById(R.id.outputImg3);
        }
        else if (id == R.id.cornSoup) {
            tem = findViewById(R.id.outputImg4);
        }

        tem.setVisibility(visible);
        String s = (checkedNum > 0)? "您點的餐點如下:":"請點餐!";
        resultPrint.setText(s);
    }
}
