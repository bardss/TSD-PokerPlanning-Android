# Poker Planning Android

Poznan University of Technology

Software Engineering

Technologies of Software Project

### Project Backend

Application Backend is written in C# ASP.NET Core.

Repository: https://github.com/bardss/TSD-PokerPlanning

### Project Frontend

Application Frontend (Android mobile app) is written in Kotlin.

Repository: https://github.com/bardss/TSD-PokerPlanning-Android

### Authors:

* Jakub Anioła
* Paulina Sielicka
* Dmytro Zinkevych
* Крістіан Сік

## Maintenance

### 1. What are the tools needed to develop the application

![alt text](https://dl2.macupdate.com/images/icons256/51370.png?d=1526586897)

Only tool needed to develop Android application is ANDROID STUDIO (latest version - 3.1.3)
It can be downloaded here: https://developer.android.com/studio/
That IDE will also install all of the needed tools like SDK, Android Emulator.

### 2. How to configure the project on a developer's machine (database, webserver, etc.)

Only things needed to work with project is Android Studio with working emulator:
Here is full IDE initalizing instruction, step by step: https://drive.google.com/file/d/1I6lKsGHuZBA0X7LvO-EyAejYK7-A4cVM/view?usp=sharing (prepared by Jakub Anioła and Paulina Sielicka)

Cloned project is ready to Run in Android Studio on emulator.
Only thing that is needed to change is variable with string containing acutal IP address to backend (file: ServiceProvider.kt).

### 3. How to run tests

1. First way is easiest. Just click button in Android Studio

![alt text](https://image.ibb.co/c1ahxo/Screen_Shot_2018_06_08_at_21_24_42.png)

2. Use command "./gradlew testDebugUnitTest" in terminal

![alt text](https://image.ibb.co/jf9EA8/Screen_Shot_2018_06_08_at_21_27_43.png)

### 4. How to deploy the application to production

It is possible to create .apk file from Android Studio.
(.apk is executable file on Android systems)

![alt text](https://image.ibb.co/jWuBOT/Screen_Shot_2018_06_08_at_21_30_48.png)

This .apk file can be uploaded to Google Play Store.
