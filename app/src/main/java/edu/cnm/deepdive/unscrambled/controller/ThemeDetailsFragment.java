package edu.cnm.deepdive.unscrambled.controller;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.unscrambled.R;
import edu.cnm.deepdive.unscrambled.databinding.FragmentThemeDetailsBinding;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import edu.cnm.deepdive.unscrambled.viewmodel.ThemeViewModel;

public class ThemeDetailsFragment extends BottomSheetDialogFragment {

  private FragmentThemeDetailsBinding binding;
  private ThemeViewModel viewModel;
  private long themeId;
  private Theme theme;


  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ThemeDetailsFragmentArgs args = ThemeDetailsFragmentArgs.fromBundle(getArguments());
    themeId = args.getThemeId();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    binding = FragmentThemeDetailsBinding.inflate(inflater, container, false);
    binding.save.setOnClickListener((v) -> {
      theme.setPlayerId(1);//fixme use currently logged in user info.
      theme.setName(binding.information.getText().toString().trim());
      viewModel.save(theme);
      dismiss();
    });
    binding.cancel.setOnClickListener((v) -> dismiss());
    return binding.getRoot();
  }

  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    //noinspection ConstantConditions
    viewModel = new ViewModelProvider(getActivity()).get(ThemeViewModel.class);
    viewModel
        .getTheme()
        .observe(getViewLifecycleOwner(), (theme) -> {
          //TODO: populate view objects
        });
    if (themeId != 0) {
      viewModel.setThemeId(themeId);
    } else {
      theme = new Theme();
    }
  }
}





















