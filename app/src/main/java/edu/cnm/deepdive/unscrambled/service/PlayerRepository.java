package edu.cnm.deepdive.unscrambled.service;

import android.content.Context;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.unscrambled.model.dao.PlayerDao;
import edu.cnm.deepdive.unscrambled.model.entity.Player;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import java.util.List;

public class PlayerRepository {

  private final Context context;
  private final PlayerDao playerDao;


  public PlayerRepository(Context context) {
    this.context = context;
    UnscrambledDatabase database = UnscrambledDatabase.getInstance();
    playerDao = database.getPlayerDao();
  }

  public LiveData<Player> get(long id) {
      return playerDao.select(id);
  }

  public LiveData<List<Player>> getAll() {
    return playerDao.select();
  }

  public Single<Player> save(Player player) {
    return (
        (player.getId() == 0)
        ? playerDao
            .insert(player)
            .map((id) -> {
              player.setId(id);
              return player;
            })
        : playerDao
            .update(player)
            .map((count) -> player)
    )
        .subscribeOn(Schedulers.io());
  }

  public Completable delete(Player player) {

    return (
        (player.getId() == 0)
        ? Completable.complete()
        : playerDao
            .delete(player)
            .ignoreElement()
    )
        .subscribeOn(Schedulers.io());
  }

}








