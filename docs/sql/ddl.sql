CREATE TABLE IF NOT EXISTS `difficulty`
(
    `difficulty_id`   INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `difficulty_name` TEXT                              NOT NULL,
    `player_id`       INTEGER                           NOT NULL,
    FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_difficulty_difficulty_name` ON `difficulty` (`difficulty_name`);

CREATE INDEX IF NOT EXISTS `index_difficulty_player_id` ON `difficulty` (`player_id`);

CREATE TABLE IF NOT EXISTS `player`
(
    `player_id`        INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `player_gamer_tag` TEXT                              NOT NULL
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_player_player_gamer_tag` ON `player` (`player_gamer_tag`);

CREATE TABLE IF NOT EXISTS `score`
(
    `score_id`        INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `displayed_score` TEXT,
    `player_id`       INTEGER                           NOT NULL,
    FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE INDEX IF NOT EXISTS `index_score_displayed_score` ON `score` (`displayed_score`);

CREATE INDEX IF NOT EXISTS `index_score_player_id` ON `score` (`player_id`);

CREATE TABLE IF NOT EXISTS `theme`
(
    `theme_id`  INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
    `name`      TEXT                              NOT NULL,
    `player_id` INTEGER                           NOT NULL,
    FOREIGN KEY (`player_id`) REFERENCES `player` (`player_id`) ON UPDATE NO ACTION ON DELETE CASCADE
);

CREATE UNIQUE INDEX IF NOT EXISTS `index_theme_name` ON `theme` (`name`);

CREATE INDEX IF NOT EXISTS `index_theme_player_id` ON `theme` (`player_id`);

