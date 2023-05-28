Build image:
DOCKER_BUILDKIT=1 docker-build .
Application build with docker-compose:
USR_UID="$(id -u)" USR_GID="$(id -g)" docker-compose up

Server uses free public GeoInfo API, which esitamtes timezone based on coordinates. IP is fetched using Spring Framework
HttpServletRequest instance, which contains info about incoming request.

To check number of layers, you can run docker inspect command. This image contain 8 layers.