# ThreeItemsToolbar
 左中右三个位置的toolbar，左边默认回退，中间可以添加App图标和名字，右边是Button选项。


## 使用方式：  

### 1、在项目的build.gradle中添加：  

    allprojects {
    repositories {
        jcenter()
         maven {
             url  "http://dl.bintray.com/bobcn2017/maven"
         }
       }
    }

### 2、在Model的build.gradle中添加：  

    compile 'com.ff.pp.threeitemstoolbar:library:1.0.1'
