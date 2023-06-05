# Search-Engine

The Search Engine with Web Crawler Integration is a Java Swing application developed using Maven, Jsoup, and MySQL. It combines the functionality of a search engine with a powerful web crawler backend that utilizes a Depth-First Search (DFS) approach to retrieve and present users with the top 30 web pages related to their query.

The core of this application revolves around providing users with an intuitive and efficient search experience. The Java Swing interface offers a user-friendly environment where users can enter their search queries and initiate the search process. 

When a query is submitted, the backend DFS web crawler is triggered, starting from a designated seed URL. The crawler systematically explores web pages, following links and extracting relevant information using the Jsoup library. The extracted data includes page titles, URLs, and content. This information is then stored in a MySQL database, allowing for quick retrieval and efficient searching.

Upon receiving the search query, the application performs a search against the indexed data in the database. The search engine ranks the web pages based on relevance to the query, considering factors such as keyword frequency, location, and relevance algorithms. The top 30 results are then presented to the user, showcasing clickable titles and corresponding URLs.

The integration of a web crawler allows the search engine to continuously update and expand its index by crawling new web pages and capturing relevant information. This ensures that users have access to the most up-to-date and comprehensive search results.

The Search Engine with Web Crawler Integration offers users a powerful and efficient tool to discover web content related to their queries. By combining the functionalities of a search engine and a web crawler, users can explore a vast array of web pages and find relevant information quickly and accurately.

Built using Java Swing, Maven, Jsoup, and MySQL, this application demonstrates the seamless integration of frontend and backend technologies to provide a robust and user-friendly search experience. Whether for research, information gathering, or general curiosity, the Search Engine with Web Crawler Integration empowers users with a reliable and comprehensive search tool.
