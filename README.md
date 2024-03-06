# Post Service & Storage Service

The Post Service is a backend application outlined to oversee posts, comments, and responses inside a social media stage.Moreover, , the application contains storage service, which is centralized on microservices for storing files and the application also communicates with minio s3 and stores data in mongo. Simply put, it uses innovations such as:

## Technologies Used

- **PostgreSQL:** A powerful open-source relational database system.
- **GORM:** Post service uses GORM as ORM to work with SQL
- **Docker:** Containerization platform for packaging, distributing, and running applications.

## Features and Functionality

## Technologies Used

- **MongoDB:** A NoSQL database for storing file metadata and references.
- **Minio:** object storage server compatible with S3.
- 		Creds:  credentials.NewStaticV4(env.MinioAccessKey, env.MinioSecretKey, env.MinioToken),
- **Docker:** Containerization platform for seamless deployment.


### Manage publications

1. **Create a publication:**
- Permits you to make messages with substance, proprietor recognizable proof and message sort (for case, a client profile message or a channel message).

2. **Get messages:**
- Empowers message recovery based on proprietor ID and message sort.

3. **Update post content:**
- Permits clients to overhaul the substance of their posts.

4. **Erase messages:**
- Gives the capacity to erase messages.


# Storage Service

The Storage Service isis dependable for overseeing record capacity related to the Post Benefit. It utilizes the taking after innovations:

## Highlights and Usefulness

### Record Capacity

1. **Handle Record Transfers:**
- Oversees record transfers related with posts and comments from the Post Benefit.

### MongoDB Integration

1. **Store Metadata and References:**
- Stores metadata and references to records in MongoDB.

### Minio Integration

1. **Utilize Minio for Record Capacity:**
- Utilizes Minio, an question capacity server congruous with S3, for versatile and conveyed record capacity.
