package edu.cnm.deepdive.unscrambled.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.unscrambled.model.entity.Difficulty;
import edu.cnm.deepdive.unscrambled.model.entity.Score;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface DifficultyDao {

  @Insert
  Single<Long> insert(Difficulty difficulty);

  @Insert
  Single<List<Long>> insert(Difficulty... difficulties);

  @Insert
  Single<List<Long>> insert(Collection<Difficulty> difficulties);

  @Update
  Single<Integer> update(Difficulty difficulty);

  @Update
  Single<Integer> update(Difficulty... difficulties);

  @Update
  Single<Integer> update(Collection<Difficulty> difficulties);

  @Delete
  Single<Integer> delete(Difficulty difficulty);

  @Delete
  Single<Integer> delete(Difficulty... difficulties);

  @Delete
  Single<Integer> delete(Collection<Difficulty> difficulties);

  @Query("SELECT * FROM difficulty WHERE difficulty_id = :id")
  LiveData<Difficulty> select(long id);

  @Query("SELECT * FROM difficulty ORDER BY difficulty_id ASC")
  LiveData<List<Difficulty>> select();
}
