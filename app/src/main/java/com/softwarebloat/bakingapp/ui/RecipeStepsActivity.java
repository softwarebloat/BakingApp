package com.softwarebloat.bakingapp.ui;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.models.Recipe;

import java.io.Serializable;

import static com.softwarebloat.bakingapp.ui.RecipesListFragment.RECIPE_EXTRA;

public class RecipeStepsActivity extends AppCompatActivity {

    Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        recipe = (Recipe) getIntent().getSerializableExtra(RECIPE_EXTRA);

        ActionBar supportActionBar = getSupportActionBar();

        supportActionBar.setTitle(recipe.getName());
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }
}
