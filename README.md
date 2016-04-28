# account-middle

## Setup

```
git clone https://github.com/JinpaLhawang/account-middle.git
cd account-middle
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
curl -i -X POST http://localhost:8090/accounts -d '{ "firstName" : "Jinpa", "lastName": "Lhawang", "tags": { "debug1": "I used to say Hello World!", "debug2": "Now I say Hello Jinpa Lhawang!" } }' -H "Content-Type:application/json"
```

### Requesting Data

http://localhost:8090/accounts
http://localhost:8090/accounts/search
http://localhost:8090/accounts/search/findByFirstName?firstName=Jinpa
http://localhost:8090/accounts/search/findByLastName?lastName=Lhawang

### Checking Eureka Client Service Discovery Instance Details

http://localhost:8090/service-instances/account-middle
