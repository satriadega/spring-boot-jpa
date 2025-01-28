Building a RESTful Web Service
=============================

1. Send a GET request to http://localhost:8080/api/test/hello with query parameter `name=John Doe` and header `Content-Type: application/json`.

    
    curl -X GET \
      http://localhost:8080/api/test/hello?name=John%20Doe \
      -H 'Content-Type: application/json'
    

2. Send a GET request to http://localhost:8080/api/test/greeting with query parameter `name=John Doe` and header `Content-Type: application/json`.

    
    curl -X GET \                                                                                                                                                                   
      http://localhost:8080/api/test/greeting\?name\=John%20Doe \
      -H 'Content-Type: application/json'
    

Consuming a RESTful Web Service
==============================

1. Send a GET request to http://localhost:8080/api/test/get-jackson with header `Content-Type: application/json`.

    
    curl -X GET \                                                                                                                                                                   
      http://localhost:8080/api/test/get-jackson \
      -H 'Content-Type: application/json'