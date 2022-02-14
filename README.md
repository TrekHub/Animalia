<link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css"
      integrity="sha512-YWzhKL2whUzgiheMoBFwW8CKV4qpHQAEuvilg9FAn5VJUDwKZZxkJNuGM4XkWuk94WCrrwslk8yWNGmY1EduTA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />

<div style="text-align: center; ">
        <div>
            <h1>Hi There, I'm <span style="color: green; ">Teddy Omondi</span> <span style='font-size:50px;'> &#128075</span></h1>
            <h3>Upcoming Junior Software Developer &#128187; &#127911;</h3>
        </div>
        
</div>
<br>

# Animalia Java Spark <span style='font-size:30px;'> <img height="20" class="mx-1" id="logo-img" src="./images/icons/shop-solid.svg" alt=""></span> 
An application that allows Rangers to track wildlife sightings in the area.

<br>







<br>


# Demo &#128273;

Here is a live link to the project 


http://animaliasurvey.herokuapp.com/





# Usage <span style='font-size:30px;'>🖋</span> 
If you want to view the code or change some elements on the website, you are welcomed to clone the project

```git
git clone git@github.com:TrekHub/Heroes-Lounge-Java.git

```

Then run gradle  build to download all the project dependecies
```java
gradle build

```

After everything is installed. You need to set up the Postgres Database
 1. Create the database called Wildlife_tracker
 
 ```postgres-sql
CREATE DATABASE wildlife_tracker;
```

2. Create the two tables
```postgres-sql
CREATE TABLE animals (id SERIAL  PRIMARY KEY, name VARCHAR, age VARCHAR, health VARCHAR);

```
```postgres-sql
CREATE TABLE sightings (id SERIAL  PRIMARY KEY, name VARCHAR, age VARCHAR, health VARCHAR, location VARCHAR, rangerName VARCHAR);
```

Run the server using the command
```groovy
gradle run
```


# Technology Used <span style='font-size:30px;'>&#128187;</span> 

1. Java

2. Spark

3. Postgres

3. HandleBars



# Author <span style='font-size:30px;'>&#128524;</span> 

Teddy Omondi 

# License  <span style='font-size:30px;'>🔐</span> 
[MIT](https://choosealicense.com/licenses/mit/)