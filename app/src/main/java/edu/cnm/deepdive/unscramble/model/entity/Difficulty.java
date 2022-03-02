package edu.cnm.deepdive.unscramble.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "difficulty",
    foreignKeys = {
        @ForeignKey(
            entity = Player.class,
            parentColumns = {"player_id"},
            childColumns = {"player_id"}
        )
    }
)
public class Difficulty {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "difficulty_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "difficulty_name")
  private String difficultyName;

  @ColumnInfo(name = "player_id")
  private String playerID;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public String getDifficultyName() {
    return difficultyName;
  }

  public void setDifficultyName(@NonNull String difficultyName) {
    this.difficultyName = difficultyName;
  }

  public String getPlayerID() {
    return playerID;
  }

  public void setPlayerID(String playerID) {
    this.playerID = playerID;
  }
}
