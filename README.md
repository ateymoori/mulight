Change Log - Read Me (I'v combined CHANGELOG and README in this file)
==========


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
     I am using Android Navigation Component with Single Activity Concept. 
     I'v added Nav Graph for define project schema and navigation 
     Also some base classes like Application, CustomTextView, Constants class and my single activity : Container Activity

Version 1.0.0 *(July 9, 2019 )*
----------------------------

First commit. 
