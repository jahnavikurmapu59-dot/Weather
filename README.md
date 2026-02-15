Weather Info REST API
This project is a Spring Boot based REST API that provides weather information for a given pincode and date. The main goal of the application is not only to fetch weather data but also to store it in a database so that repeated requests for the same pincode and date can be served quickly without calling the external API again. This improves performance and reduces unnecessary external API usage.
The application follows a clean and simple layered structure with Controller, Service, and Repository components. It uses Spring Data JPA for database operations and H2 as an in-memory database for development and testing.
What This Application Does
Accepts a pincode and date as input
Checks whether weather data for that combination already exists in the database
If data exists, returns it directly from the database
If data does not exist, fetches it from the external weather API
Stores the fetched data in the database
Returns the saved response
This design ensures that external API calls are minimized and repeated requests are handled efficiently.
Tech Stack
Java 17
Spring Boot
Spring Data JPA
H2 Database
Maven
API Endpoint
The application exposes the following endpoint:
GET /weather?pincode={pincode}&date={yyyy-MM-dd}
Example:
/weather?pincode=411014&date=2020-10-15
The response includes:
Pincode
Latitude
Longitude
Date
Temperature
Weather description
Security Considerations for API Key
For security reasons, the external weather API key is not stored directly in the source code.
Hardcoding API keys in a public repository can lead to:
Unauthorized use of the API
Misuse of the key by third parties
Unexpected billing or quota exhaustion
Exposure of sensitive credentials
To avoid these risks, the application reads the API key from an environment variable instead of storing it in the project files.
To set the API key:
Linux / macOS / Codespaces:
export OPENWEATHER_API_KEY=your_api_key_here
Windows PowerShell:
setx OPENWEATHER_API_KEY "your_api_key_here"
This ensures that sensitive information is never committed to version control.
How to Run the Application:
Use the following commands:
mvn clean install
mvn spring-boot:run
The application runs on port 8080 by default.
Possible Improvements:
Add unit and integration tests
Add API documentation using Swagger
Implement centralized exception handling
Containerize using Docker
Deploy to a cloud platform
