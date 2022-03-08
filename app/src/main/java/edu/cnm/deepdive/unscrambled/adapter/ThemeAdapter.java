package edu.cnm.deepdive.unscrambled.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.unscrambled.adapter.ThemeAdapter.Holder;
import edu.cnm.deepdive.unscrambled.databinding.ItemThemeBinding;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<Holder> {

  private final List<Theme> themes;
  private Context context;
  private final LayoutInflater inflater;

  public ThemeAdapter(Context context, List<Theme> themes) {
    this.themes = themes;
    this.context = context;
    inflater = LayoutInflater.from(context);
  }

  @NonNull
  @Override
  public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    ItemThemeBinding binding = ItemThemeBinding.inflate(inflater, parent, false);
    return new Holder(binding);
  }

  @Override
  public void onBindViewHolder(@NonNull Holder holder, int position) {
    holder.bind(position);
  }

  @Override
  public int getItemCount() {
    return themes.size();
  }

  class Holder extends RecyclerView.ViewHolder {

    private final ItemThemeBinding binding;


    public Holder(@NonNull ItemThemeBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
      binding.getRoot();
    }

    private void bind(int position) {
      Theme theme = themes.get(position);
      binding.information.setText(theme.toString());
    }
  }
}
