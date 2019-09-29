#!/bin/bash

T_HOME=/usr/local/tomcat
echo "-----------------------------------------------------------"
echo "execute: git pull"
echo "-----------------------------------------------------------"
git pull

echo "-----------------------------------------------------------"
echo "execute: source /etc/profile"
echo "-----------------------------------------------------------"
source /etc/profile

echo "-----------------------------------------------------------"
echo "execute: mvn clean package -Dmaven.test.skip=true"
echo "-----------------------------------------------------------"
mvn clean package -Dmaven.test.skip=true

echo "-----------------------------------------------------------"
echo "execute: kill tomcat"
echo "-----------------------------------------------------------"
ID=`ps -ef | grep "tomcat" | grep -v "$0" | grep -v "grep" | awk '{print $2}'`
echo $ID
for id in $ID
do
kill -15 $id
echo "killed $id"
done
echo "-----------------------------------------------------------"
export MAVEN_OPTS='-Xmx2028m -XX:MaxPermSize=128m'

echo "-----------------------------------------------------------"
echo "execute: rm -rf  $T_HOME/webapps/ROOT/*"
echo "-----------------------------------------------------------"
rm -rf $T_HOME/webapps/ROOT/*
rm -rf $T_HOME/webapps/ROOT/.DS_Store
rm -rf $T_HOME/webapps/ROOT/.gitignore
rm -rf $T_HOME/webapps/ROOT/.project

echo "-----------------------------------------------------------"
echo "dcdg-rest/target/dcdg-rest.war -d $T_HOME/webapps/ROOT/"
echo "-----------------------------------------------------------"
unzip dcdg-rest/target/dcdg-rest.war -d $T_HOME/webapps/ROOT/

echo "-----------------------------------------------------------"
echo "execute: rm -rf work cache"
echo "-----------------------------------------------------------"
rm -rf $T_HOME/work/Catalina/localhost/ROOT
#rm -rf   $T_HOME/webapps/ROOT/WEB-INF/classes/config/app.properties
#mv  $T_HOME/webapps/ROOT/WEB-INF/classes/config/app_zs.properties $T_HOME/webapps/ROOT/WEB-INF/classes/config/app.properties

rm -rf   $T_HOME/webapps/ROOT/WEB-INF/classes/logback.xml
mv  $T_HOME/webapps/ROOT/WEB-INF/classes/logback_info.xml $T_HOME/webapps/ROOT/WEB-INF/classes/logback.xml
echo "-----------------------------------------------------------"
echo "execute: startTomcat"
echo "-----------------------------------------------------------"
#$T_HOME/bin/startup.sh

echo "-----------------------------------------------------------"
echo "execute: log tomcat"
echo "-----------------------------------------------------------"

#tail -f  $T_HOME/logs/catalina.out
