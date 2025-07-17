### Build Dockerfile
```bash
docker build -t spring_lotto_result:1.0 .
```

### Run Dockerfile
```basah
docker run --name spring_lotto_result -p 8200:8200 -d  spring_lotto_result:1.0
```