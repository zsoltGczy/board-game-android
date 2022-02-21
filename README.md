# BoardGame

BoardGame is a simple Android project to rate board games [MVVM architecture](https://developer.android.com/jetpack/guide).
If you like a board game in the list, you can tap it to give it a star.

![Showcase](/docs/board_game_list_screenshot.png)

## Features
- 100% Kotlin
- MVVM architecture
- Reactive pattern
- Android Jetpack
- Kotlin Coroutines + Flow
- Dependency injection

## Tech stack
- [Android Jetpack](https://developer.android.com/jetpack) - A collections of libraries to help developers follow best practices, reduce boilerplate code, and write code that works consistently across Android versions and devices.
    - [Compose](https://developer.android.com/jetpack/androidx/releases/compose) - Define your UI programmatically with composable functions that describe its shape and data dependencies.
    - [Hilt](https://developer.android.com/jetpack/androidx/releases/hilt) - Extend the functionality of Dagger Hilt to enable dependency injection of certain classes from the androidx libraries.
    - [Lifecycle](https://developer.android.com/jetpack/androidx/releases/lifecycle) - Lifecycle-aware components that can adjust behavior based on the current lifecycle state of an activity or fragment.
    - [Room](https://developer.android.com/jetpack/androidx/releases/room) - Create, store, and manage persistent data backed by a SQLite database.
- [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
- [Moshi](https://github.com/square/moshi) - A modern JSON library for Kotlin and Java.
- [Logcat](https://github.com/square/logcat) - Tiny Kotlin API for cheap logging on top of Android's normal Log class.

## Development setup
You need [Android Studio Bumblebee](https://developer.android.com/studio) (or newer) to be able to build the app.

### Code style
This project uses [ktlint](https://github.com/pinterest/ktlint). Use the `ktlint` and `ktlint-format` Gradle tasks
to check and format according to proper Kotlin lint rules.
