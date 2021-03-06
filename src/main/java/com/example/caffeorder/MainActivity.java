package com.example.caffeorder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    RadioButton btnTypeOne, btnTypeTwo, btnTypeThree;
    CheckBox checkAddOne, checkAddTwo, checkAddThree;
    TextView resultOrder, nuumberCups;
    FloatingActionButton btnPlus, btnMinus;

    int resultType = 0;
    int resultAdd = 0;
    int cups = 0;
    int resultPlusOrMinus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calls();
    }

    private void calls() {
        fvById();

        typeOne();
        typeTwo();
        typeThree();

        addCheckOne();
        addCheckTwo();
        addCheckThree();

        actionPlus();
        actionMinus();

        order();
    }

    public void fvById() {
        btnTypeOne = findViewById(R.id.btn_Espresso);
        btnTypeTwo = findViewById(R.id.btn_Cappuccino);
        btnTypeThree = findViewById(R.id.btn_Mocha);

        checkAddOne = findViewById(R.id.check_Cream);
        checkAddTwo = findViewById(R.id.check_Choco);
        checkAddThree = findViewById(R.id.check_Milk);

        resultOrder = findViewById(R.id.resultOrder);
        nuumberCups = findViewById(R.id.btnNumber);

        btnPlus = findViewById(R.id.floatingPlus);
        btnMinus = findViewById(R.id.floatingMinus);
    }

    public void typeOne() {
        btnTypeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultType = 3;
            }
        });
    }

    public void typeTwo() {
        btnTypeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultType = 5;
            }
        });
    }

    public void typeThree() {
        btnTypeThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultType = 7;
            }
        });
    }

    public void addCheckOne() {
        checkAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAddOne.isChecked()) {
                    resultAdd = 10;
                }
            }
        });
    }

    public void addCheckTwo() {
        checkAddTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAddTwo.isChecked()) {
                    resultAdd = 13;
                }
            }
        });
    }

    public void addCheckThree() {
        checkAddThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAddThree.isChecked()) {
                    resultAdd = 15;
                }
            }
        });
    }

    public void actionPlus() {
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultPlusOrMinus = resultPlusOrMinus + 1;
                nuumberCups.setText(resultPlusOrMinus + "");
            }
        });
    }

    public void actionMinus() {
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultPlusOrMinus = resultPlusOrMinus - 1;
                nuumberCups.setText(resultPlusOrMinus + "");
            }
        });
    }

    public void order()
    {
        resultOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                cups = (resultType + resultAdd)* resultPlusOrMinus;
                resultOrder.setText(cups+"");
            }
        });
    }
}