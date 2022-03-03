package edu.cnm.deepdive.unscrambled.service;

import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import edu.cnm.deepdive.unscrambled.model.dao.DifficultyDao;
import edu.cnm.deepdive.unscrambled.model.dao.PlayerDao;
import edu.cnm.deepdive.unscrambled.model.dao.ScoreDao;
import edu.cnm.deepdive.unscrambled.model.dao.ThemeDao;
import edu.cnm.deepdive.unscrambled.model.entity.Difficulty;
import edu.cnm.deepdive.unscrambled.model.entity.Player;
import edu.cnm.deepdive.unscrambled.model.entity.Score;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import edu.cnm.deepdive.unscrambled.service.UnscrambledDatabase.Converters;
import java.util.Date;

@Database(
    entities = {Difficulty.class, Player.class, Score.class, Theme.class},
    version = 1
)
@TypeConverters({Converters.class})
public abstract class UnscrambledDatabase extends RoomDatabase {

  private static final String DB_NAME = "unscrambled-db";

  private static Application context;

  public static void setContext(Application context) {
    UnscrambledDatabase.context = context;
  }

  public static UnscrambledDatabase getInstance() {
    return InstanceHolder.INSTANCE;
  }

  public abstract DifficultyDao getDifficultyDao();

  public abstract PlayerDao getPlayerDao();

  public abstract ScoreDao getScoreDao();

  public abstract ThemeDao getThemeDao();

  private static class InstanceHolder {

    private static final UnscrambledDatabase INSTANCE = Room
        .databaseBuilder(context, UnscrambledDatabase.class, DB_NAME)
        .build();
  }

  public static class Converters {

    @TypeConverter
    public static Long toLong(Date value) {
      return (value != null) ? value.getTime() : null;
    }

    @TypeConverter
    public static Date toDate(Long value) {
      return (value != null) ? new Date(value) : null;
    }
  }

}
