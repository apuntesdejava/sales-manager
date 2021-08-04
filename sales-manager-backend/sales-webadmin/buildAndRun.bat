@echo off
call mvn clean package
call docker build -t com.apuntesdejava.sales/sales-webadmin .
call docker rm -f sales-webadmin
call docker run -d -p 9080:9080 -p 9443:9443 --name sales-webadmin com.apuntesdejava.sales/sales-webadmin