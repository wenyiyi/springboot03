Spring Boot项目打包


1 构建JAR包
  
  
  mvn -Dmaven.test.skip -U clean package
  
  
  java -jar web-0.0.1-SNAPSHOT.jar

2 构建WAR包
  
  
  mvn -Dmaven.test.skip -U clean package
  
  
  java -jar web-0.0.1-SNAPSHOT.war
  
3 指定Main-Class


