package edu.cnm.deepdive.unscrambled.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import edu.cnm.deepdive.unscrambled.model.entity.Player;
import io.reactivex.rxjava3.core.Single;
import java.util.Collection;
import java.util.List;

@Dao
public interface PlayerDao {

  @Insert
  Single<Long> insert(Player player);

  @Insert
  Single<List<Long>> insert(Player... players);

  @Insert
  Single<List<Long>> insert(Collection<Player> players);

  @Update
  Single<Integer> update(Player player);

  @Update
  Single<Integer> update(Player... players);

  @Update
  Single<Integer> update(Collection<Player> players);

  @Delete
  Single<Integer> delete(Player player);

  @Delete
  Single<Integer> delete(Player... players);

  @Delete
  Single<Integer> delete(Collection<Player> players);

  @Query("SELECT * FROM player WHERE player_id = :id")
  LiveData<Player> select(long id);

  @Query("SELECT * FROM player ORDER BY player_gamer_tag ASC")
  LiveData<List<Player>> select();
}












