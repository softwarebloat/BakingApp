package com.softwarebloat.bakingapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipeStepsAdapter;
import com.softwarebloat.bakingapp.models.Recipe;
import com.softwarebloat.bakingapp.models.Step;

import java.io.Serializable;
import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static com.softwarebloat.bakingapp.ui.RecipesListFragment.RECIPE_EXTRA;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeStepsFragment extends Fragment implements RecipeStepsAdapter.StepItemClickListener {

    RecyclerView mStepsRecyclerView;
    LinearLayoutManager mLayoutManager;
    RecipeStepsAdapter mStepsAdapter;

    public RecipeStepsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_recipe_steps, container, false);


        Intent intent = getActivity().getIntent();
        Recipe recipe = (Recipe) intent.getSerializableExtra(RECIPE_EXTRA);

        mStepsRecyclerView = rootView.findViewById(R.id.rv_steps);
        mLayoutManager = new LinearLayoutManager(this.getActivity(), VERTICAL, false);
        mStepsAdapter = new RecipeStepsAdapter(recipe, this);

        mStepsRecyclerView.setLayoutManager(mLayoutManager);
        mStepsRecyclerView.setAdapter(mStepsAdapter);


        return rootView;
    }

    @Override
    public void onStepItemClick(Recipe recipe, int stepIndex) {
        //TODO: open single step
        Toast.makeText(
                this.getActivity(),
                recipe.getSteps().get(stepIndex).getShortDescription(),
                Toast.LENGTH_SHORT)
                .show();
    }
}
