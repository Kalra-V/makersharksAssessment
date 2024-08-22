# Makersharks Supplier Search API

## Overview

This is a proof of concept for a search API that allows buyers to search for manufacturers based on customized requirements. It is built using Spring Boot and uses an H2 in-memory database for development and testing.

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven (for building the project)
- H2 Database (comes embedded with the project)

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/Kalra-V/makersharksAssessment
   ```

2. Navigate to the project directory:
   ```bash
   cd makersharks
   ```
3. Build and run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access the H2 console (optional):
   Open your browser and go to `http://localhost:8080/h2-console`.

### Steps to Test the API

> **Note:** Before testing the API, ensure that you have populated the database with sample data. You can use the provided data initialization scripts or manually insert records into the H2 database.

### Open Postman

Launch Postman.

### Configure the POST Request

1. **Set the HTTP Method and URL:**
   - **Method:** `POST`
   - **URL:** `http://localhost:8080/api/supplier/query` (assuming your application runs on port 8080)

2. **Add Query Parameters:**
   - Click on the "Params" tab in Postman.
   - Add the following parameters:
     - `location` (e.g., `India`)
     - `natureOfBusiness` (e.g., `small_scale`)
     - `manufacturingProcesses` (e.g., `moulding`)
     - `page` (optional, default `0`)
     - `size` (optional, default `10`)

### Send the Request

Click the "Send" button to make the request.

### View the Response

- **Response Body:** You should see a JSON response containing the list of suppliers matching the query criteria.
- **Response Status:** The status code should be `200 OK` if the request was successful.

## API Endpoints

### Search for Suppliers

- **Endpoint:** `/api/supplier/query`
- **Method:** `POST`

**Request Parameters:**

- `location` (e.g., `India`)
- `natureOfBusiness` (e.g., `small_scale`)
- `manufacturingProcesses` (e.g., `moulding`)
- `page` (optional, default `0`)
- `size` (optional, default `10`)

### Example Response

```json
{
    "content": [
        {
            "supplierId": 1,
            "companyName": "Small Scale Co.",
            "website": "http://smallscale.com",
            "location": "India",
            "natureOfBusiness": "small_scale",
            "manufacturingProcesses": "moulding"
        }
    ],
    "pageable": {
        "sort": {
            "empty": true,
            "unsorted": true,
            "sorted": false
        },
        "offset": 0,
        "pageSize": 10,
        "pageNumber": 0,
        "unpaged": false,
        "paged": true
    },
    "totalPages": 1,
    "totalElements": 1,
    "last": true,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "unsorted": true,
        "sorted": false
    },
    "numberOfElements": 1,
    "first": true,
    "empty": false
}
