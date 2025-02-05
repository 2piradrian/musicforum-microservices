# Project: Music Forum
## To run it:
```
cd ./common
mvn package
mvn install
cd ..
docker compose up
```
and start the microservices in this order:
1. registry-server
2. config-server
3. auth-server
4. forum-server
5. report-server
6. gateway

local url: http://localhost:4040

# 📁 Collection: Users 


## End-point: Get By ID
### Method: GET
>```
>{{base_url}}/api/users/get-by-id/e7e19a07-8a83-4264-8a2a-53ac5c8bb326
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Auth
### Method: GET
>```
>{{base_url}}/api/users/auth
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Login
### Method: POST
>```
>{{base_url}}/api/users/login
>```
### Body (**raw**)

```json
{
    "email": "2piradrian@gmail.com",
    "password": "MyP@ssword4"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Register
### Method: POST
>```
>{{base_url}}/api/users/register
>```
### Body (**raw**)

```json
{
    "username": "2piradrian",
    "password": "MyP@ssword4",
    "email": "2piradrian@gmail.com"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete
### Method: DELETE
>```
>{{base_url}}/api/users/delete
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Forum 


## End-point: Get By ID
### Method: GET
>```
>{{base_url}}/api/forum/get-by-id/bdd77e84-8cfe-4b99-8176-b083658aa947
>```

⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Pages
### Method: GET
>```
>{{base_url}}/api/forum/get-forums?category=SONGS&size=1&page=0
>```
### Query Params

|Param|value|
|---|---|
|category|SONGS|
|size|1|
|page|0|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Get Monthly
### Method: GET
>```
>{{base_url}}/api/forum/get-monthly-forums?month=1&year=2025
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Query Params

|Param|value|
|---|---|
|month|1|
|year|2025|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Create
### Method: POST
>```
>{{base_url}}/api/forum/create
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "title": "¿Recomendaciones de canciones de jazz con progresiones 2-5-1?",
    "content": "Estoy buscando ejemplos claros donde estas progresiones se utilicen de manera destacada, tanto en composiciones como en improvisaciones, para analizar cómo se aplican en diferentes contextos y estilos dentro del jazz.",
    "category": "SONGS"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Edit
### Method: PATCH
>```
>{{base_url}}/api/forum/edit
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "676e5e6d-b6f8-4ab0-a6bc-f6520e5291e0",
    "title": "¿Alguien sabe qué acordes lleva 'Us and Them' de Pink Floyd?",
    "content": "Estoy intentando analizar la estructura armónica de 'Us and Them' de *The Dark Side of the Moon*, pero no estoy seguro de qué acordes se utilizan exactamente. ¿Alguien tiene el análisis o los acordes completos de la canción? Me interesa especialmente cómo los acordes contribuyen a la atmósfera melancólica y reflexiva del tema.",
    "category": "SONGS"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Toggle Votes
### Method: PATCH
>```
>{{base_url}}/api/forum/toggle-votes
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "bdd77e84-8cfe-4b99-8176-b083658aa947",
    "voteType": "UPVOTE"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete
### Method: DELETE
>```
>{{base_url}}/api/forum/delete
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "e7c1b9a1-bbe0-4085-9f97-44d07b9146a9"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Comments 


## End-point: Get Pages
### Method: GET
>```
>{{base_url}}/api/comment/get-comments?forumId=bdd77e84-8cfe-4b99-8176-b083658aa947&size=10&page=0
>```
### Query Params

|Param|value|
|---|---|
|forumId|bdd77e84-8cfe-4b99-8176-b083658aa947|
|size|10|
|page|0|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Create
### Method: POST
>```
>{{base_url}}/api/comment/create
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "forumId": "bdd77e84-8cfe-4b99-8176-b083658aa947",
    "content": "El solo tiene los siguentes acordes: ( Dsus2  Esus2/D  Dm(maj7)  G/D  Dsus2 )x2 ( Bm  Bm/A  D/G  C  Bm  A  Bm  Bm/A  G  C )",
    "replyTo": "9990ab09-a183-4d14-8d04-64988affd4b3" // Optional
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Edit
### Method: PATCH
>```
>{{base_url}}/api/comment/edit
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "commentId": "e7c1b9a1-bbe0-4085-9f97-44d07b9146a9",
    "content": "El solo es: ( Dsus2  Esus2/D  Dm(maj7)  G/D  Dsus2 )x2 ( Bm  Bm/A  D/G  C  Bm  A  Bm  Bm/A  G  C )"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Toggle Votes
### Method: PATCH
>```
>{{base_url}}/api/comment/toggle-votes
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "commentId": "676e5e6d-b6f8-4ab0-a6bc-f6520e5291e0",
    "voteType": "UPVOTE"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: Delete
### Method: DELETE
>```
>{{base_url}}/api/comment/delete
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Body (**raw**)

```json
{
    "commentId": "e7c1b9a1-bbe0-4085-9f97-44d07b9146a9"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
# 📁 Collection: Reports 


## End-point: Monthly Forums
### Method: GET
>```
>{{base_url}}/api/report/forums/monthly?month=1&year=2025
>```
### Headers

|Content-Type|Value|
|---|---|
|Authorization|Bearer {{access token}}|


### Query Params

|Param|value|
|---|---|
|month|1|
|year|2025|