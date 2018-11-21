# Notes
小知识点记录

# 1. 解决Android studio jcenter下载慢，更换为国内镜像源。
#### maven { url 'http://maven.aliyun.com/nexus/content/groups/public/'}
#### maven { url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
当然还需要添加 google(), 如下： 

    // Top-level build file where you can add configuration options common to all sub-projects/modules.

    buildscript {
    
        repositories {
            maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
            maven{ url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
            google()
        }
        dependencies {
            classpath 'com.android.tools.build:gradle:3.2.0'


            // NOTE: Do not place your application dependencies here; they belong
            // in the individual module build.gradle files
        }
    }

    allprojects {
        repositories {
            maven { url 'http://maven.aliyun.com/nexus/content/groups/public/' }
            maven{ url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}
            google()
        }
    }

    task clean(type: Delete) {
        delete rootProject.buildDir
    }

# 2. Gradle Distributions
#### http://services.gradle.org/distributions/
#### 从这里下载 gradle-xxx-all.zip 包，放到本地目录 /Users/muranhu/.gradle/wrapper/dists/ 下，然后在 gradle-wrapper.properties 中做如下配置：distributionUrl=file:/Users/muranhu/.gradle/wrapper/dists/gradle-4.6-all.zip ，可以避免网络加载太慢的问题。

# 3. dp 转像素方法
    public static float dpToPixel(float dp) {
    return  TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
            Resources.getSystem().getDisplayMetrics());
   }

# 3. Android动画
#### 1. Animation - 属性动画
###### 1.1 View Animation - 纯粹基于framework的绘制转变，很少用到
###### 1.2 Property Animation - 属性动画，Android 3.0 引入，目前项目中应用占到99%
    1.2.1 ViewPropertyAnimator
    1.2.2 ObjectAnimator
###### 1.3 属性动画通用设置
    1.3.1 设置时长 
    1.3.2 速度设置器
    1.3.3 设置监听器
#### 2. Transition - 界面切换时的动画效果
