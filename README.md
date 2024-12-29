# Notflix

Notflix is a simple Android application inspired by Netflix's UI design. It allows users to view a list of top-rated movies and browse movies utilizing RecyclerView, Firebase, Room, Material3 and more. The app stores data locally using Room and integrates with Firebase for authentication and Firestore storage.

## Features

- **Top-Rated Movies**: View a curated list of top-rated movies.
- **Movie Listing**: Browse a list of movies using a RecyclerView.
- **Local Storage**: Save and retrieve data locally using Room.
- **Authentication**: Sign in and manage user authentication with Firebase.
- **Modern UI**: Netflix-inspired design using Material Design principles.

## Screenshots
![image](https://github.com/user-attachments/assets/9b083e43-6b0b-4f7a-88d9-cab8aef7b4db)
![image](https://github.com/user-attachments/assets/2c98fee3-4d02-4cf0-b02e-5ed39e6177f4)
![image](https://github.com/user-attachments/assets/e0df03b8-5378-491f-a40a-5fda782252d4) 


## Getting Started

### Prerequisites

- Android Studio (latest version recommended)
- Minimum SDK: 21
- Compile SDK: 33

### Installation

1. Clone this repository:
    ```bash
    git clone https://github.com/rifaset123/Notflix.git
    ```

2. Open the project in Android Studio.

3. Sync the project to download dependencies:
    - Go to **File > Sync Project with Gradle Files**.

4. Set up Firebase:
    - Add your `google-services.json` file to the `app/` directory.

5. Build and run the app on an emulator or physical device.

## Dependencies

The app uses the following libraries:

```groovy
// Core Android libraries
implementation("androidx.core:core-ktx:1.9.0")
implementation("androidx.appcompat:appcompat:1.6.1")
implementation("com.google.android.material:material:1.10.0")
implementation("androidx.constraintlayout:constraintlayout:2.1.4")

// Firebase
implementation("com.google.firebase:firebase-auth:22.3.0")
implementation("com.google.firebase:firebase-firestore:24.10.0")
implementation("com.google.firebase:firebase-storage:20.3.0")

// Testing
testImplementation("junit:junit:4.13.2")
androidTestImplementation("androidx.test.ext:junit:1.1.5")
androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

// Glide for image loading
implementation("com.github.bumptech.glide:glide:4.16.0")
annotationProcessor("com.github.bumptech.glide:compiler:4.14.2")

// Rounded Image View
implementation("com.makeramen:roundedimageview:2.3.0")

// Room for local database
implementation("androidx.room:room-runtime:2.4.0")
kapt("androidx.room:room-compiler:2.4.0")

// GIF support
implementation("pl.droidsonroids.gif:android-gif-drawable:1.2.23")
