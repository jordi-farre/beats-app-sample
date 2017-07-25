.PHONY: createImage run
createImage:
	mvn clean package docker:build
run:
	docker-compose up
