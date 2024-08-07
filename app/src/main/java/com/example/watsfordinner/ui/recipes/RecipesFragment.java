package com.example.watsfordinner.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.watsfordinner.R;
import com.example.watsfordinner.databinding.FragmentRecipesBinding;

public class RecipesFragment extends Fragment {

    private Button saveButton;
    private FragmentRecipesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecipesViewModel recipesViewModel =
                new ViewModelProvider(this).get(RecipesViewModel.class);

        binding = FragmentRecipesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        saveButton = root.findViewById(R.id.save_button);

        // Create listener for generate button
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "Saved", Toast.LENGTH_SHORT).show();
            }
        });

        final TextView textView = binding.textRecipes;
        recipesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        saveButton = null;
    }
}