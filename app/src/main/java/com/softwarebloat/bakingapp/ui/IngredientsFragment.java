package com.softwarebloat.bakingapp.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.IngredientsAdapter;
import com.softwarebloat.bakingapp.models.Recipe;

import java.io.Serializable;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;
import static com.softwarebloat.bakingapp.ui.RecipesListFragment.RECIPE_EXTRA;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngredientsFragment extends Fragment {


    RecyclerView mIngredientsRecyclerView;
    LinearLayoutManager mLayoutManager;
    IngredientsAdapter mIngredientsAdapter;

    public IngredientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);

        Intent intent = getActivity().getIntent();
        Recipe recipe = (Recipe) intent.getSerializableExtra(RECIPE_EXTRA);

        mIngredientsRecyclerView = rootView.findViewById(R.id.rv_ingredients);
        mLayoutManager = new LinearLayoutManager(this.getActivity(), VERTICAL, false);
        mIngredientsAdapter = new IngredientsAdapter(recipe);

        mIngredientsRecyclerView.setLayoutManager(mLayoutManager);
        mIngredientsRecyclerView.setAdapter(mIngredientsAdapter);

        return rootView;
    }

}
