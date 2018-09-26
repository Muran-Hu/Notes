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

# 3. Coming soon
