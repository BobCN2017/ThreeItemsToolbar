# ThreeItemsToolbar
 左中右三个位置的toolbar，左边默认回退，中间可以添加App图标和名字，右边是Button选项。

## 显示效果：
![screen picture](https://github.com/BobCN2017/ThreeItemsToolbar/tree/master/sample/src/main/res/raw/Screenshot.png)

### 以上toolbar中的图标、文字均可自主设定。同时保留Google Toolbar的功能，如在RecyclerView滚动时toolbar跟随向上消失，向下复现。

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
	
### 3、在XML文件如下定义和使用：

	    <com.ff.pp.threeitemstoolbar.ThreeItemsToolbar
        android:id="@+id/threeItemsToolbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="top"
        android:background="#008899"
        app:leftButtonIsClose="true"
        app:centerIcon="@mipmap/ic_launcher_round"
        app:centerTitle="标题" />
		
#### 其中属性leftButtonIsClose提供关闭当前Activity功能，可使用在App的非主界面Activity中，方便地提供回退功能。

### 4、同时也可以在代码中设置：

#### 代码中除了正常设置左中右相应的图标、文字，还可以将右侧图标设置为菜单，传入相应的菜单Id及listener即可。
	public void setRightSideMenu( int resId, PopupMenu.OnMenuItemClickListener listener)
