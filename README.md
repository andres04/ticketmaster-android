# ticketmaster-android

## Introduction
Ticketmaster-android is a mobile application that shows a list of events from a JSON repository using modern frameworks and libraries.

## Project Description

### Architecture:

This app uses a clean architecture design principle that emphasizes separation of concerns and a well-structured codebase. It aims to create applications that are:

* Maintainable: By separating functionalities into distinct layers, clean architecture makes the code easier to understand, modify, and test in the long run.
* Testable: Independent layers allow you to write focused unit tests for specific functionalities without relying on external factors.
* Flexible: The core business logic is independent of the UI framework or data source implementation. This allows you to easily swap them out if needed, like switching from a local database to a remote server.

The app has the following layers:

#### Presentation Layer: 
This layer handles everything the user interacts with directly, like Composables, ViewModels, and UI-related components. This project uses The MVVM pattern, that consist in the following sublayers:

* Model: This layer represents the data used by the application. Includes plain data objects and mappers.
* View (Composable): This layer represents the UI of your application built with Jetpack Compose. It uses composables to declare the UI elements and their layout. The View shouldn't contain any business logic or data fetching logic.
* ViewModel: This layer acts as the intermediary between the View and the Model. It exposes the data and functionality the View needs in a way that's suitable for consumption by composables using kotlin flow and sealed classes that represent states. It also handles events from the View and updates the Model via functions.


Libraries used:
* Jetpack Compose
* Jetpack Navigation
* Material 3
* Kotlin Flow
* Koin
* Coil
* Kotlin coroutines


#### Domain Layer: 
This layer encapsulates the core functionalities and business rules of your application. Here we can found the following sublayers.

* Use cases: Represents the business logic. They are basically classes with the invoke() method overridden.
* Model: This layer represnts the classes model of the app, with data clesses and their relationships.
* Repository interfaces: Represents the repositories contracts that the data layer have to follow.

Libraries used:
* Koin

#### Data Layer: 
This layer handles how data is retrieved, stored, and manipulated. It includes local databases, network calls, or other data sources. Here we can found the following sublayers.

* Repository implementations: Classes that implement the funcionalities specified on the domain layer repositories.
* Data sources: This layer represnts network o database operations. 

Libraries used:
* Koin
* Ktor
* Kotilin Serialization


## Installation and Run
1. Clone this repository to a desired local folder
2. Download the latest version Android Studio (Jellyfish) and open the project with it
3. Build the project and run it using the IDE.

## Usage

It is just a simple list of events. Scroll it vertically if you want to see all the items

## License 

Copyright © 2024 Andrés Escobar. All rights reserved.
