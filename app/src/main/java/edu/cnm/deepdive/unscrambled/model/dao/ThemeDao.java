package edu.cnm.deepdive.unscrambled.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.unscrambled.model.entity.Theme;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ThemeDao {

  @Insert
  Single<Long> insert(Theme theme);

  @Insert
  Single<List<Long>> insert(Theme... themes);

  @Insert
  Single<List<Long>> insert(Collection<Theme> themes);

  @Update
  Single<Integer> update(Theme theme);

  @Update
  Single<Integer> update(Theme... themes);

  @Update
  Single<Integer> update(Collection<Theme> themes);

  @Delete
  Single<Integer> delete(Theme theme);

  @Delete
  Single<Integer> delete(Theme... themes);

  @Delete
  Single<Integer> delete(Collection<Theme> themes);

  @Query("SELECT * FROM theme WHERE theme_id = :id")
  LiveData<Theme> select(long id);

  @Query("SELECT * FROM theme ORDER BY name ASC")
  LiveData<List<Theme>> select();
}
