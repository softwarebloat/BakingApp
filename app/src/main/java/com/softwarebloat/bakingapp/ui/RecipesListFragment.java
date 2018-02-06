package com.softwarebloat.bakingapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipesAdapter;
import com.softwarebloat.bakingapp.pojo.Recipe;

import java.util.ArrayList;
import java.util.List;


public class RecipesListFragment extends Fragment {

    RecyclerView mRecyclerView;

    GridLayoutManager mLayoutManager;

    RecipesAdapter mAdapter;


    public RecipesListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_recipes_list, container, false);

        mRecyclerView = rootView.findViewById(R.id.recipes_recycler_view);

        mLayoutManager = new GridLayoutManager(this.getActivity(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecipesAdapter(getFakeRecipes(), (MainActivity) getActivity());

        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }


    //only for test
    private List<Recipe> getFakeRecipes() {
        List<Recipe> recipes = new ArrayList<>();

        Recipe recipe = new Recipe();
        recipe.setName("Torta pasqualina");

        Recipe recipe1 = new Recipe();
        recipe1.setName("Parmigiana di melanzane");

        Recipe recipe2 = new Recipe();
        recipe2.setName("Pizza");

        recipes.add(recipe);
        recipes.add(recipe1);
        recipes.add(recipe2);

        return recipes;
    }

}
