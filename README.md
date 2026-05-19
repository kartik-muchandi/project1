# project1

## Docker deployment

This project is a Java WAR-based web application.

Build and run locally with Docker:

```bash
docker build -t project1 .
docker run -p 8080:8080 project1
```

Then open:

```bash
http://localhost:8080/
```

GitHub Actions is configured to build and publish a Docker image to GitHub Container Registry on pushes to `main`.
