package edu.cnm.deepdive.unscrambled.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(
    tableName = "theme",
    foreignKeys = {
        @ForeignKey(
            entity = Player.class,
            parentColumns = {"player_id"},
            childColumns = {"player_id"},
            onDelete = ForeignKey.CASCADE
        )
    },
    indices = @Index(value = "name", unique = true)
)
public class Theme {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "theme_id")
  private long id;

  @NonNull
  private String name;

  @ColumnInfo(name = "player_id", index = true)
  private long playerId;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getName() {
    return name;
  }

  public void setName(@NonNull String name) {
    this.name = name;
  }

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
    this.playerId = playerId;
  }

}
