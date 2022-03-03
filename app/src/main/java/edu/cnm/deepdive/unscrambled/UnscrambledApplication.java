package edu.cnm.deepdive.unscrambled;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.unscrambled.service.UnscrambledDatabase;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Initializes (in the {@link #onCreate()} method) application-level resources. This class
 * <strong>must</strong> be referenced in {@code AndroidManifest.xml}, or it will not be loaded and
 * used by the Android system.
 */
public class UnscrambledApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    UnscrambledDatabase.setContext(this);
    UnscrambledDatabase
        .getInstance()
        .getPlayerDao()
        .delete()
        .subscribeOn(Schedulers.io())
        .subscribe();
  }

}
