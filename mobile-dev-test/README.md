# Clean_Architecture_Template_News

## Prerequisite

minSdkVersion -> 21

Gradle build system

Kotlin

You do not need an API key for this project

## TOC

- [Architecture](#architecture)
- [Libraries](#libraries)
- [Extras](#extras)

## Architecture

The App is not organized into multiple modules following the principles of the Presentation, Domain,
and Data Layers. The presentation layer handles the UI work with the logic contained in the **
ViewModel**. The UI uses a **LiveData** object from the ViewModel and observes it using the **
Observer Pattern**. A ListAdapter handles the actual displaying of the news. Data over the network
is retrieved using
**retrofit**, **Flow** and **coroutines** to handle background work asynchronously. Additionally,
note that the ViewModel uses the **viewModelScope** to launch the couroutines while Fragments use
the **viewLifeCycleOwner**
to observe data.

## Libraries

This app takes use of the following libraries:

- [Jetpack](https://developer.android.com/jetpack)🚀
    - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI
      data to survive configuration changes and is lifecycle-aware
    - [Navigation](https://developer.android.com/guide/navigation/) - Handle everything needed for
      in-app navigation
    - [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - The new stream processing
      API
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Notify views
      when data changes
- [Retrofit](https://square.github.io/retrofit/) - type safe http client with coroutines support
- [Moshi](https://github.com/square/moshi) - Modern JSON library for Android and Java
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Injection
  library for Android that reduces
- [okhttp-logging-interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md)
  - logging HTTP request related data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for
  coroutines
- [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API which
  provides utility on top of Android's normal Log class.

