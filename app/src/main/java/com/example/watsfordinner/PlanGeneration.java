package com.example.watsfordinner;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Arrays;
import java.util.Random;


/*
Algorithmically generate a meal plan based on user input.
 */


public class PlanGeneration {

    // Generates and returns a list of randomly selected meals

    public static String[][] meals;

    public static void generate(int[] inputList) {

        int i = 0;
        int x, y;
        Random r = new Random();
        int j = inputList[inputList.length - (i + 1)];                   // track currently generating difficulty
        Integer[] selected = new Integer[inputList.length];              // track already selected meals
        SharedPreferences.Editor edit = MainActivity.sharedPrefs.edit();

        // Clear old meal plan
        edit.remove(MainActivity.MEAL_PLAN);
        edit.putString((MainActivity.MEAL_PLAN), " ");
        edit.apply();

        for (; i < inputList.length; i++) {
            y = inputList[inputList.length - (i + 1)];              // find highest difficulty that needs generating
            if (j != y) {
                j = y;
                selected = new Integer[inputList.length];
            }

            while (true) {
                x = r.nextInt(meals[y].length);    // random selection in list of meals of selected difficulty
                if (Arrays.asList(selected).contains(x))
                    continue;

                // Write to MEAL_PLAN
                edit.putString(MainActivity.MEAL_PLAN, meals[j][x] + ",");
                edit.putString(MainActivity.MEAL_PLAN, j + ";");
                edit.apply();
                selected[i] = x;
                i++;
                break;
            }
        }
    }
}
