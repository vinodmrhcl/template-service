# Template Microservice

## Pre-requiste
- Install [Gradle](https://gradle.org/install/)
- Install [KeyCloak](https://www.keycloak.org/getting-started/getting-started-zip)
- Install [Kafka](https://kafka.apache.org/quickstart)
- Install [Redis](https://redis.io/download)

## KeyCloak Setup
 - Reference - - (https://medium.com/@bcarunmail/securing-rest-api-using-keycloak-and-spring-oauth2-6ddf3a1efcc2)

1. Create Admin User - http://localhost:8080/auth
2. Login to the admin console - http://localhost:8080/auth/admin
3. Create a realm
4. Add Client

`Client ID       : <your_client_name>`
`Client Protocol : openid-connect`

5. Configure Client
 
`Access Type         : confidential`
`Valid Redirect URIs : http://localhost:8085`

6. Create Client Role
7. Create a Mapper

`Property : username`
`Token Claim Name : user_name`
`Add to Access Token : true `

8. Create a user and Set Password
9. Map Client Role To User
10. Get Configuration From OpenID Configuration Endpoint

`GET http://localhost:8080/auth/realms/dev/.well-known/openid-configuration`


## Build
  `gradle build`

## Run
  `gradle run`
  
## Test
   Use [Postman Suite](template-service.postman_collection.json)