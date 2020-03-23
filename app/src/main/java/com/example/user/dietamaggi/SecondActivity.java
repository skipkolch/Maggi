package com.example.user.dietamaggi;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends AppCompatActivity {

    private int numberWeek;
    private int numberDay;

    private TextView textDay;
    private TextView textBreakfast;
    private TextView textLunch;
    private TextView textDinner;
    private TextView textWeek;


    private TextView breakfast;
    private TextView lunch;
    private TextView dinner;


    private ImageButton leftButton;
    private ImageButton rightButton;

    float x1 = 0, x2 = 0, y1 = 0, y2 = 0;

    @SuppressLint("SetTextI18n")
    private void Update() {
        int number = 0;
        switch (numberDay) {
            case 0: {
                textDay.setText("Суббота");
                number = 5;
                break;
            }
            case 1: {
                textDay.setText("Воскресенье");
                number = 6;
                break;
            }
            case 2: {
                textDay.setText("Понедельник");
                number = 0;
                break;
            }
            case 3: {
                textDay.setText("Вторник");
                number = 1;
                break;
            }
            case 4: {
                textDay.setText("Среда");
                number = 2;
                break;
            }
            case 5: {
                textDay.setText("Четверг");
                number = 3;
                break;
            }
            case 6: {
                textDay.setText("Пятница");
                number = 4;
                break;
            }
        }

        textWeek.setText("" + (numberWeek + 1) + " неделя.");

        if (number == 0 && numberWeek == 0)
            leftButton.setVisibility(View.INVISIBLE);
        else leftButton.setVisibility(View.VISIBLE);

        if (number == 6 && numberWeek == 3)
            rightButton.setVisibility(View.INVISIBLE);
        else rightButton.setVisibility(View.VISIBLE);

        if (numberWeek == 0 || numberWeek == 1) {
            visibleViews();
            textBreakfast.setText("" + MainActivity.Days[numberWeek][number].getBreakfast());
            textLunch.setText("" + MainActivity.Days[numberWeek][number].getLunch());
            textDinner.setText("" + MainActivity.Days[numberWeek][number].getDinner());
        } else {
            invisibleViews();
            breakfast.setText("Питание на день:");
            textBreakfast.setText("" + MainActivity.Days[numberWeek][number].getBreakfast());
        }
    }

    private void visibleViews() {
        lunch.setVisibility(View.VISIBLE);
        textLunch.setVisibility(View.VISIBLE);

        dinner.setVisibility(View.VISIBLE);
        textDinner.setVisibility(View.VISIBLE);
    }

    private void invisibleViews() {
        lunch.setVisibility(View.INVISIBLE);
        textLunch.setVisibility(View.INVISIBLE);

        dinner.setVisibility(View.INVISIBLE);
        textDinner.setVisibility(View.INVISIBLE);
    }

    private void Initialize() {
        textDay = findViewById(R.id.dayWeek);
        textBreakfast = findViewById(R.id.breakfastText);
        textLunch = findViewById(R.id.lunchText);
        textDinner = findViewById(R.id.dinnerText);
        leftButton = findViewById(R.id.LeftButton);
        rightButton = findViewById(R.id.RightButton);

        breakfast = findViewById(R.id.breakf);
        lunch = findViewById(R.id.lunch);
        dinner = findViewById(R.id.dinner);

        textWeek = findViewById(R.id.numberWeek);
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Left();
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Right();
            }
        });
    }


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        numberWeek = Integer.parseInt(getIntent().getStringExtra(MainActivity.TAG));

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yy", Locale.getDefault());
        Date d = new Date();
        String dayOfTheWeek = dateFormat.format(d);

        numberDay = ResultDay(dayOfTheWeek);
        Initialize();
        Update();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case (MotionEvent.ACTION_DOWN):
                x1 = event.getX();
                y1 = event.getY();
                break;
            case (MotionEvent.ACTION_UP):
                x2 = event.getX();
                y2 = event.getY();

                if (x1 > x2) {
                    rightButton.performClick();
                } else if (x1 < x2) {
                    leftButton.performClick();
                }
                break;

            default:
                return super.onTouchEvent(event);
        }
        return false;
    }

    private void Right() {
        //swipe right
        if (numberDay == 1 && numberWeek >= 3) {
            Toast.makeText(this, "Конец диеты.", Toast.LENGTH_SHORT).show();
            onBackPressed();
            return;
        } else if (numberDay == 1) {
            Toast.makeText(this, "Следующая неделя.", Toast.LENGTH_SHORT).show();
            numberDay = 2;
            numberWeek++;
        } else numberDay++;

        if (numberDay > 6)
            numberDay = 0;

        Update();
    }

    private void Left() {
        //swipe left
        if (numberDay == 2 && numberWeek <= 0) {
            numberWeek = 0;
            Toast.makeText(this, "Начало диеты.", Toast.LENGTH_SHORT).show();
        } else if (numberDay == 2) {
            Toast.makeText(this, "Предыдущая неделя.", Toast.LENGTH_SHORT).show();
            numberDay = 1;
            numberWeek--;
        } else numberDay--;

        if (numberDay < 0)
            numberDay = 6;


        Update();
    }

    private int ResultDay(String datastr) {
        int[] day = {0, 1, 2, 3, 4, 5, 6};
        int i = 0;

        try {
            String[] array = datastr.split("\\.");
            i = (Integer.parseInt(array[0]) + CodMounth(array[1]) + CodYear(array[2])) % 7;
        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Invalid format", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }

        return day[i];
    }


    private int CodMounth(String mounth) {
        int mnth = Integer.parseInt(mounth);

        switch (mnth) {
            case 1:
            case 10: {
                return 1;
            }
            case 2:
            case 3:
            case 11: {
                return 4;
            }
            case 4:
            case 7: {
                return 0;
            }
            case 5: {
                return 2;
            }
            case 6: {
                return 5;
            }
            case 8: {
                return 3;
            }
            case 9:
            case 12: {
                return 6;
            }
            default:
                return -1;
        }
    }

    private int CodYear(String year) {
        int y = Integer.parseInt(year);
        return (6 + y + y / 4) % 7;
    }
}
