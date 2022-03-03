package edu.cnm.deepdive.unscrambled.viewmodel;

import android.app.Application;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import edu.cnm.deepdive.unscrambled.service.ThemeRepository;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.List;

public class ThemeViewModel extends AndroidViewModel implements DefaultLifecycleObserver {

  private final ThemeRepository repository;
  private final LiveData<Theme> theme;
  private final MutableLiveData<Throwable> throwable;
  private final MutableLiveData<Long> themeId;
  private final CompositeDisposable pending;


  public ThemeViewModel(@NonNull Application application) {
    super(application);
    repository = new ThemeRepository(application);
    themeId = new MutableLiveData<>();
    theme = Transformations.switchMap(themeId, repository::get);
    throwable = new MutableLiveData<>();
    pending = new CompositeDisposable();
  }

  @Override
  public void onStop(@NonNull LifecycleOwner owner) {
    DefaultLifecycleObserver.super.onStop(owner);
    pending.clear();
  }

  public LiveData<Theme> getTheme() {
    return theme;
  }

  public LiveData<Throwable> getThrowable() {
    return throwable;
  }

  public LiveData<List<Theme>> getThemes() {
    return repository.getAll();
  }

  public void save(Theme theme) {
    Disposable disposable = repository
        .save(theme)
        .subscribe(
            (t) -> {},
            this::postThrowable
        );
    pending.add(disposable);
  }

  public void delete(Theme theme) {
    //noinspection ResultOfMethodCallIgnored
    repository
        .delete(theme)
        .subscribe(
            () -> {},
            this::postThrowable
        );
  }

  public void setThemeId(long id) {
    themeId.setValue(id);
  }

  private void postThrowable(Throwable throwable) {
    Log.e(getClass().getSimpleName(), throwable.getMessage(), throwable);
    this.throwable.postValue(throwable);
  }

}















