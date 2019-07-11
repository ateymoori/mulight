# Android Architecture Component (MVVM): Sample Gallery App

<img src="http://devcast.ir/mulight.png" alt="Android Architecture " width=200 />

This repository contains a sample Android application that implements MVVM Android architecture component using:
    Kotlin, LiveData, Android Navigation Component(single Activity), ViewModel, Repository pattern, Observable Pattern, Room, File provider, RxJava and Android Test.

Sample APK:
<a href="http://devcast.ir/1.0.7_muLight-debug.apk">http://devcast.ir/1.0.7_muLight-debug.apk</a>

<img src="http://devcast.ir/schema.png" alt="Android Architecture " width=600 />


<img src="http://devcast.ir/ml1.png" alt="Android Architecture " width=220 /> <img src="http://devcast.ir/ml2.png" alt="Android Architecture " width=220 /> <img src="http://devcast.ir/ml3.png" alt="Android Architecture " width=220 />

## Technologies:

* Kotlin as Main language(modern and clean codes-null safe-developing easier than Java)
* MVVM as architecture
* Android navigation component for single Activity and user more fragment instead of Activities(better performance-have reusable codes)
* Android LiveData (avoid memory leak - remove direct connections between layers)
* Repository pattern(have reusable, clean and independent codes)
* Room as ORM (because it support LiveData very well)
* File provider(to access Storage)
* Junit for Android test


Version 1.0.7 *(July 11, 2019 )*
----------------------------

 * Fix: Take photo and store image bug fixed. now i am using External storage and File provider.
 * Add: Image viewer not support zoom in/zoom out but multi touching.
         
Version 1.0.6 *(July 11, 2019 )*
----------------------------

 * Challenge: I wanted to take and store photo in Internal Storage for avoid get new permission(Write External Storage),
              but i figured out that, Android just save low quality of images in Internal Storage as a thumbnail.
              If i want to have high quality of images, i should use External storage and get extra permission.
              Using external storage is not easy like before, i should use File Provider.

Version 1.0.5 *(July 11, 2019 )*
----------------------------

 * Add: Complete Android Tests. Add Image Viewer and clean codes.
 

Version 1.0.4 *(July 10, 2019 )*
----------------------------

 * Add: Android Test by JUnit 4.
        2 Test module has been added to test DatabaseDAO(CRUD) and Public methods (Store file in Storage)  
 
Version 1.0.3 *(July 10, 2019 )*
----------------------------

 * Add: Store image in Internal storage.
 * Add: Store image data in Local database by room.
 * Note: I'm using Room because it supports LiveData and Observable pattern very perfect.
 
Version 1.0.2 *(July 9, 2019 )*
----------------------------

 * Add: TakePhotoFragment and it's ViewModel (Observable pattern with RX and Android Life Cycle).
     connect dashboard Fragment to TakePhoto in Android Navigation
 * Challenge: I don't want to ask many permissions of users. I am looking for a way to store photos
              in internal storage to avoid asking WRITE EXTERNAL Storage permission. 
              i want to use ROOM as Database manager for storing data, because ROOM supports RX.
 * Add: Extensions.kt to add some functions to my primitive classes like Activity or ImageView or String. thank you Kotlin :)          

Version 1.0.1 *(July 9, 2019 )*
----------------------------

 * Add: Gradle libraries
     I am using Android Navigation Component with Single Activity Concept (MVVM). 
     I'v added Nav Graph for define project schema and navigation 
     Also some base classes like Application, CustomTextView, Constants class and my single activity : Container Activity

Version 1.0.0 *(July 9, 2019 )*
----------------------------

First commit. 


----------------------------
AmirHossein Teymoori
teymoori.net@gmail.com
