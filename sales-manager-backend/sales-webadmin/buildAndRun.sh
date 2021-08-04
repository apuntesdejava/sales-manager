#!/bin/sh
mvn clean package && docker build -t com.apuntesdejava.sales/sales-webadmin .
docker rm -f sales-webadmin || true && docker run -d -p 9080:9080 -p 9443:9443 --name sales-webadmin com.apuntesdejava.sales/sales-webadmin