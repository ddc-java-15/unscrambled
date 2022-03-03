package edu.cnm.deepdive.unscrambled.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import edu.cnm.deepdive.unscrambled.NavigationMapDirections;
import edu.cnm.deepdive.unscrambled.R;
import edu.cnm.deepdive.unscrambled.databinding.ActivityMainBinding;
import edu.cnm.deepdive.unscrambled.viewmodel.ThemeViewModel;

public class MainActivity extends AppCompatActivity {

  private ActivityMainBinding binding;
  private ThemeViewModel viewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    viewModel = new ViewModelProvider(this).get(ThemeViewModel.class);
    setContentView(binding.getRoot());
    NavController navController = ((NavHostFragment) getSupportFragmentManager()
        .findFragmentById(R.id.nav_host_fragment))
        .getNavController();
    binding.create.setOnClickListener((v) -> {
      navController.navigate(NavigationMapDirections.openDetails());
    });
  }
}