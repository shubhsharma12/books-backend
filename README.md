#Adding Security in Spring boot app

- adding necessary dependencies

```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-security</artifactId>
</dependency>


<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt-api</artifactId>
	<version>0.11.5</version>
</dependency>
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt-impl</artifactId>
	<version>0.11.5</version>
</dependency>
<dependency>
	<groupId>io.jsonwebtoken</groupId>
	<artifactId>jjwt-jackson</artifactId>
	<version>0.11.5</version>
</dependency>
<dependency>
	<groupId>com.vaadin.external.google</groupId>
	<artifactId>android-json</artifactId>
	<version>0.0.20131108.vaadin1</version>
	<scope>compile</scope>
</dependency>


```

- adding password encoder first