package com.example.watsfordinner;

import android.content.SharedPreferences;
import android.os.Bundle;

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


    public static boolean updateSettings = true;
    public static SharedPreferences sharedPrefs;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(sharedPrefs.getBoolean(SETTINGS_INITIALIZED, false))
            initializeSettings();


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
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