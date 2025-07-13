FROM alpine:3.18

WORKDIR /app

COPY requirements.txt requirements.txt

RUN apk update
RUN apk add --no-cache python3 nginx py3-pip sqlite
RUN pip3 install -r ./requirements.txt

COPY app ./app
COPY main.py main.py
COPY .env.sample .env
#COPY docker/nginx.default.conf /etc/nginx/conf.d/default.conf
COPY docker/nginx.default.conf /etc/nginx/nginx.conf
COPY docker/start.sh start.sh
COPY docker/init.sql init.sql

RUN  sqlite3 --init ./init.sql lotto.sqlite.db .quit
RUN  chmod +x ./start.sh
CMD ["./start.sh"]
EXPOSE 8081
