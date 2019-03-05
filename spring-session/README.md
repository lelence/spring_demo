# Spring Boot Rediss Session

利用 Spring-Boot Redis 共享session

## Startup
```bash
$ mvn spring-boot:run -Ptest1

$ mvn spring-boot:run -Ptest2
```

## Operator


> request: http://localhost:9001/api/v1/login

```json
{
	request Url: "http://localhost:9001/api/v1/login"
}
```

> request: http://localhost:9001/api/v1/sessions

```json
{
	sessionId: "831b45a5-8784-44f2-88ec-077fccf0770d",
	message: "http://localhost:9001/api/v1/login"
}
```

> http://localhost:9002/api/v1/sessions

```json
{
	sessionId: "831b45a5-8784-44f2-88ec-077fccf0770d",
	message: "http://localhost:9001/api/v1/login"
}
```




