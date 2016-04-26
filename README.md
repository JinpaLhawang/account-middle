# properties-middle

## Setup

```
git clone https://github.com/JinpaLhawang/properties-middle.git
cd properties-middle
```

## Testing and Building

```
mvn test
mvn package
```

## Running

```
mongod --dbpath ~/mongodb/data/db/
mvn spring-boot:run
```

### Inserting Data

```
curl -i -X POST http://localhost:8090/applications -d '{ "name" : "hello-world-middle", "property": "Hello World!", "properties": { "text": "Hello World!" } }' -H "Content-Type:application/json"
```

### Requesting Data

```
curl -i http://localhost:8090/applications -H "Content-Type:application/json"
curl -i http://localhost:8090/applications/search -H "Content-Type:application/json"
curl -i http://localhost:8090/applications/search/findByName?name=hello-world-middle -H "Content-Type:application/json"
```

### Checking Eureka Client Service Discovery Instance Details

```
curl -i http://localhost:8090/service-instances/properties-middle -H "Content-Type:application/json"
```
