#!/bin/sh
uvicorn main:app --host 127.0.0.1 --port 1080 --proxy-headers &
nginx -g 'daemon off;'