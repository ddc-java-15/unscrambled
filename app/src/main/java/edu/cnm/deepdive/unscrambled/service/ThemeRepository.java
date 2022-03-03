package edu.cnm.deepdive.unscrambled.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.unscrambled.model.dao.ThemeDao;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;

public class ThemeRepository {

  private final Context context;
  private final ThemeDao themeDao;


  public ThemeRepository(Context context) {
    this.context = context;
    UnscrambledDatabase database = UnscrambledDatabase.getInstance();
    themeDao = database.getThemeDao();
  }

  public LiveData<Theme> get(long id) {
    return themeDao.select(id);
  }

  public LiveData<List<Theme>> getAll() {
    return themeDao.select();
  }

  public Single<Theme> save(Theme theme) {
    return (
        (theme.getId() == 0)
            ? themeDao
            .insert(theme)
            .map((id) -> {
              theme.setId(id);
              return theme;
            })
            : themeDao
                .update(theme)
                .map((count) -> theme)
    )
        .subscribeOn(Schedulers.io());
  }

  public Completable delete(Theme theme) {

    return (
        (theme.getId() == 0)
            ? Completable.complete()
            : themeDao
                .delete(theme)
                .ignoreElement()
    )
        .subscribeOn(Schedulers.io());
  }

}
