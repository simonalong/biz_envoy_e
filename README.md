### biz-e-service


记得将Dockerfile文件内容修改为对应的 Dockerfile-none-envoy 和 Dockerfile-have-envoy
```shell
# 有envoy
docker build -t biz-e-service:1.0.0-have-envoy .
# 有envoy【本地调试版本】
docker build -t biz-e-service:1.0.0-have-envoy-debug .
# 没有envoy
docker build -t biz-e-service:1.0.0-none-envoy .
```

```shell
# 有envoy
docker run -d --name biz-e-service -p 18004:18004 biz-e-service:1.0.0-have-envoy
# 没有envoy
docker run -d --name biz-e-service -p 18004:18004 biz-e-service:1.0.0-none-envoy
```
