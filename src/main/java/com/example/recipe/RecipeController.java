package com.example.recipe;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RecipeController {
	
	RecipeService recipeService = new RecipeService();

    @GetMapping("/recipes")
    public ArrayList<Recipe> get_Recipe_List(){

        return recipeService.getRecipeList();
    }

    @PostMapping("/recipes")
    public Recipe add_Recipe(@RequestBody Recipe recipe){
    	System.out.println();
        return recipeService.addRecipe(recipe);
    }

     @GetMapping("/recipes/{recipeId}")
    public Recipe get_Recipe_ById(@PathVariable("recipeId") int recipeId){

        return recipeService.getRecipeById(recipeId);
    } 
    
    @PutMapping("/recipes/{playerId}")
    public Recipe update_Recipe(@PathVariable("recipeId") int recipeId, @RequestBody Recipe recipe) {

        return recipeService.updateRecipe(recipeId, recipe);
    }

    @DeleteMapping("/recipes/{recipeId}")
    public void delete_Recipe(@PathVariable("recipeId") int recipeId) {
    
    	recipeService.deleteRecipe(recipeId);
        
    }

}
