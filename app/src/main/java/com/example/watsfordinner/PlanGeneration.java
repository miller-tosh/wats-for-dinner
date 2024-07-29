package com.example.watsfordinner;
import java.util.Arrays;
import java.util.Random;


/*
Algorithmically generate a meal plan based on user input.
 */


public class PlanGeneration {

    // Generates and returns a list of randomly selected meals

    public String[][] meals;

    public String[] generate(int[] inputList) {

        int i = 0;
        int x, y;
        Random r = new Random();
        int j = inputList[inputList.length - (i + 1)];              // track currently generating difficulty
        Integer[] selected = new Integer[inputList.length];         // track already selected meals
        String[] plan = new String[inputList.length];               // the final meal plan

        for (;i < inputList.length;) {
            y = inputList[inputList.length - (i + 1)];              // find highest difficulty that needs generating
            if (j != y) {
                j = y;
                selected = new Integer[inputList.length];
            }

            while (true) {
                x = r.nextInt(meals[y].length);    // random selection in list of meals of selected difficulty
                if (Arrays.asList(selected).contains(x))
                    continue;
                plan[i] =  meals[j][x];
                selected[i] = x;
                i++;
                break;
            }
        }
        return plan;
    }
}
