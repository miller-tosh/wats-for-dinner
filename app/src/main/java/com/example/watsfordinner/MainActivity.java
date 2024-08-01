package com.example.watsfordinner;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.watsfordinner.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    // Saved settings strings
    public static final String MEAL_PLAN = "mealPlan";      // the generated plan
    public static final String MEAL_LIST = "mealDB";        // the list of meals to generate from
    public static final String SETTINGS_INITIALIZED = "initialized";

    TextView recipeName;
    TextView recipeLevel;


    // Button ID's
    Button saveResult;
    Button editMeal;

    public static SharedPreferences sharedPrefs;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Access shared preferences and initialize if needed
        sharedPrefs = getApplicationContext().getSharedPreferences("appPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPrefs.edit();
        if(sharedPrefs.getBoolean(SETTINGS_INITIALIZED, false))
            initializeSettings();
        else
            edit.apply();

        // Set button ID's
        saveResult = findViewById(R.id.save_button);
        // editMeal = findViewById(R.id.edit_button);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    // If saved preferences haven't been initialized yet
    public void initializeSettings(){
        SharedPreferences.Editor edit = sharedPrefs.edit();
        edit.putString(MEAL_PLAN, " ");
        edit.putString(MEAL_LIST, " ");
        edit.putBoolean(SETTINGS_INITIALIZED, true);

        edit.apply();
    }



}