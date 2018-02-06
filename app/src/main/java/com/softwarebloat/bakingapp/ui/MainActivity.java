package com.softwarebloat.bakingapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipesAdapter;


public class MainActivity extends AppCompatActivity implements RecipesAdapter.ListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        Toast.makeText(this, String.valueOf(clickedItemIndex), Toast.LENGTH_SHORT).show();
    }
}
