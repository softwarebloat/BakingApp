package com.softwarebloat.bakingapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.softwarebloat.bakingapp.R;
import com.softwarebloat.bakingapp.models.Recipe;
import com.softwarebloat.bakingapp.models.Step;

import java.util.List;

public class RecipeStepsAdapter extends RecyclerView.Adapter<RecipeStepsAdapter.RecipeStepsViewHolder> {

    private Recipe recipe;
    final private StepItemClickListener mClickListener;

    public RecipeStepsAdapter(Recipe recipe, StepItemClickListener mClickListener) {
        this.recipe = recipe;
        this.mClickListener = mClickListener;
    }

    public interface StepItemClickListener {
        void onStepItemClick(Recipe recipe, int stepIndex);
    }

    @Override
    public RecipeStepsAdapter.RecipeStepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_steps_view_holder, parent, false);

        return new RecipeStepsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeStepsAdapter.RecipeStepsViewHolder holder, int position) {
        Step step = recipe.getSteps().get(position);

        holder.vRecipeStep.setText(step.getShortDescription());
    }

    @Override
    public int getItemCount() {
        return recipe != null ? recipe.getSteps().size() : 0;
    }

    public class RecipeStepsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView vRecipeStep;

        public RecipeStepsViewHolder(View itemView) {
            super(itemView);
            vRecipeStep = itemView.findViewById(R.id.tv_step);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int stepIndex = getAdapterPosition();
            mClickListener.onStepItemClick(recipe, stepIndex);
        }
    }
}
