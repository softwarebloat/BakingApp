package com.softwarebloat.bakingapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipesAdapter;
import com.softwarebloat.bakingapp.models.Recipe;


public class MainActivity extends AppCompatActivity implements RecipesAdapter.ListItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onListItemClick(Recipe recipe) {
        Toast.makeText(this, recipe.getName(), Toast.LENGTH_SHORT).show();
    }
}
