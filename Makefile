MVN = mvnw

run:
	$(MVN) spring-boot:run

clean:
	$(MVN) clean

build:
	$(MVN) clean package -DskipTests

install:
	$(MVN) clean install