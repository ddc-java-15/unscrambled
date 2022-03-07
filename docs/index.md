---
title: Overview description: "Game of correctly forming an image from scrambled tiles."
menu: Overview order: 0
---

## Summary

This game takes a complete image and breaks it down into various numbers of images which it then
scrambles in a random order. The split image is placed into a frame with a single open spot, forcing
the user to re-order them correctly by sliding them around inside the framework in order to advance.
Advanced settings can be enabled that cause individual tiles to be randomly rotated as well as
breaking up the order in which they are placed. Additional difficulties and themes are unlocked via
gameplay, and high scores are stored both locally on the device and uploaded to the application
server to track overall high scores from the entire playerbase.

## Intended users

* Completionist mindset persons who have spare time to game.

  > As a detail oriented person who has a great deal of downtime whilst on the clock due to
  > the nature of my job, I need a game that allows me to indulge those tendencies. Playing this
  > game allows me to focus on completing the relatively simple but highly involved task of
  > completing an image and makes my day pass by much more quickly than it otherwise might.

* Individuals with children who need a short game to entertain their children for a short period,
  such as waiting in line in public.

  > As a stay at home parent, I take my children out with me while running errands, it helps to have
  > a simple game on my mobile device to hand them and keep them quiet until I have finished with my
  > business. My children are not only entertained, and thus not underfoot, but are given a sense
  > of accomplishment by completing the game's goals and unlocking different images for their
  > device's background.

## Functionality

1. Unlock higher difficulties by completing lower difficulties in a specific timeframe.

2. Keep track of completion times.

3. Unlock game images to use as mobile device backgrounds.

4. Select image themes, such as nature, space, or anime pictures.

5. Darkmode.

6. Audio settings (appropriate sounds for each theme set).

7. Log-in via Google.

## Persistent data

* Previous completion times.
* Current game progress.
* Current game settings.
* Personal and all-time high scores.

## Device/external services


* [Android Clock](https://developer.android.com/reference/kotlin/java/time/Clock?hl=en)

  * Unscrambled uses the Android Clock service to track the length of time a game has been played in
    order to weight the score of the game.
  * The application will function without access to the Android Clock, but any games played without
    access will not be eligible for placing in the application-wide 'High Scores' listing.

* [Android Gallery](https://developer.android.com/reference/android/widget/Gallery)

  * Unscrambled uses images from the gallery to load that image for each game instance.
  * The application will not be able to function without access to the Gallery.

* [Google sign_in](https://developers.google.com/identity/sign-in/android/start-integrating)
  * Distinguish between users and offer privacy on shared devices.
  * The application can be used without Google Sign In, but scores will not be recorded to the high score database.

* [Internet Connectivity](https://developer.android.com/guide/topics/connectivity)

  * Unscrambled uses network connectivity to upload scores to the application-wide 'High Scores'
    listing and to download images and themes from Pixabay.
  * The application will function without internet connectivity, but will be unable to access new
    themes or upload scores.
* [Pixabay](https://pixabay.com/api/docs/)

  * Unscrambled uses Pixabay to download theme albums to be available to the player. It stores the
    downloaded images in the Gallery.
  * The application will be functional without access to Pixabay, but will rely upon images already in
      the user's Android Gallery.




## Stretch goals/possible enhancements

Send invites and challenges to contacts in your Facebook profile.

Higher levels of difficulties.
