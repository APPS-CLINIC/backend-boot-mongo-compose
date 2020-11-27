## MongoDB docker image
1. Download latest image with
``` bash
docker pull mongo
```
2. Launching docker container instance
``` bash
docker run --rm -p 27017:27017 --name mongodb-test mongo
```
3. Connecting to running container:
``` bash
## connect to container
docker exec -it mongodb-test bash

## connect to db instance inside container
mongo

## list databases
show dbs

## create new database (db will not be created until first insert)
use testdb

## add an object to collection
db.people.save({ firstname: "Foo", lastname: "Bar" })

## find an object in collection
db.people.find({ firstname: "Foo" })
```
#### Notes
> mongodb-test - container name from step 2

## Docker compose

1. Starting docker compose
``` bash
## detached mode
docker-compose up -d 
## or
docker-compose up
```
#### Notes
> List of running containers: docker ps
2. Connecting to db container instance
``` bash
docker exec -it container-name bash
## connect to db
mongo admin -u root -p rootpassword

## with other user
mongo -u fizz -p bazz --authenticationDatabase testdb
```
3. Stopping docker compose without container removal
``` bash
docker-compose stop
```
4. Stopping docker compose with container removal
``` bash
docker-compose down
```

## Dockerized spring boot image
1. Build the application
``` bash
mvn clean install
```
2. Build image
``` bash
docker build -t bit-app:latest .
```
3. Runnimg app image
``` bash
## run app container
docker run --rm -p 8080:8080 --name bit-app bit-app:latest

## check state
http://127.0.0.1:8080/actuator
http://127.0.0.1:8080/services/sample/version
```