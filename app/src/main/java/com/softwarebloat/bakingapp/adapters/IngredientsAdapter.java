package com.softwarebloat.bakingapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.models.Ingredient;
import com.softwarebloat.bakingapp.models.Recipe;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientsViewHolder> {

    private Recipe recipe;

    public IngredientsAdapter(Recipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public IngredientsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_ingredients_view_holder, parent, false);

        return new IngredientsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(IngredientsViewHolder holder, int position) {
        Ingredient ingredient = recipe.getIngredients().get(position);

        holder.vIngredient.setText(ingredient.getIngredient());
    }

    @Override
    public int getItemCount() {
        return recipe != null ? recipe.getIngredients().size() : 0;
    }

    public class IngredientsViewHolder extends RecyclerView.ViewHolder {

        TextView vIngredient;

        public IngredientsViewHolder(View itemView) {
            super(itemView);
            vIngredient = itemView.findViewById(R.id.tv_ingredient);
        }
    }
}
