# springboot-with-MQ

Run with 

```
mvn spring-boot:run
```

Deploy a MQ for example with: ` docker run --name rattitmq -p 5672:5672 rabbitmq`

Then, you can send messages through the API:

http://localhost:9091/api/send/XXXX

and check the console to find the log: **Message received!**
