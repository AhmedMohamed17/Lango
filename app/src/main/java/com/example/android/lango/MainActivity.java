package com.example.android.lango;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView numbers;
    TextView family;
    TextView phrases;
    TextView colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = findViewById(R.id.pager);
        simpleFragmentAdapter adapter = new simpleFragmentAdapter(getSupportFragmentManager());
        TabLayout tab = findViewById(R.id.tab);
        pager.setAdapter(adapter);

        tab.setupWithViewPager(pager);
       /* Log.d("start", "onCreate: started ");
        // feen el id numbers
        numbers= findViewById(R.id.numbers);
        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Numbers.class);
                startActivity(i);
            }
        });

        family=findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Family.class);
                startActivity(i);
            }
        });

        colors=findViewById(R.id.colors);
        colors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Colors.class);
                startActivity(i);
            }
        });
         phrases=findViewById(R.id.phrases);
         phrases.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent i = new Intent(MainActivity.this,Phrases.class);
                 startActivity(i);
             }
         });
    }



    public void phrases_open(View view) {
        Intent i = new Intent(MainActivity.this,Phrases.class);
        startActivity(i);
    }

    public void colors_open(View view) {
        Intent i = new Intent(MainActivity.this,Colors.class);
        startActivity(i);
    }

    public void family_open(View view) {
        Intent i = new Intent(MainActivity.this,Family.class);
        startActivity(i);
    }*/
    }
}