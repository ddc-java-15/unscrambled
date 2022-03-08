package edu.cnm.deepdive.unscrambled.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;


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
  private ThemeName themeName;

  @ColumnInfo(name = "player_id", index = true)
  private long playerId;



  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  @NonNull
  public ThemeName getThemeName() {
    return themeName;
  }

  public void setThemeName(@NonNull ThemeName themeName) {
    this.themeName = themeName;
  }

  public enum ThemeName {
    NATURE,
    FRACTALS,
    MARVEL,
    CLASSIC_ART;

    @TypeConverter
    public static Integer themeNameToInteger(ThemeName name) {
      return (name != null) ? name.ordinal() : null;
    }

    @TypeConverter
    public static ThemeName integerToThemeName(Integer index) {
      return (index != null) ? ThemeName.values()[index] : null;
    }
  }

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
    this.playerId = playerId;
  }

}
