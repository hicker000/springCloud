FROM registry.cn-hangzhou.aliyuncs.com/chainone/centos7-jdk8
ENV TZ Asia/Shanghai
COPY server-registration-center.jar /home/server-registration-center.jar
WORKDIR /home
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=test","server-registration-center.jar"]