package com.softwarebloat.bakingapp.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softwarebloat.bakingapp.R;

public class IngredientsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        ActionBar supportActionBar = getSupportActionBar();

        supportActionBar.setTitle(R.string.ingredients);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
}
