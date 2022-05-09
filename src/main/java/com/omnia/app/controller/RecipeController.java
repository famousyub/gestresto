package com.omnia.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnia.app.exception.ResourceNotFoundException;
import com.omnia.app.model.Recipe;
import com.omnia.app.payload.ApiResponse;
import com.omnia.app.service.RecipeService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

	@Autowired
	private RecipeService recipeService;

	@PutMapping("/{categoryId}")
	public ResponseEntity<?> createRecipe(@Valid @RequestBody Recipe recipeRequest, @PathVariable long categoryId) {
		try {

			Recipe recipe = recipeService.createRecipe(recipeRequest, categoryId);

			return ResponseEntity.ok().body(new ApiResponse(true, recipe.getId(), "Recipe Created Successfully"));

		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "A Recipe with the same name exists already"));
		}
	}

	@PutMapping("/update/{recipeId}")
	public ResponseEntity<?> updateRecipe(@Valid @RequestBody Recipe recipeRequest, @PathVariable long recipeId) {
		try {
			Recipe recipe = recipeService.updateRecipe(recipeId, recipeRequest);

			return ResponseEntity.ok().body(new ApiResponse(true, recipe.getId(), "Recipe Updated Successfully"));
		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "A Recipe with the same name exists already"));
		}
	}

	@PutMapping("/{recipeId}/{level}")
	public ResponseEntity<?> switchLevelCategory(@Valid @RequestBody Recipe recipeRequest, @PathVariable long recipeId,
			@PathVariable long level) {
		try {
			List<Recipe> recipes = recipeService.switchLevelRecipe(recipeRequest, recipeId, level);

			return ResponseEntity.ok()
					.body(new ApiResponse(true, recipes.get(0).getId(), "changed levels of categories with IDs : "
							+ recipes.get(0).getId() + "/" + recipes.get(1).getId()));

		} catch (ResourceNotFoundException e) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, e.getMessage()));
		} catch (DataIntegrityViolationException ex) {
			return ResponseEntity.badRequest()
					.body(new ApiResponse(false, "A Category with the same name exists already"));
		}

	}

	@DeleteMapping("/{recipeId}")
	public ResponseEntity<?> deleteRecipe(@PathVariable long recipeId) {
		try {
			recipeService.deleteRecipe(recipeId);
			return ResponseEntity.ok().body(new ApiResponse(true, "Recipe Deleted Successfully"));
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, ex.getMessage()));
		}
	}

	@GetMapping("/{categoryId}")
	public ResponseEntity<?> getRecipesByCategory(@PathVariable long categoryId) {

		try {
			System.out.println(categoryId);
			List<Recipe> recipes = recipeService.getRecipesByCategory(categoryId);
			return ResponseEntity.ok(recipes);
		} catch (ResourceNotFoundException ex) {
			return ResponseEntity.badRequest().body(new ApiResponse(false, ex.getMessage()));
		}

	}

}