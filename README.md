# Countries Information REST API

Welcome to the Countries Information REST API! This application provides an easy-to-use interface for accessing a wealth of information about countries from around the world. Leveraging the REST Countries API as its primary data source, this API offers powerful features for filtering, sorting, and limiting country data. Built using Spring Boot and Java, the backend ensures efficient handling of requests and responses while maintaining a user-friendly experience.

## Getting Started

To run the Countries Information API locally, follow these steps:

1. Clone this repository: `git clone [repository link]`
2. Ensure you have Java and Maven installed on your system.
3. Navigate to the project's root directory in your terminal.
4. Run the command: `mvn spring-boot:run`
5. Access the API at: `http://localhost:8080`

## Example Usage

Explore the capabilities of the API with these example queries:

1. Retrieve information about all countries: `GET /countries`
2. Filter countries by name: `GET /countries?countryName=United`
3. Filter countries by population under 50 million: `GET /countries?populationThreshold=50`
4. Sort countries in ascending order: `GET /countries?sort=ascend`
5. Sort countries in descending order: `GET /countries?sort=descend`
6. Limit results to 10 countries: `GET /countries?limit=10`
7. Combine filters: `GET /countries?countryName=China&populationThreshold=100&sort=ascend&limit=5`
8. Case-insensitive name filter: `GET /countries?countryName=germany`
9. Find countries with populations under 20 million and sort descending: `GET /countries?populationThreshold=20&sort=descend`
10. Retrieve a specific number of countries: `GET /countries?limit=3`
11. Get countries with names containing "island": `GET /countries?countryName=island`
12. Filter by population and sort results: `GET /countries?populationThreshold=10&sort=ascend`

Feel free to customize your queries by combining filters and sorting options to obtain the specific country information you're looking for.

## Contributing

We welcome contributions to enhance the features and usability of the API. Please open an issue to discuss potential changes or submit a pull request for review.

## License

This project is licensed under the [MIT License](LICENSE).