# Project Setup Guide

This comprehensive guide will assist you in setting up your development environment on a fresh PC, including Maven, Java 8, Appium, and the Android SDK for mobile app testing.

## Prerequisites

Before you begin, ensure that you have the following prerequisites installed on your machine:

1. **Java 8**: Maven and Appium are compatible with Java 8. Download and install it from the [official Oracle website](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html).

2. **Maven**: Download the latest version from the [official Apache Maven website](https://maven.apache.org/download.cgi) and follow the installation instructions.

3. **Node.js**: Appium is a Node.js server. Download and install Node.js from the [official Node.js website](https://nodejs.org/).

4. **Appium**: After installing Node.js, open a terminal and run the following command to install Appium globally:

    ```bash
    npm install -g appium
    ```

5. **Android SDK**: Download and install the Android SDK. You can obtain it as part of Android Studio or separately. Follow the instructions on the [official Android developer website](https://developer.android.com/studio#downloads) to install the SDK.

## Environment Variables

Set the necessary environment variables after installing Java, Maven, and Android SDK:

1. **JAVA_HOME**: Set this variable to the installation path of your Java JDK. For example:

    ```bash
    export JAVA_HOME=/path/to/your/java/installation
    ```

2. **M2_HOME**: Set this variable to the installation path of Maven. For example:

    ```bash
    export M2_HOME=/path/to/your/maven/installation
    ```

3. **ANDROID_HOME**: Set this variable to the installation path of your Android SDK. For example:

    ```bash
    export ANDROID_HOME=/path/to/your/android/sdk
    ```

4. **PATH**: Add the following to your PATH environment variable:

    ```bash
    export PATH=$PATH:$JAVA_HOME/bin:$M2_HOME/bin:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
    ```

## Verify Installations

To ensure that Java, Maven, Appium, and the Android SDK are installed correctly, open a terminal and run the following commands:

1. **Java:**

    ```bash
    java -version
    ```

2. **Maven:**

    ```bash
    mvn -version
    ```

3. **Appium:**

    ```bash
    appium -v
    ```

4. **Android SDK:**

    ```bash
    sdkmanager --version
    ```

## Running Tests from Terminal

1. Open a terminal and start the Appium server:

    ```bash
    mvn clean test
    ```

Congratulations! Your PC is now equipped with Maven, Java 8, Appium, and the Android SDK. You're ready to commence mobile application development and testing.