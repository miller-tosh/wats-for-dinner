package com.example.watsfordinner.ui.generate;

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
import com.example.watsfordinner.databinding.FragmentGenerateBinding;

public class GenerationFragment extends Fragment {

    private Button generateButton;
    private FragmentGenerateBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GenerationViewModel notificationsViewModel =
                new ViewModelProvider(this).get(GenerationViewModel.class);

        binding = FragmentGenerateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        generateButton = root.findViewById(R.id.generate_button);

        // Create listener for generate button
        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "whoa! google chrome", Toast.LENGTH_SHORT).show();
            }
        });

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        generateButton = null;
    }
}