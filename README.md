#### Project Description

This is a Kotlin application with [Gradle](https://docs.gradle.org/current/samples/sample_building_kotlin_applications.html) to implement basic arithmetic operations such as "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE". The application is deployed as AWS Lambda function. Lambda function is further turned into an API Gateway with endpoint URL:

> https://emmsqwgcie.execute-api.us-east-1.amazonaws.com/default/arithmetic-operations

#### Compilation

clone repository

> gh repo clone sauravdwivedi/AWS-Lambda

cd to app directory AWS-Lambda/arithops, and run

> ./gradlew shadowJar

Output "arithops-1.0-SNAPSHOT-all.jar" is located in build/libs/ .

#### Test

> ./gradlew check 

#### Create AWS Lambda function

Log in to AWS Lambda Console

> https://eu-west-1.console.aws.amazon.com/lambda/

Click "Create function", chose "Author from scratch", enter Function name "arithmetic-ops", chose runtime "Java 8", upload "jvmlangs-kotlin-1.0-SNAPSHOT-all.jar" in Code source, and set Handler:

> Main::handler

#### Test funtion with a JSON request body

#### Request body example

{
  "first_number": 100,
  "second_number": 200,
  "operation": "ADD"
}

#### Response body example

{
  "result": 300
}

#### Acceptable operations

> "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE"

#### API Gateway

To generate endpoint, click Add trigger, select "API Gateway", chose "REST API".

#### Endpoint URL

> https://emmsqwgcie.execute-api.us-east-1.amazonaws.com/default/arithmetic-operations

#### API Gateway test using Postman

![API Gateway test](Test_Endpoint_Postman.png?raw=true "Title")
