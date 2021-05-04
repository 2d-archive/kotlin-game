import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  java
  idea
  kotlin("jvm") version Versions.kotlin
}

group = "fun.dimensional.games"
version = "0.0.1"

repositories {
  mavenCentral()
}

dependencies {
  /* kotlin */
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}")

  /* game related things */
  implementation("com.badlogicgames.gdx:gdx:${Versions.gdx}")
  implementation("com.badlogicgames.gdx:gdx-backend-lwjgl:${Versions.gdx}")
  implementation("com.badlogicgames.gdx:gdx-platform:${Versions.gdx}:natives-desktop")

  implementation("io.github.libktx:ktx-app:${Versions.libKtx}")
  implementation("io.github.libktx:ktx-graphics:${Versions.libKtx}")
  implementation("io.github.libktx:ktx-log:${Versions.libKtx}")
}

tasks.withType<KotlinCompile> {
  kotlinOptions.jvmTarget = "1.8"
}