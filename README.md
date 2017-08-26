# Grow in desert v1.12-0.4.1
It is a small Minecraft modification that gives players ability to get wood in desert. Just use bone meal on dead bush and with some chance you will get the acacia sapling. Water sources near increase chance. Also you can use bone meal on grass block to get sapling related to the current biome.

## Getting Started
This modification was developed with forge version 1.12-14.21.0.2367. You need to download forge mdk from [forge official site](https://files.minecraftforge.net/) and unzip it. After that follow by steps in the included README. After deploying gradle just copy mod files into forge-mdk directory.

## List of versions 
v*XXX-YYY* (where *X* - minecraft version supported and *Y* - version of mod): 
* v*1.12-0.4.1* - Fixed the major bug related to other mods biomes.
* v*1.12-0.4* - Now you also can use bone meal on grass block to get a sapling related to the current biome. Added colorize of the wood blocks placed in the desert to dry colors.
* v*1.12-0.3* - Dead bush transforms not only to acacia sapling. With different chances it can be - grass or fern. Now, block under the bush replaces by grass block. Water blocks in area of 9x9x2 with dead bush in center increase probability to growing will take effect. Using square root function to better smooth of relation - number of water blocks ~ chance to growing (10 water blocks gets absolute chance). Also water increase chance of getting acacia. Fixed issue - mod logo are not loading.
* v*1.12-0.2* - Random check to using bone meal on dead bush, mod description and logo.
* v*1.12-0.1* - Using bone meal on dead bush to transform it to the acacia sapling. After that 
sand under the bush replacing by dirt block.

## Autors
* JoHarker (Igor Vilhovy).