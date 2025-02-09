# Run Application

## Bring up db
The below app will bring up a postgres db:
```
docker compose up
```

## Run the app
The below command will run the app:
```
./mvnw spring-boot:run
```

## Details

Through annotations we request multiple urls
The guitar shop has different pages, for guests, users and administrators
The guest can browse guitars without any credentials
The user can also add guitars to the cart (feature not implemented)
The administrator can create new guitars

The login path 'localhost:8080/login' can sign in two different users:
user, password (default credentials).
admin, admin (credentials)
The main page with the guitars catalog can be found on 'localhost:8080/guitars'
If the admin user adds a new guitar, it will be added to the guitars catalog