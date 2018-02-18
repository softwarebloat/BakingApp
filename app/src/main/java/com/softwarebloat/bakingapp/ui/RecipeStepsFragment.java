package com.softwarebloat.bakingapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipeStepsAdapter;
import com.softwarebloat.bakingapp.models.Recipe;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static com.softwarebloat.bakingapp.ui.RecipesListFragment.RECIPE_EXTRA;

/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeStepsFragment extends Fragment {

    public static final String STEP_KEY = "recipe-step";

    RecyclerView mStepsRecyclerView;
    LinearLayoutManager mLayoutManager;
    RecipeStepsAdapter mStepsAdapter;

    TextView mIngredients;

    public RecipeStepsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_recipe_steps, container, false);

        Intent intent = getActivity().getIntent();
        final Recipe recipe = (Recipe) intent.getSerializableExtra(RECIPE_EXTRA);

        mIngredients = rootView.findViewById(R.id.tv_recipe_ingredients);

        //TODO: show ingredients in textview and dont open new activity
        mIngredients.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "ingredients", Toast.LENGTH_SHORT).show();
            }
        });



        mStepsRecyclerView = rootView.findViewById(R.id.rv_steps);
        mLayoutManager = new LinearLayoutManager(getContext(), VERTICAL, false);
        mStepsAdapter = new RecipeStepsAdapter(recipe, (RecipeStepsActivity)getActivity());

        mStepsRecyclerView.setLayoutManager(mLayoutManager);
        mStepsRecyclerView.setAdapter(mStepsAdapter);


        return rootView;
    }
}
