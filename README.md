#### Project Description

This is a AWS Lambda function written in Kotlin to implement basic arithmetic operations such as "ADD", "SUBTRACT", "MULTIPLY", "DIVIDE".

#### Compilation

clone repository

> gh repo clone sauravdwivedi/AWS-Lambda

cd to app directory AWS-Lambda/BasicArithmeticOperations, and run

> ./gradlew shadowJar

Output "jvmlangs-kotlin-1.0-SNAPSHOT-all.jar" is located in build/libs/ .

#### Create AWS Lambda function

Log in to AWS Lambda Console

> https://eu-west-1.console.aws.amazon.com/lambda/

Click "Create function", chose "Author from scratch", enter Function name "arithmetic-ops", chose runtime "Java 8", upload "jvmlangs-kotlin-1.0-SNAPSHOT-all.jar" in Code source, and set Handler:

> com.aws.blog.jvmlangs.kotlin.Main::handler

#### Test

Test funtion with a JSON request body

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

#### API Gateway test

![API Gateway test](API_Gateway_test.png?raw=true "Title")
