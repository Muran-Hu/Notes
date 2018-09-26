# Notes
小知识点记录

# 1. 解决Android studio jcenter下载慢，更换为国内镜像源。
#### maven { url 'http://maven.aliyun.com/nexus/content/groups/public/'}
#### maven { url 'http://maven.aliyun.com/nexus/content/repositories/jcenter'}

# 2. Gradle Distributions
#### http://services.gradle.org/distributions/
#### 从这里下载 gradle-xxx-all.zip 包，放到本地目录 /Users/muranhu/.gradle/wrapper/dists/ 下，然后在 gradle-wrapper.properties 中做如下配置：distributionUrl=file:/Users/muranhu/.gradle/wrapper/dists/gradle-4.6-all.zip ，可以避免网络加载太慢的问题。
