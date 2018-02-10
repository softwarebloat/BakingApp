package com.softwarebloat.bakingapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.adapters.RecipesAdapter;
import com.softwarebloat.bakingapp.models.Recipe;
import com.softwarebloat.bakingapp.retrofit.RecipesService;
import com.softwarebloat.bakingapp.utils.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RecipesListFragment extends Fragment implements RecipesAdapter.ListItemClickListener {

    public static final String RECIPE_EXTRA = "recipe_extras";

    RecyclerView mRecyclerView;

    GridLayoutManager mLayoutManager;

    RecipesAdapter mAdapter;

    private RecipesService mRecipesService;


    public RecipesListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_recipes_list, container, false);

        mRecipesService = NetworkUtils.getRecipesService();

        mRecyclerView = rootView.findViewById(R.id.recipes_recycler_view);

        mLayoutManager = new GridLayoutManager(this.getActivity(), 1);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecipesAdapter(new ArrayList<Recipe>(0), this);

        mRecyclerView.setAdapter(mAdapter);

        loadRecipes(); //TODO: check for internet connection

        return rootView;
    }

    private void loadRecipes() {
        mRecipesService.getRecipes()
                .enqueue(new Callback<List<Recipe>>() {
                    @Override
                    public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                        if(response.isSuccessful()) {
                            mAdapter.updateData(response.body());
                        } else {
                            int statusCode = response.code();
                            Log.e(RecipesListFragment.class.getSimpleName(), "Error " + statusCode);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Recipe>> call, Throwable t) {
                        Log.e(RecipesListFragment.class.getSimpleName(), "Error loading from API: " + t);
                    }
                });
    }

    @Override
    public void onListItemClick(Recipe recipe) {
        Intent recipeStepsIntent = new Intent(this.getActivity(), RecipeStepsActivity.class);
        recipeStepsIntent.putExtra(RECIPE_EXTRA, recipe);

        startActivity(recipeStepsIntent);
    }
}
