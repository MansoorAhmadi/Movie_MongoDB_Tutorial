# Movie_MongoDB_Tutorial - Spring Boot - Playing saving a video or short film


Note: There is a screenshot in the source code 'Postman.png'. The purpose of this project is to upload a file or a video.
		*The video can be up to 100MB
		*The video will be uploaded to Amazon AWS S3 bucket
		*The metadata of the file/video will be sent to MongoDb


			General Architecture Information

	*Front-end	--> Angular


	*Backend		-->	REST, HTTP -->	Spring Boot  --> MongoDB
			-->	AUTH0	   -->	Spring Boot  --> AWS S3 Bucket


		--> based on 3 layers

		*Layer#1 - Controller - deals with the calls from the front
			 - Validating if the request is valid

		*Layer#2 - Service - the calls come to service layer from the controller which is the core logic of the application

		*layer#3 - Persistence - ORM - it makes sure the objects are properly saved into the database


Channel#1
1 - Backend
	Backend - It's a multi module project

		*Movie_MongoDB_Tutorial		//main-project 
		*backend			//backend module
		*frontend			//frontend module

	1.1 - Movie_MongoDB_Toturial: we will initialise the main project using spring initialiser
		*start.spring.io
			*maven project
			*java
			*spring boot 2.6.6
			*java 11
			*packaging jar

	1.2 - Dependencies: 
		*spring web
		*spring data			
		*lombok				//automate the getter/setter/constructor @Data
		*NoSQL-MongoDB

	1.3 - Generate the project - start.spring.io
		*extract
		*open pom.xml as a project


# Movie_MongoDB_Tutorial
