package com.softwarebloat.bakingapp.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipeStepsAdapter;
import com.softwarebloat.bakingapp.adapters.RecipesAdapter;
import com.softwarebloat.bakingapp.models.Recipe;

import static com.softwarebloat.bakingapp.ui.RecipeStepsFragment.STEP_KEY;
import static com.softwarebloat.bakingapp.ui.RecipesListFragment.RECIPE_EXTRA;

public class RecipeStepsActivity extends AppCompatActivity
        implements RecipeStepsAdapter.StepItemClickListener {

    Recipe recipe;
    boolean mTwoPane;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_steps);

        recipe = (Recipe) getIntent().getSerializableExtra(RECIPE_EXTRA);

        ActionBar supportActionBar = getSupportActionBar();

        supportActionBar.setTitle(recipe.getName());
        supportActionBar.setDisplayHomeAsUpEnabled(true);


        fragmentManager = getSupportFragmentManager();

        RecipeStepsFragment recipeStepsFragment = new RecipeStepsFragment();
//                recipeStepsFragment.setArguments();

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.recipe_steps_container, recipeStepsFragment)
                    .commit();

            if (findViewById(R.id.recipe_detail_container) != null) {
                mTwoPane = true;

                StepDetailsFragments stepDetailsFragments = new StepDetailsFragments();
                Bundle bundle = new Bundle();
                bundle.putSerializable(STEP_KEY, recipe.getSteps().get(0));
                stepDetailsFragments.setArguments(bundle);

                fragmentManager.beginTransaction()
                        .replace(R.id.recipe_detail_container, stepDetailsFragments)
                        .commit();

            } else {
                mTwoPane = false;
            }
        }


    }

    @Override
    public void onStepItemClick(Recipe recipe, int index) {

        StepDetailsFragments stepDetailsFragments = new StepDetailsFragments();
        Bundle bundle = new Bundle();
        bundle.putSerializable(STEP_KEY, recipe.getSteps().get(index));
        stepDetailsFragments.setArguments(bundle);

        if (mTwoPane) {
            fragmentManager.beginTransaction()
                    .replace(R.id.recipe_detail_container, stepDetailsFragments).addToBackStack(null)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.recipe_steps_container, stepDetailsFragments).addToBackStack(null)
                    .commit();
        }
    }

}
