# Enviro365 Waste Management System

Developing a waste sorting application aimed at promoting sustainable waste management practices using springboot. The application will serve as an educational tool for individuals and communities, providing guidance on proper waste disposal techniques and encouraging recycling habits.

# Project Architeecture:
  - Configuration : Used to configure specific beans
  - DTOs  (Data Transfer Objects) : Used to transfer data between different layers of the project
  - Exception : Used to handle exceptions
  - Controller : Handles incoming HTTP requests and reponses
  - Model : Entity class representing that defines atttributes and relations
  - Service : Handle the business logic of the application
  - Repository : Provide methods to interact with the database

# Features:
  - Waste category 
  - Disposal guidelines
  - Recycling tips
  - Waste item

# Getting Started
You will need the following requirements to be able to run and interact with the project in your machine
  - Java 21 or higher
  - Maven
  - Postman (optional)
## steps: 
  1. Clone the repository :
      
     ```bash
     git@github.com:DenzelSE/Waste_Management_SpringBoot.git
     ```
  2. Navigate to dir:

     ```bash
      cd Waste_Management_SprintBoot
      ```
 
# REST endpoints :
Categories : 
  - Get '/categories' - get all categories
  - Get '/categories/{id}' - get a category by id
  - Post '/categories' - add to categories
  - Post Put 'categories/{id} - update a category by id
  - Delete '/categories/{id} - delete a category by id

Disposal guidelines:
  - Get '/guidelines' - get all disposal guidelines
  - Get '/guidelines/{id}' - get disposal guidelines using their id
  - Post '/guidelines' - add a guideline
  - Post '/guidelines/{id}' - update a guideline by id
  - Delete '/guidelines/{id}' - delete guideline by id

Recycling tips:
  - Get '/tips' - get all the recycling tips
  - Get '/tips/{id} - get recycling tips using their id
  - Post '/tips' - add a recycling tip 
  - Post '/tips/{id}' - update a recycling tip by id
  - Delete '/tips/{id}' - delete a recycling tip by id

Waste items: 
  - Get '/items' - get all waste items - get all the recycling items
  - Get '/items/{id} - get waste item using their id
  - Post '/items' - add a waste items 
  - Post '/items/{id}' - update a waste item by id
  - Delete '/items/{id}' - delete a waste item by id

### Author : Built by Denzel Selokela 
