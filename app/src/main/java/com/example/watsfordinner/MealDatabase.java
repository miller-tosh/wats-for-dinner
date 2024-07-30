package com.example.watsfordinner;

import android.content.SharedPreferences;

/*
List of meals inputted by the user to generate a plan from.
Meals are organized by difficulty of prep.
Difficulty levels can be adjusted and items can be removed from the list.
 */

public class MealDatabase {

    public String[][] meals;

    /*
    // Load in the list of meals from saved preferences
    public void loadMeals() {
        String[] temp;
        int lvl0, lvl1, lvl2, lvl3;
        lvl0 = lvl1 = lvl2 = lvl3 = 0;
        String rawList = MainActivity.sharedPrefs.getString(MainActivity.MEAL_LIST,"");
        String[] unsplitMeals = rawList.split(";");     // split by ";" to separate meals and associated difficulties

        for (int i = 0; i < unsplitMeals.length; i++){
            temp = unsplitMeals[i].split(",");          // split by "," to separate meals from difficulty levels

            // check level of meal and iterating in list
            if(Integer.parseInt(temp[0]) == 0){
                meals[Integer.parseInt(temp[0])][lvl0] = temp[1];
                lvl0++;
            }
            else if (Integer.parseInt(temp[0]) == 1){
                meals[Integer.parseInt(temp[0])][lvl1] = temp[1];
                lvl1++;
            }
            else if (Integer.parseInt(temp[0]) == 2){
                meals[Integer.parseInt(temp[0])][lvl2] = temp[1];
                lvl2++;
            }
            else if (Integer.parseInt(temp[0]) == 3){
                meals[Integer.parseInt(temp[0])][lvl3] = temp[1];
                lvl3++;
            }
        }
    }

    // Saves meal to saved preferences
    public void addMeal(String[] meal) {
        SharedPreferences.Editor edit = MainActivity.sharedPrefs.edit();
        String addedMeal = meal[0].concat(",").concat(meal[1]);     // added meal is difficulty number followed by name
        edit.putString(MainActivity.MEAL_LIST, addedMeal);
        edit.apply();
    }

    // Removes meal from saved preferences
    public void removeMeal(String[] meal){
        SharedPreferences.Editor edit = MainActivity.sharedPrefs.edit();
        int difficulty = Integer.parseInt(meal[0]);

        // *************
        for(int i = 0; i < meals[difficulty].length; i++) {  // check through meals of same difficulty
            if(meals[difficulty][i].equals(meal[1])) {
                meals[difficulty][i] = "";
            }
        }
        
        edit.apply();

        loadMeals();       // Reload meal list after update
    }

     */

}
