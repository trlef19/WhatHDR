<p align="center">
<img src="https://m3-markdown-badges.vercel.app/stars/6/3/trlef19/WhatHDR">
<img src="https://ziadoua.github.io/m3-Markdown-Badges/badges/Kotlin/kotlin2.svg">
<img src="https://ziadoua.github.io/m3-Markdown-Badges/badges/LicenceGPLv3/licencegplv32.svg">
</p>

<p float="left">
<img src="/screenshots/Screenshot_0.png?raw=true" alt="screen that appears when device is incompatible" width="300"/>
<img src="/screenshots/Screenshot_1.png?raw=true" alt="main screen" width="300"/>
</p>

## About
WhatHDR is an app that notifies you when HDR content is being played on your phone.

## Motivation
I noticed that even though Smart TVs popped up a notification when HDR is being played for years now, there
was no such thing for Android devices. So I decided to make an app for it.

## Disclaimer
The app uses the [HdrSdrRatio](https://developer.android.com/reference/android/view/Display#isHdrSdrRatioAvailable()) in order to determine
if HDR is being played. Unfortunately this means the app is only compatible with _certain_ Android 14+ devices. This **doesn't** mean that your
device can't play HDR, it just means that this app can't detect its playback.
