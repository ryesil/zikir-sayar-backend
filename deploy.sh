#!/bin/bash

# Variables
JAR_FILE="zikirSayar-0.0.1-SNAPSHOT.jar"
EC2_USER="ec2-user"
EC2_HOST="ec2-52-204-18-156.compute-1.amazonaws.com"
PEM_FILE="fikir-backend.pem"
LOCAL_JAR_PATH="target/$JAR_FILE"
REMOTE_JAR_PATH="/home/ec2-user/$JAR_FILE"

# Build the project
mvn clean package

# Connect to EC2 and perform operations
ssh -i "$PEM_FILE" "$EC2_USER@$EC2_HOST" << EOF
    # Stop the running Spring Boot application
    pkill -f "$JAR_FILE" || true

    # Remove the old JAR file
    rm -f "$REMOTE_JAR_PATH"

    # Exit the SSH session
    exit
EOF

# Copy the new JAR file to the EC2 instance
scp -i "$PEM_FILE" "$LOCAL_JAR_PATH" "$EC2_USER@$EC2_HOST:$REMOTE_JAR_PATH"

# Start the Spring Boot application with the production profile
ssh -i "$PEM_FILE" "$EC2_USER@$EC2_HOST" "nohup java -jar $REMOTE_JAR_PATH --spring.profiles.active=production > output.log 2>&1 &"