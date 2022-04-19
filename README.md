# Movie_MongoDB_Tutorial - Spring Boot - Playing saving a video or short film


			General Information - High Level Architecture

	*Front-end	-->	REST, HTTP -->	Spring Boot  --> MongoDB
			-->	AUTH0	   -->	Spring Boot  --> AWS S3 Bucket


	*Backend		--> based on 3 layers

		*Layer#1 - Controller - deals with the calls from the front
			 - Validating if the request is valid

		*Layer#2 - Service - the calls come to service layer from the controller which is the core logic of the application

		*layer#3 - Persistence - ORM - it makes sure the objects are properly saved into the database


Channel#1
1 - Backend
	Backend - It's a multi module project

		*Movie_MongoDB_Tutorial		//main-project 
			*backend			//backend module
			*frontend		//frontend module

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
		*lombok

	1.3 - Generate
		*extract
		*open pom.xml as a project


# Movie_MongoDB_Tutorial
