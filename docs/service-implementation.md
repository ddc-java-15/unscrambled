---
title: Implementation
description: Entity, repository, view and controller classes.
menu: Implementation
order: 30
---

## Service

### Entity Classes

* [`Player`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/entity/Player.java)
* [`Theme`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/entity/Theme.java)
* [`Difficulty`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/entity/Difficulty.java)
* [`Score`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/entity/Score.java)

### DAO Interfaces

* [`PlayerDao`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/dao/PlayerDao.java)
* [`ThemeDao`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/dao/ThemeDao.java)
* [`DifficultyDao`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/dao/DifficultyDao.java)
* [`ScoreDao`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/model/dao/ScoreDao.java)

### Database Class

* [`Unscrambled Database`](https://github.com/ddc-java-15/unscrambled/blob/main/app/src/main/java/edu/cnm/deepdive/unscrambled/service/UnscrambledDatabase.java)