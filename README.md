# Name Reform Purpose
When you have directory with large number of files and there is a word (or regex) that all names matches, now you want to change the formation of these names, here this program can help you.

# Features
* JavaFX Application runs via Java 8 to 10.
* Command Line Application runs via Java 8 and above.
* Rollback any changes after each rename operation.

# Requirements
* Java 8 and above is needed to run.
* I tried to write a cross-platform application so there should be no problem on java supported OSs. But I only tested in Windows 10 1803.

# How-to

## How to run the program
GUI Version: Run `Name Reform.jar` File. You need JRE or JDK pre-installed.
Console Version: Open CMD or Terminal in jar file directory and execute thi: `java -jar Name Reform Console.jar`

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


# Notice
Since Java-FX removed from the newest Java, you may need to run command-line app (Console Version).
