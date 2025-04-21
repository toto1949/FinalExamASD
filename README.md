# API Endpoints Documentation

## 1. POST /api/v1/astronauts

**URL**:  
`http://localhost:8080/api/v1/astronauts`

**Description**:  
Create a new astronaut record.

![POST Astronaut](postAstro.png)

---

## 2. GET /api/v1/astronauts?sort=experienceYears&order=desc

**URL**:  
`http://localhost:8080/api/v1/astronauts?sort=experienceYears&order=desc`

**Description**:  
Fetch all astronauts, sorted by `experienceYears` in descending order.

![GET Astronauts Sorted](image-1.png)

![GET Astronauts Example](GETexper.png)

---

## 3. GET /api/v1/astronauts/5

**URL**:  
`http://localhost:8080/api/v1/astronauts/5`

**Description**:  
Fetch astronaut by ID (ID = 5).

![GET Astronaut by ID](getASTRO.png)

---

## 4. PUT /api/v1/astronauts/5

**URL**:  
`http://localhost:8080/api/v1/astronauts/5`

**Description**:  
Update astronaut with ID 5.

![PUT Astronaut](image.png)

![PUT Astronaut in Database](putAstroDB.png)

---

## 5. PUT /api/v1/satellites/1

**URL**:  
`http://localhost:8080/api/v1/satellites/5`

**Description**:  
Update satellite with ID 5.

![PUT Satellite](putAstro.png)
