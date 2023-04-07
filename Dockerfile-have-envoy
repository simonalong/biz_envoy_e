#image stage
FROM envoyproxy/envoy:v1.21.2

WORKDIR /app

ENV TZ=Asia/Shanghai
ENV ZONEINFO=/app/zoneinfo.zip

RUN mkdir /usr/local/java8

COPY ./jdk/* /usr/local/java8/

# 配置JAVA的环境变量
ENV JAVA_HOME=/usr/local/java8
# 配置到PAHT中
ENV PATH=$PATH:$JAVA_HOME/bin

COPY ./jar/biz-e-service.jar /usr/local/opt/server.jar

COPY ./envoy/start_service.sh /usr/local/bin/start_service.sh
COPY ./envoy/envoy-config.yaml /etc/envoy/envoy.yaml
ADD ./envoy/log /var/log/envoy

RUN chmod u+x /usr/local/bin/start_service.sh
RUN chmod u+x /usr/local/java8/bin/*
ENTRYPOINT /usr/local/bin/start_service.sh
