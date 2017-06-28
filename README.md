# Grow in desert v1.12-0.2
It is a small Minecraft modification that gives players ability to get wood in desert. Just use bone meal on dead bush and with great chance you will get the acacia sapling

## Getting Started
This modification was developed with forge version 1.12-14.21.0.2367. You need to download forge mdk from [forge official site](https://files.minecraftforge.net/) and unzip this. After that execute command (for windows):
```
gradlew setupDecompWorkspace
```
It setups Minecraft decompilation workspace and creates folder .gradle in your home folder.

Potentially you may get error within execution. Check your JDK and *JAVA_HOME* variable. 64x version of JDK and system with more than 2GB is preferable. For more help visit the [forge documentation](https://mcforge.readthedocs.io/en/latest/gettingstarted/).

To setup for development use commands:
```
gradlew setupDevWorkspace
gradlew eclipse
```

Then you may import project into Eclipse by *"..open project from filesystem"* and choosing forge directory. 

To build use command (build output will be in *build/libs*):
```
gradlew build
```

## List of versions 
v*XXX-YYY* (where *X* - minecraft version supported and *Y* - version of mod): 
* v1.12-0.1 (stable) - using bone meal on dead bush to transform it to the acacia sapling. After that 
sand under the bush replacing by dirt block.
* v1.12-0.2 (stable) - random check to using bone meal on dead bush, mod description and logo

## Autors
* JoHarker (Igor Vilhovy).