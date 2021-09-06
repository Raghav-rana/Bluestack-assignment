# Introduction 
Web(question 1) and Mobile (Question 2) Automation using Selenium and Appium with TestNG framework. 

# Getting Started
1.	Software dependencies
	- JDK 16.0.2
	- Android SDK
	- Eclipse latest IDE for Java Developers.
	- Git
	- Maven (Embedded in Eclipse IDE)
	 

2.	Installation process on Windows
	- Pre-requisite:
		- Git should be installed.
		- Clone repository `git clone https://github.com/Raghav-rana/Bluestack-assignment` on your local system.
	- Download jdk-16.0.2 .
	- Set `JAVA_HOME` system environment variable with value of `<JDK>/jdk-16.0.2`.
	- Add in `Path` system environment variable with value `%JAVA_HOME%/bin`.
	- Open cmd.exe and run command `java -version` to verify JDK installation.
	- Download Eclipse from [here](https://www.eclipse.org/downloads/download.php?file=/technology/epp/downloads/release/2021-03/R/eclipse-java-2021-03-R-win32-x86_64.zip) as zipped archive and extract somewhere on your local system.
	- Create a shortcut of `eclipse.exe` on your desktop.
	- Open Eclipse by clicking on eclipse.exe shortcut from Desktop.
	- Import project in eclipse as `Existing Maven Projects` from your cloned local git repository.
	- Open eclipse menu `Window-->Preferences`.
	- Select from tree in preferences window `Java-->Installed JREs`.
	- We need to add our JDK as Java Runtime Environment. To do this follow the below steps:
		- On `Installed JREs` window click on `Add` button.
		- Select `Standard VM` and click on `Next`.
		- Set JRE Home as base directory of JDK folder `<extracted-location-of-JDK>/jdk-16.0.`.
		- Provide a JRE Name like `jdk-16.0.-jre`.
		- JRE system libraries panel should show `*jrt-*.jar` file.
		- Click on `Finish` button to complete the setup.
		- You can use this [link](https://blogs.itemis.com/en/after-eight-eclipse-development-with-java-and-javafx) to get help if needed. Ignore the JavaFX part here. 


3.	Documentation references
	- [Selenium] (https://www.selenium.dev/documentation/)
	- [Rest-Assured](https://rest-assured.io/)
	- [TestNG](https://testng.org/doc/documentation-main.html)
	- [Maven](https://maven.apache.org/guides/)
	- [Git](https://git-scm.com/docs)
	- [Appium] (https://appium.io/docs/en/about-appium/intro/)


4.	How To Run:
	- Connect Android device and Set all related capabilties
	- Open Appium and run server
	- Run the testng.xml file in project as testNG 
	
# How to connect android real device
Step 1 : Download SDK tools
 https://developer.android.com/studio
----------------------------------------------------------------------------------
Step 2 : Unzip folder & Extract platform tools
----------------------------------------------------------------------------------
Step 3 : Set environment variables
 ANDROID_HOME = location of sdk folder
 Path : append path of platform_tools folder
----------------------------------------------------------------------------------
Step 4 : Check command adb devices on command line
----------------------------------------------------------------------------------
Step 5 : Make device ready
 - enable developer mode
 - make USB Debugging on
----------------------------------------------------------------------------------
Step 6 : Connect device to computer system thorugh USB cable
 - if asked enable USB Debbugging
----------------------------------------------------------------------------------
Step 7 : Run command adb devices
  adb = android debug bridge
 Check your device id displayed
 
# Installing appium with APPIUM DESKTOP CLIENT
Step 1 : Download appium desktop client
   http://appium.io/
   https://github.com/appium/appium-desk...
----------------------------------------------------------------------------------

Step 2 : Install appium desktop client
----------------------------------------------------------------------------------
Step 3 : Start appium through appium desktop client
	
	


If you want to learn more about creating good readme files then refer the following [guidelines](https://docs.microsoft.com/en-us/azure/devops/repos/git/create-a-readme?view=azure-devops).