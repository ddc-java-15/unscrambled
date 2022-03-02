package edu.cnm.deepdive.unscramble.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.UUID;

@Entity(tableName = "player")
public class Player {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "player_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "player_gamer_tag")
  private String playerGamerTag;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getPlayerGamerTag() {
    return playerGamerTag;
  }

  public void setPlayerGamerTag(@NonNull String playerGamerTag) {
    this.playerGamerTag = playerGamerTag;
  }
}
