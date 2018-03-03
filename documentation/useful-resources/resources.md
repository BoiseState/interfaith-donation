# Resources

This page lists out links to various resources that will be helpful if you are unfamiliar with specific technologies used in this project.

## Ionic

* [Installation](https://ionicframework.com/docs/intro/installation/)
* [UI Components](https://ionicframework.com/docs/components/)
* [Docs](https://ionicframework.com/docs/)

## Spring

* [Quick Start](https://projects.spring.io/spring-framework/#quick-start)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing JPA Data with REST](https://spring.io/guides/gs/accessing-data-rest/)

## Vue.js

* [Official Guide](https://vuejs.org/v2/guide/)

## Docker

### Useful Commands

* List all containers: `docker ps -a`
* Build the container:`docker build -t <image-name> <path>`
* Run the container: `docker run -d <image-name>`
* Get container info: `docker inspect <container-ID>`
* Connect to database in Docker container with psql (Postgres CLI): `psql -h localhost -p 5050 -d charity -U docker --password`
