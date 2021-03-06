package com.softwarebloat.bakingapp.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.models.Recipe;

import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {

    private List<Recipe> recipes;
    final private ListItemClickListener mClickListener;

    public RecipesAdapter(List<Recipe> recipes, ListItemClickListener mClickListener) {
        this.recipes = recipes;
        this.mClickListener = mClickListener;
    }

    public interface ListItemClickListener {
        void onListItemClick(Recipe recipe);
    }

    @Override
    public RecipesAdapter.RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_recipe_view_holder, parent, false);

        return new RecipesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipesAdapter.RecipesViewHolder holder, int position) {
        Recipe recipe = recipes.get(position);

        holder.vRecipeName.setText(recipe.getName());
    }

    @Override
    public int getItemCount() {
        return recipes != null ? recipes.size() : 0;
    }

    public void updateData(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView vRecipeName;

        public RecipesViewHolder(View itemView) {
            super(itemView);
            vRecipeName = itemView.findViewById(R.id.recipe_title);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mClickListener.onListItemClick(recipes.get(getAdapterPosition()));
        }
    }
}
