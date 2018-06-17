# Logger
A helpful logger which contains different helpers a developer would like

# Adding the logger
## Maven:
Add this to your `pom.xml`:
To your repositories:
```xml
<repositories>
    ...
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	   ...
  </repositories>```
  
And to your dependencies:  
```xml
	<dependency>
	    <groupId>com.github.ReflxctionDev</groupId>
	    <artifactId>Logger</artifactId>
	    <version>1.0-SNAPSHOT</version>
	</dependency>```
  
  ## Gradle:
  Add this to your `build.gradle`:
  To your repositories:
  ```gradle
  	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}```
  
  ```gradle
  	dependencies {
	        implementation 'com.github.ReflxctionDev:Logger:1.0-SNAPSHOT'
	}```
