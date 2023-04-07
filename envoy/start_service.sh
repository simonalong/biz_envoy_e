#!/usr/bin/env bash
java -jar /usr/local/opt/server.jar & envoy -c /etc/envoy/envoy.yaml --service-cluster biz-e-service
