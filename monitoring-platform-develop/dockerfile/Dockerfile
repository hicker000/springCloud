FROM registry.cn-hangzhou.aliyuncs.com/chainone/centos7-jdk8
ENV TZ Asia/Shanghai
COPY monitoring-platform.jar /home/monitoring-platform.jar
WORKDIR /home
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=test","monitoring-platform.jar"]