package edu.cnm.deepdive.unscrambled.controller;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import edu.cnm.deepdive.unscrambled.R;
import edu.cnm.deepdive.unscrambled.databinding.FragmentThemeDetailsBinding;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import edu.cnm.deepdive.unscrambled.model.entity.Theme.ThemeName;
import edu.cnm.deepdive.unscrambled.viewmodel.ThemeViewModel;

public class ThemeDetailsFragment extends BottomSheetDialogFragment implements OnClickListener {

  private FragmentThemeDetailsBinding binding;
  private ThemeViewModel viewModel;
  private long themeId;
  private Theme theme;
  private ThemeName themeName;


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
      theme = new Theme();
      theme.setPlayerId(1);//fixme use currently logged in user info.
      theme.setThemeName(themeName);
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

    setThemeName();

  }

  private void setThemeName() {
    binding.classicArt.setOnClickListener(this);
    binding.fractals.setOnClickListener(this);
    binding.marvel.setOnClickListener(this);
    binding.nature.setOnClickListener(this);
  }

  @Override
  public void onClick(View view) {
    boolean checked = ((RadioButton) view).isChecked();
    switch (view.getId()) {
      case R.id.classic_art:
        if (checked) {
          themeName = ThemeName.CLASSIC_ART;
        }
        break;
      case R.id.fractals:
        if (checked) {
          themeName = ThemeName.FRACTALS;
        }
        break;
      case R.id.marvel:
        if (checked) {
          themeName = ThemeName.MARVEL;
        }
        break;
      case R.id.nature:
        if (checked) {
          themeName = ThemeName.NATURE;
        }
        break;
    }
  }
}





















