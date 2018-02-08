package com.softwarebloat.bakingapp.utils;

import com.softwarebloat.bakingapp.retrofit.RecipesRetrofitClient;
import com.softwarebloat.bakingapp.retrofit.RecipesService;

public class NetworkUtils {

    private static final String RECIPES_BASE_URL =
            "https://d17h27t6h515a5.cloudfront.net/topher/2017/May/59121517_baking/";

    public static RecipesService getRecipesService() {
        return RecipesRetrofitClient.getClient(RECIPES_BASE_URL).create(RecipesService.class);
    }
}
