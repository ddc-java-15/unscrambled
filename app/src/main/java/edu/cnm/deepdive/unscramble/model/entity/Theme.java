package edu.cnm.deepdive.unscramble.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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
    }
)
public class Theme {

  @PrimaryKey(autoGenerate = true)
  @ColumnInfo(name = "theme_id")
  private long id;

  @NonNull
  @ColumnInfo(name = "theme_name")
  private String name;

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

}
