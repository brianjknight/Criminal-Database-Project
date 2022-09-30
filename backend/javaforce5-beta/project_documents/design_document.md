# JavaForce5 Design Document

## Criminal Records Database Design

## 1. Problem Statement
Many crimes are committed every day which each have a lot of associated information. It is important to keep a detailed database of these criminal records. They are used by a number of entities such as police, states, employers, landlords, stalkers, etc.  

This design document describes a basic criminal records service that allows an agency such as a police department to read, add, update, and delete criminal records.
## 2. Top Questions to Resolve in Review

*List the most important questions you have about your design, or things that
you are still debating internally that you might like help working through.*

1. Should I create separate tables for Crimes, CriminalRecord, and Criminal/Person? I could possibly have a crime with multiple criminals and criminals with multiple crimes.
   1. Maybe have a CriminalRecord for a person with their personal data and a list of Crimes committed.
2. Depending on the structure what is a single partition primary key or composite primary key appropriate?
3. Is there a need to identify all CriminalRecords by location, date, Criminal, type, status, etc?
   1. This could be an opportunity for creating DDB indexes.


## 3. Use Cases

U1. As a customer, I want to create a new criminal record for a first time offender.

U2. As a customer, I want to retrieve a CriminalRecord to see if it exists for a person.

U3. As a customer, if a CriminalRecord exists, I want to retrieve a list of their crimes. 

U4. As a customer, I want to add a new crime to person's list of crimes.

U5. As a customer, I want to update a state if a person moves. 

U6. As a customer, I want to delete a criminal record if ordered to be expunged by the court.

U7. As a customer, I want to retrieve all CriminalRecords by state for statistical purposes.

U8. As a customer, I want to retrieve crimes by status.

U9. As a customer, I want to retrieve crimes by date.

U10. As a customer, I want to retrieve crimes by offense level.

U11. As a customer, I want to retrieve crimes by location.

## 4. Project Scope

### 4.1. In Scope
* CRUD operations for a single criminal record.
   * U1 Create a new record
   * U2 Retrieve existing record
   * U6 Delete a record
   * U3 Retrieve crime list from the record
   * U4 Update a record by adding a crime to the crime list
* Use at least one secondary index on the DDB table to run a query.
  * U7 retrieve records by state.


### 4.2. Out of Scope
* U5 updating a Crime within the list of Crimes in a CriminalRecord.
* There would be multiple needs to look up crime statistics by secondary indexes (use cases U8-U11). 
   For purposes of this project these will be out of scope.
* CRUD operations for Crimes table. We will populate data with a fixed set of Crimes.

# 5. Proposed Architecture Overview

This initial iteration will provide the minimum lovable product (MLP) including
creating, retrieving, updating, and deleting a criminal record.

We will use API Gateway and Lambda to create four endpoints (`CreateCriminalRecord`, `GetCriminalRecord`,
 `UpdateCriminalRecord`, and `DeleteCriminalRecord`)
that will handle the creation, updating, retrieval, and deleting criminal records to satisfy the requirements.

Criminal records will be stored in DynamoDB table using a composite primary key of 
Social Security Number for the partition key and case number for sort key.

We will provide a web interface for users to manage the criminal record database.

# 6. API

## 6.1. Public models

```
// CriminalRecord

String ssn;
String name;
String dob;
String state;
Integer crimeCount;
List<Crime> crimes;
```
```
// Crime

String caseNumber;
String ssn;
String charge;
String offenseLevel;
String status;
String date;
Integer sentence;

```

## 6.2. Get CriminalRecord Endpoint

* Accepts GET requests to /criminalrecords/{ssn}
* Accepts a Social Security Number (SSN) and returns the record for that person.
  * If the SSN is not found, throw a NoCriminalRecordException

![img.png](images/design_document_images/get-criminal-record.png)

## 6.3 Create CriminalRecord Endpoint

* Accepts POST requests to /criminalrecords
* Accepts data to create a new CriminalRecord with SSN, name, DOB, and state.
* For security concerns, we will validate the provided playlist name does not contain any invalid characters: " ' \`
  If the playlist name contains any of the invalid characters, will throw an InvalidAttributeValueException.

![img_1.png](images/design_document_images/create-criminal-record.png)

## 6.4 Delete CriminalRecord Endpoint

* Accepts DELETE requests to /criminalrecords/{ssn}
* Accepts a Social Security Number (SSN) and deletes the record for that person.
    * If the SSN is not found, throw a NoCriminalRecordException
  
![img_2.png](images/design_document_images/delete-criminal-record.png)

## 6.5 Get CriminalRecords by state endpoint
* Accepts GET requests to /criminalrecords/filter/{state}
  * Optional query parameters for minimum and maximum number of crimeCount to include in results?
* Retrieves a list of Criminal Records that match the given state and crimeCount.

![img.png](images/get-criminal-record-by-state-puml.png)

## 6.6 Add Crime to CriminalRecord Endpoint

* Accepts PUT requests to /criminalrecords/crimes
* Accepts a SSN and a Crime to be added to that person's list of Crimes
  * If the SSN is not found, throw a NoCriminalRecordException
  * If the Crime is not found, throw CrimeNotFoundException

![img_3.png](images/design_document_images/add-crime-to-criminal-record.png)

## 6.7 Get CriminalRecord crimes Endpoint

* Accepts GET requests to /criminalrecords/crimes/{ssn}
* Retrieves list of all crimes committed by the person with given SSN
  * If the SSN is not found, throw a NoCriminalRecordException

![img_4.png](images/design_document_images/get-crimes-from-criminal-record.png)

# 7. Tables

## 7.1 criminal_records
```
ssn // partition key, string
name // string
dob // string
state // string
crimeCount // integer
crimes // List of Crimes
```

## 7.2 crimes
```
caseNumber // partition key, string
charge // string
offenseLevel // string
status // string
date // string
sentence // integer
```

# 8. Pages
![](images/design_document_images/criminal-records-webpage.png)

![](images/design_document_images/criminal-record-filter-page.png)