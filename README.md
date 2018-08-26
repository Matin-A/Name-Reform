# Name Reform Purpose
When you have directory with large number of files and there is a word (or regex) that all names matches, now you want to change the formation of these names, here this program can help you.

# Features
* JavaFX Application runs via whether JAR file or CLASS file
* Rollback any changes after each rename operation.

# Requirements
* [Java Runtime Environment Version 10.0.2](http://www.oracle.com/technetwork/java/javase/downloads/jre10-downloads-4417026.html) is needed to run JAR file or run it manually.
Other versions not tested so not recommended.
* I tried to write a cross-platform application so there should be no problem on java supported OSs. But I only tested in Windows 10 1803.

# How-to

## How to run the program
Simply copy and run `Name Find & Replace.jar` File. You need JRE pre-installed.

## How to use the program
Here is a simple example: I enter `(\d+) - (\w+)` as the Target Regex, `*2* (*1*)` as the Replacement Regex, and `PATH/Directory` as the path, then run the program. Here is the result: 

Every files that matches the first regex (like `313 - HelloWorld`) will be renamed to the second regex formation (`HelloWorld (313)`)

If you still do not know how to use the program contact me so that i make a video.
## How to enter Target Regex
Regex (Regular Expressions) is a word (sequence of characters) which is a pattern to more than one word.

Regex Keyword must follow Java Regex Rules. [Here](https://docs.google.com/document/d/1CDhy9E-SLz_CeW5VSJ-uM63UPCEj2O3hQUsicKNE178/edit?usp=sharing) is a short summary of rules.

## How to enter Replacement Regex
This field needs a custom Regex (not Java Regex). You need to use groups in Target Regex so that u could use them here. You can call a group like this: `*<num>*` f.e: `*3*`

# Screenshot
![screenshot](https://github.com/Matin-A/Name-Reform/blob/v1.0.0-releases-archived/NameReformScreenshot.png)
