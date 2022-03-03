package edu.cnm.deepdive.unscrambled.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.unscrambled.model.entity.Score;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface ScoreDao {

  @Insert
  Single<Long> insert(Score score);

  @Insert
  Single<List<Long>> insert(Score... scores);

  @Insert
  Single<List<Long>> insert(Collection<Score> scores);

  @Update
  Single<Integer> update(Score score);

  @Update
  Single<Integer> update(Score... scores);

  @Update
  Single<Integer> update(Collection<Score> scores);

  @Delete
  Single<Integer> delete(Score score);

  @Delete
  Single<Integer> delete(Score... scores);

  @Delete
  Single<Integer> delete(Collection<Score> scores);

  @Query("SELECT * FROM score WHERE score_id = :id")
  LiveData<Score> select(long id);

  @Query("SELECT * FROM score ORDER BY displayed_score ASC")
  LiveData<List<Score>> select();
}
