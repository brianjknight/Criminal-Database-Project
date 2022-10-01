# JavaForce5
Project Rubric

## Background

*This captures the expectations that we have for your team during the unit.
This is how we will evaluate whether you have demonstrated these expectations.*

## Instructions

*As a team, complete this rubric (everything except for the Appendix) by
answering the questions below. Each question should usually only require one or
two sentences, so please be brief. The remainder of expectations will be
evaluated by instructors, so you don’t need to write anything in the Appendix.
We want you to see the full set of expectations for transparency’s sake.*

## Deliverables

*Provide links to the following project deliverables:*

|Deliverable                                                      |Due Date                  | Date Completed | URL                                                                                                                                                     |
|---                                                              |---                       |----------------|---------------------------------------------------------------------------------------------------------------------------------------------------------|
|Team name                                                        |Sprint 1 Module 1         | 9/9/22         | name: JavaForce5   <br/>https://github.com/BloomTechBackend/bd-team-project-javaforce5/tree/Sprint_2/backend/javaforce5-beta                            |
|[Design Document - problem statement](templates/design_document_template.md)        |Sprint 1 Module 2         | 9/9/22         | https://github.com/BloomTechBackend/bd-team-project-javaforce5/blob/Sprint_2/backend/javaforce5-beta/project_documents/design_document.md               |
|[Team Charter](team_charter.md)                                  |Sprint 1 Module 3         | 9/10/22        | https://github.com/BloomTechBackend/bd-team-project-javaforce5/blob/Sprint_2/backend/javaforce5-beta/project_documents/team_charter.md                  |
|[Design Document](templates/design_document_template.md)                            |Sprint 1 REQUIRED TO GO ON| 9/10/22        | https://github.com/BloomTechBackend/bd-team-project-javaforce5/blob/Sprint_2/backend/javaforce5-beta/project_documents/design_document.md               |
|Project Completion (Feature Complete)                            |Sprint 3                  |                | https://github.com/BloomTechBackend/bd-team-project-javaforce5/tree/Sprint_2/backend/javaforce5-beta                                                    |
|[Team Reflection](templates/reflection_template.md)                                 |Sprint 3                  |                |    https://github.com/BloomTechBackend/bd-team-project-javaforce5/blob/Sprint_2/backend/javaforce5-beta/project_documents/reflection.md                                                                                                                                                     |
|[Accomplishment Tracking (person 1)](accomplishment_tracking.md) |Sprint 3                  |                | https://github.com/BloomTechBackend/bd-team-project-javaforce5/blob/Sprint_2/backend/javaforce5-beta/project_documents/accomplishment_tracking_Brian.md |
|[Accomplishment Tracking (person 2)](accomplishment_tracking.md) |Sprint 3                  |                | n/a                                                                                                                                                     |
|[Accomplishment Tracking (person 3)](accomplishment_tracking.md) |Sprint 3                  |                | n/a                                                                                                                                                     |
|[Accomplishment Tracking (person 4)](accomplishment_tracking.md) |Sprint 3                  |                | n/a                                                                                                                                                     |
|Self Reflection                                                  |Sprint 3                  |                | n/a (will be submitted via Canvas - "Wrap-up" section)                                                                                                  |

## Technical Learning Objectives

### API Design

**Design an API to meet the needs of your application.** Provide a link to the
definition for your endpoints (can be code/configuration, or can be
documentation). List one thing that your team learned about designing a good
API.

*Endpoint definition location:*      
https://criminal-records-api-bucket.s3.us-west-2.amazonaws.com/api.html 

*What we learned:*      
* Swagger is an excellent tool for coding your API documentation so that you can save the file to import into AWS API Gateway.
* YAML files are very sensitive to indents and spacing.

**Develop a service endpoint definition that uses complex inputs and outputs.**
Select one of your endpoints and list the operation’s input and output objects.
Under each, list its attributes.

*Endpoint:*   /criminalrecords -d '{"ssn": "999-99-9999","name": "James Hetfield","dob": "8/3/1963","state": "CA"}'

*Input object(s):* takes in 4 attributes

* ssn
* name
* dob
* state

*Output object(s):*

* ssn
* name
* dob
* state
* count of crimes initialized as 0

**Given a user story that requires a user to provide values to a service
endpoint, design a service endpoint including inputs, outputs, and errors.**
Select one of your endpoints that accepts input values from a client. List the
error cases you identified and how the service responds in each case. Provide at
most 3 error cases.

U4. As a customer, I want to add a new crime to person's list of crimes.

| **Endpoint:**                                 | /criminalrecords/{ssn} |
|-----------------------------------------------|------------------------|
| **Error case**                                | **Service response**   |
| Using '[ ]' brackets in request                 | HTTP Error 400         |
| Bad endpoint:  criminalrecordsXXX/111-22-0000 | HTTP Error 403         |

**Develop a service endpoint definition that uses query parameters to determine
how results are sorted or filtered.** List at least one endpoint that allows
sorting or filtering of results. Which attribute(s) can be sorted/filtered on?

*Endpoint:*     
/criminalrecords/filter/{state}

*Attribute(s):*  
* This endpoint uses a GSI to return Criminal Records for only the given state. 
* 2 optional query parameters for filtering:
  * minNumCrimes to include Criminal Records with greater than or  equal to the minimum Integer given.
  * maxNumCrimes to include Criminal Records with less than or  equal to the maximum Integer given.

**Determine whether a given error condition should result in a client or server
exception.** List one client exception and one server exception that your
service code throws. List one condition in which this exception is thrown.

|                     | **Exception**    | **One case in which it is thrown** |
|---	                |------------------|------------------------------------|
|**Client exception:**  | HTTP Error 403 	 | 	 Using a bad endpoint             |
|**Service exception:** | 	HTTP Error 500  | 	 Server times out                 |

### DynamoDB Table Design

**Decompose a given set of use cases into a set of DynamoDB tables that provides
efficient data access.** List the DynamoDB tables in your project:

1.  CriminalRecords
2.  Crimes

**Design a DynamoDB table key schema that allows items to be uniquely
identified.** Describe the primary key structure for your DynamoDB table with
the most interesting primary key. In a sentence or two, explain your choice of
partition/sort key(s).

1. CriminalRecords - partition only primary key using a person's social security number.
2. Crimes - partition only primary key using a unique case number.

**Design the attributes of a DynamoDB table given a set of use cases.** List a
DynamoDB table with at least 3 attributes. List one relevant use case that uses
the attribute. In one sentence, describe why the attribute is included.

**Table name:**   CriminalRecords
 
**Attributes:**

| Attribute name | (One) relevant use case                                        | attribute purpose                  |
|----------------|----------------------------------------------------------------|------------------------------------|
| ssn            | Find a criminal record for a specific person.                  | unique identifier                  |
| name           | Make sure the person's name is correct for the SSN.            | The criminal's full name.          |
| dob            | Filtering/sorting by age for statistical purposes.             | Date of birth to determine age.    |
| state          | Filtering/sorting by state for statistical purposes.           | Location where the criminal lives. |
| crimeCount     | Filter/sorting by number of crimes to find repeat offenders.   | Total number of crimes committed.  |
| crimes         | Retrieve a list of Crime object to show details of each crime. | List of the crimes committed.      |

### DynamoDB Indexes

**Design a GSI key schema and attribute projection that optimizes queries not
supported by a provided DynamoDB table.** In one or two sentences, explain why
you created one of the GSIs that your project uses, including one use case that
uses that index.

**Table name:**  CriminalRecords

**Table keys:**  Partition only primary key of social security number which is a unique identifier.

**GSI keys:**  StateIndex

**Use case for GSI:**  Find all CriminalRecords for a specific state.

**Implement functionality that uses query() to retrieve items from a provided
DynamoDB's GSI.** List one of your use cases that uses `query()` on a GSI.

**Table name:**  CriminalRecords -> StateIndex

**Use case for `query()` on GSI:**
* Retrieving records for statistical or investigative purposes for Criminal Records in a single state within min/max number of crimes committed.

## Soft(er) Outcomes

**Learn a new technology.** For each team member, list something new that that
team member learned:

| Team Member | Something new the team member learned                      |   
|-------------|------------------------------------------------------------|
| Brian       | Using DynamoDBQueryExpression and its optional attributes. |   
| Brian       | Learning how Gradle builds work with dependencies.         |     
| Brian       | HTML DOM manipulating HTML with JavaSript                  |     

**Identify key words to research to accomplish a technical goal | Use sources
like sage and stack overflow to solve issues encountered while programming.**
Give an example of a search term that your team might have used to find an
answer to a technical question/obstacle that your team ran into. List the
resource that you found that was helpful.

**Search terms:**      FilterExpression, ExpressionAttributeName

**Helpful resource:**  https://docs.aws.amazon.com/sdk-for-java/v1/developer-guide/welcome.html  

**Find material online to learn new technical topics.** List one resource that
your team found on your own that helped you on your project.

**Topic:**  DynamoDBQueryExpression

**Resources:**  
* https://docs.aws.amazon.com/AWSJavaSDK/latest/javadoc/com/amazonaws/services/dynamodbv2/datamodeling/DynamoDBQueryExpression.html
* AWS DynamoDB Query Pagination Tutorial  https://www.youtube.com/watch?v=Ifcic-JIw1k&t=633s
* Load, Save, Query, Delete, with DynamoDB Mapper  https://www.youtube.com/watch?v=m61Uo_PGwVc

**Topic:**  HTML DOM

**Resources:**
* https://www.w3schools.com/js/js_htmldom.asp