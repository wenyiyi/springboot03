Spring Boot项目打包

切换到项目的目录


1 构建JAR包
  
  mvn -Dmaven.test.skip -U clean package
  
  然后在工程的target目录下会出现jar文件
  
  java -jar *.jar

2 构建WAR包
  
  mvn -Dmaven.test.skip -U clean package
  
  然后在工程的target目录下会出现war文件
  
  
  
3 指定Main-Class


