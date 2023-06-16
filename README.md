# r2dbc-mysql-reproducer
This is a sample application that has been created to reproduce an issue observed in the R2DBC mysql driver. Requires maven and a local mysql setup to run.
#### Sample Curls
By default application runs on localhost 8080 port
```
curl 'http://localhost:8080/get'
```
```
curl -X POST 'http://localhost:8080/save' -d '[{"name" : "john", "age" : 33}, {"name" : "jonah", "age" : 34}]' -H "Content-Type: application/json"
```
