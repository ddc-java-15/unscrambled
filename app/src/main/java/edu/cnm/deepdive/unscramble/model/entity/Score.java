package edu.cnm.deepdive.unscramble.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(tableName = "score",
    foreignKeys = {
        @ForeignKey(
            entity = Player.class,
            parentColumns = {"player_id"},
            childColumns = {"player_id"}
        )
    }
)
public class Score {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "score_id")
  private long id;

  @ColumnInfo(name = "displayed_score", index = true)
  private String displayedScore;

  @ColumnInfo(name = "player_id")
  private String playerID;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getDisplayedScore() {
    return displayedScore;
  }

  public void setDisplayedScore(String displayedScore) {
    this.displayedScore = displayedScore;
  }

  public String getPlayerID() {
    return playerID;
  }

  public void setPlayerID(String playerID) {
    this.playerID = playerID;
  }
}
