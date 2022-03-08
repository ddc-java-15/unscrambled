package edu.cnm.deepdive.unscrambled.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import edu.cnm.deepdive.unscrambled.databinding.FragmentHomeBinding;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import edu.cnm.deepdive.unscrambled.viewmodel.ThemeViewModel;

public class HomeFragment extends Fragment {


  private FragmentHomeBinding binding;
  private ThemeViewModel viewModel;

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    binding = FragmentHomeBinding.inflate(inflater, container, false);
    binding.create.setOnClickListener((v) -> {
      Navigation
          .findNavController(binding.getRoot())
          .navigate(HomeFragmentDirections.openDetails());
    });
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
    viewModel
        .getTheme()
        .observe(getViewLifecycleOwner(),this::handleTheme);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    binding = null;
  }

  private void handleTheme(Theme theme) {
    if(theme == null) {
      binding.themes.setAdapter(String.valueOf(0));
    }
  }
}
