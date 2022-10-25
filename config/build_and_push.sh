cp config/Dockerfile $1/Dockerfile
cd $1

./gradlew clean build

# $1:$2 are arguments
# $1 - service name (cats-api)
# $2 - version (1.0.0)

docker build . -t booratina/$1:$2
docker push booratina/$1:$2

rm Dockerfile


