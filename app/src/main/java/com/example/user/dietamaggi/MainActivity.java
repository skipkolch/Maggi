package com.example.user.dietamaggi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button firstWeek;
    private Button secondWeek;
    private Button threeWeek;
    private Button fourWeek;

    private View.OnClickListener first;
    private View.OnClickListener second;
    private View.OnClickListener three;
    private View.OnClickListener four;

    private Intent i;
    private String eText;

    protected static Day[][] Days;

    protected static final String TAG = "WEEK";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Initialize();
        InitDays();
    }

    private void Initialize()
    {
        firstWeek = (Button)findViewById(R.id.firstWeek);
        secondWeek = (Button)findViewById(R.id.secondWeek);
        threeWeek = (Button)findViewById(R.id.threeWeek);
        fourWeek = (Button)findViewById(R.id.fourWeek);

        i = new Intent(MainActivity.this, SecondActivity.class);

        first = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText = "0";
                i.putExtra(TAG, eText);
                startActivity(i);
            }
        };

        second = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText = "1";
                i.putExtra(TAG, eText);
                startActivity(i);
            }
        };

        three = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText = "2";
                i.putExtra(TAG, eText);
                startActivity(i);
            }
        };

        four = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eText = "3";
                i.putExtra(TAG, eText);
                startActivity(i);
            }
        };

        firstWeek.setOnClickListener(first);
        secondWeek.setOnClickListener(second);
        threeWeek.setOnClickListener(three);
        fourWeek.setOnClickListener(four);
    }

    private void InitDays()
    {
        Days = new Day[4][7];
        Days[0][0] = new Day(getResources().getString(R.string.mondayBreakfast0),getResources().getString(R.string.mondayLunch0),getResources().getString(R.string.mondayDinner0));
        Days[0][1] = new Day(getResources().getString(R.string.tuesdayBreakfast0),getResources().getString(R.string.tuesdayLunch0),getResources().getString(R.string.tuesdayDinner0));
        Days[0][2] = new Day(getResources().getString(R.string.wednesdayBreakfast0),getResources().getString(R.string.wednesdayLunch0),getResources().getString(R.string.wednesdayDinner0));
        Days[0][3] = new Day(getResources().getString(R.string.thursdayBreakfast0),getResources().getString(R.string.thursdayLunch0),getResources().getString(R.string.thursdayDinner0));
        Days[0][4] = new Day(getResources().getString(R.string.fridayBreakfast0),getResources().getString(R.string.fridayLunch0),getResources().getString(R.string.fridayDinner0));
        Days[0][5] = new Day(getResources().getString(R.string.saturdayBreakfast0),getResources().getString(R.string.saturdayLunch0),getResources().getString(R.string.saturdayDinner0));;
        Days[0][6] = new Day(getResources().getString(R.string.sundayBreakfast0),getResources().getString(R.string.sundayLunch0),getResources().getString(R.string.sundayDinner0));
        Days[1][0] = new Day(getResources().getString(R.string.mondayBreakfast1),getResources().getString(R.string.mondayLunch1),getResources().getString(R.string.mondayDinner1));
        Days[1][1] = new Day(getResources().getString(R.string.tuesdayBreakfast1),getResources().getString(R.string.tuesdayLunch1),getResources().getString(R.string.tuesdayDinner1));
        Days[1][2] = new Day(getResources().getString(R.string.wednesdayBreakfast1),getResources().getString(R.string.wednesdayLunch1),getResources().getString(R.string.wednesdayDinner1));
        Days[1][3] = new Day(getResources().getString(R.string.thursdayBreakfast1),getResources().getString(R.string.thursdayLunch1),getResources().getString(R.string.thursdayDinner1));
        Days[1][4] = new Day(getResources().getString(R.string.fridayBreakfast1),getResources().getString(R.string.fridayLunch1),getResources().getString(R.string.fridayDinner1));
        Days[1][5] = new Day(getResources().getString(R.string.saturdayBreakfast1),getResources().getString(R.string.saturdayLunch1),getResources().getString(R.string.saturdayDinner1));;
        Days[1][6] = new Day(getResources().getString(R.string.sundayBreakfast1),getResources().getString(R.string.sundayLunch1),getResources().getString(R.string.sundayDinner1));
        Days[2][0] = new Day(getResources().getString(R.string.mondayBreakfast2),getResources().getString(R.string.mondayLunch2),getResources().getString(R.string.mondayDinner2));
        Days[2][1] = new Day(getResources().getString(R.string.tuesdayBreakfast2),getResources().getString(R.string.tuesdayLunch2),getResources().getString(R.string.tuesdayDinner2));
        Days[2][2] = new Day(getResources().getString(R.string.wednesdayBreakfast2),getResources().getString(R.string.wednesdayLunch2),getResources().getString(R.string.wednesdayDinner2));
        Days[2][3] = new Day(getResources().getString(R.string.thursdayBreakfast2),getResources().getString(R.string.thursdayLunch2),getResources().getString(R.string.thursdayDinner1));
        Days[2][4] = new Day(getResources().getString(R.string.fridayBreakfast2),getResources().getString(R.string.fridayLunch2),getResources().getString(R.string.fridayDinner2));
        Days[2][5] = new Day(getResources().getString(R.string.saturdayBreakfast2),getResources().getString(R.string.saturdayLunch2),getResources().getString(R.string.saturdayDinner2));;
        Days[2][6] = new Day(getResources().getString(R.string.sundayBreakfast2),getResources().getString(R.string.sundayLunch2),getResources().getString(R.string.sundayDinner2));
        Days[3][0] = new Day(getResources().getString(R.string.mondayBreakfast3),getResources().getString(R.string.mondayLunch3),getResources().getString(R.string.mondayDinner3));
        Days[3][1] = new Day(getResources().getString(R.string.tuesdayBreakfast3),getResources().getString(R.string.tuesdayLunch3),getResources().getString(R.string.tuesdayDinner3));
        Days[3][2] = new Day(getResources().getString(R.string.wednesdayBreakfast3),getResources().getString(R.string.wednesdayLunch3),getResources().getString(R.string.wednesdayDinner3));
        Days[3][3] = new Day(getResources().getString(R.string.thursdayBreakfast3),getResources().getString(R.string.thursdayLunch3),getResources().getString(R.string.thursdayDinner3));
        Days[3][4] = new Day(getResources().getString(R.string.fridayBreakfast3),getResources().getString(R.string.fridayLunch3),getResources().getString(R.string.fridayDinner3));
        Days[3][5] = new Day(getResources().getString(R.string.saturdayBreakfast3),getResources().getString(R.string.saturdayLunch3),getResources().getString(R.string.saturdayDinner3));;
        Days[3][6] = new Day(getResources().getString(R.string.sundayBreakfast3),getResources().getString(R.string.sundayLunch3),getResources().getString(R.string.sundayDinner3));
    }
}
