package com.example.watsfordinner.ui.generate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.watsfordinner.R;
import com.example.watsfordinner.databinding.FragmentGenerateBinding;
import com.example.watsfordinner.MealDatabase;
import com.example.watsfordinner.PlanGeneration;

public class GenerationFragment extends Fragment {

    private Button generateButton;
    private Spinner level0, level1, level2, level3;
    private String lvl0s, lvl1s, lvl2s, lvl3s;                  // how many of each level are selected
    private FragmentGenerateBinding binding;

    String[] spinnerItems = new String[]{"1","2","3","4","5","6","7"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GenerationViewModel notificationsViewModel =
                new ViewModelProvider(this).get(GenerationViewModel.class);

        // Get id's for views and widgets
        binding = FragmentGenerateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        generateButton = root.findViewById(R.id.generate_button);

        lvl0s = lvl1s = lvl2s = lvl3s = "1";

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, spinnerItems);
        level0 = root.findViewById(R.id.spinner0);
        level0.setAdapter(adapter);
        level1 = root.findViewById(R.id.spinner1);
        level1.setAdapter(adapter);
        level2 = root.findViewById(R.id.spinner2);
        level2.setAdapter(adapter);
        level3 = root.findViewById(R.id.spinner3);
        level3.setAdapter(adapter);

        // Create listener for "change level" spinners
        level0.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lvl0s = (i + 1) + " ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        level1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lvl1s = (i + 1) + " ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        level2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lvl2s = (i + 1) + " ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        level3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                lvl3s = (i + 1) + " ";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Setup notifications
        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // Create listener for generate button
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Make sure there are enough recipes to generate a full meal plan
                if(MealDatabase.meals == null || (Integer.parseInt(lvl0s) + Integer.parseInt(lvl1s) + Integer.parseInt(lvl2s) + Integer.parseInt(lvl3s) < MealDatabase.meals.length)){
                    Toast.makeText(view.getContext(), "Not enough recipes in database", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Create input list for generation
                int[] inputList = new int[4];
                inputList[0] = Integer.parseInt(lvl0s);
                inputList[1] = Integer.parseInt(lvl1s);
                inputList[2] = Integer.parseInt(lvl2s);
                inputList[3] = Integer.parseInt(lvl3s);

                // Get generated list
                PlanGeneration.generate(inputList);

                // Switch to home view and display generated plan
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        generateButton = null;
    }
}