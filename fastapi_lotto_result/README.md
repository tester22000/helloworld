hello fastapi backend

### Installation dependencies
```bash
python3 -m pip install virtualenv
python3 -m virtualenv venv
. venv/bin/activate
pip install -r requirements.txt
```

### setup

#### 1. create sqlite db
```bash
sqlite3 --init ./docker/init.sql lotto.sqlite.db .quit
```

#### 2. create .env file
```
cat > .env
DB_URL=sqlite:///./lotto.sqlite.db
DB_TEST_URL=sqlite:///./lotto.test.sqlite.db
Ctrl-D
```

### Running the Application
```bash
uvicorn main:app --realod
```

### Docker

#### Docker Build
```
docker build -t fastapi_lotto_result:1.0 .
```

#### Docker run
```
docker run --name fastapi_lotto -p 8081:8081 -d  fastapi_lotto_result:1.0
```