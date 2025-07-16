### Build Docker File
```
docker build -t go_lotto_result:1.0 .
```

#### Docker run
```
docker run --name go_lotto_result -p 8100:8100 -d  go_lotto_result:1.0
```
