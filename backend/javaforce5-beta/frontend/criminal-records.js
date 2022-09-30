const headers = {
  authorization: {
    'x-api-key': 'rMqcFCIbdc9NKWaNqxzY34AfYvXdKnoD8vyneoBn'
  }
}

window.onload = sayHello("Brian");
window.onload = sayHello("again Brian");

function sayHello(name) {
  console.log("Hello " + name);
}

const tableHeaders = ["SSN: ", "Name: ", "DOB: ", "State: ", "Crime_Count: "]

const getCriminalRecordForm = document.querySelector("#get-Criminal-Record-Form");
let getUrlPrefix="https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords";

getCriminalRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();
  document.getElementById("getRecordResultImage").innerHTML = 
    "<img src='images/loading.gif'>";

  console.log("Getting criminal record data...");
  const getSSN = document.querySelector("#getSSN").value;
  const getURL = getUrlPrefix + "/" + getSSN;

  axios.get(getURL, headers).then((res) => {
    console.log(res);
   
    if ("errorMessage" in res.data) {
      document.getElementById("getRecordResult").innerHTML = res.data.errorMessage;
    }
    else {
      document.getElementById("getRecordResult").innerHTML = 
      "SSN: " + res.data.ssn + "<br>" + 
      "Name: " + res.data.name + "<br>" +
      "DOB: " + res.data.dob + "<br>" +
      "State: " + res.data.state + "<br>" +
      "Crime count: " + res.data.crimeCount + "<br>";
    }

    document.getElementById("getRecordResultImage").innerHTML = "";
  })
}

const clearGetRecordForm = document.querySelector("#clearGetRecordForm");
clearGetRecordForm.onsubmit = async function(event) {
  event.preventDefault();
  document.getElementById("getRecordResult").innerHTML = "";
}


const createCriminalRecordForm = document.querySelector("#create-Criminal-Record-Form");
const postURL = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords"

createCriminalRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();

  document.getElementById("createRecordResultImage").innerHTML = 
  "<img src='images/loading.gif'>";

  console.log("Creating criminal record ...");
  const newSsn = document.querySelector("#createSSN").value;
  const newName = document.querySelector("#createName").value;
  const newDob = document.querySelector("#createDOB").value;
  const newState = document.querySelector("#createState").value;

  let criminalRecordObj = {
    "ssn": newSsn,
    "name": newName,
    "dob": newDob,
    "state": newState
  }

  axios.post(postURL, criminalRecordObj, headers).then((res) => {
    console.log(res);

    if ("errorMessage" in res.data) {
      document.getElementById("createRecordResult").innerHTML = res.data.errorMessage;
    }
    else {
      document.getElementById("createRecordResult").innerHTML = 
      "New criminal record created: " + "<br>" + "<br>" +
      "SSN: " + res.data.ssn + "<br>" + 
      "Name: " + res.data.name + "<br>" +
      "DOB: " + res.data.dob + "<br>" +
      "State: " + res.data.state + "<br>" +
      "Crime count: " + res.data.crimeCount + "<br>";
    }

    document.getElementById("createRecordResultImage").innerHTML = "";
  })
}

const clearCreateRecordForm = document.querySelector("#clearCreateRecordForm");
clearCreateRecordForm.onsubmit = async function(event) {
  event.preventDefault();
  document.getElementById("createRecordResult").innerHTML = "";
}

const deleteCriminalRecordForm = document.querySelector("#delete-Criminal-Record-Form");
let deleteURLPrefix="https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords";

deleteCriminalRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();

  document.getElementById("deleteRecordResultImage").innerHTML = 
    "<img src='images/loading.gif'>";
  
  console.log("Expunging/deleting criminal record data...");
  
  const ssnToDelete = document.querySelector("#deleteSSN").value;
  const deleteURL = deleteURLPrefix + "/" + ssnToDelete;


  axios.delete(deleteURL, headers).then((res) => {
    console.log(res);
    
    if (typeof res.data === "object") {
      document.getElementById("deleteRecordResult").innerHTML = res.data.errorMessage;
    }
    else {
      document.getElementById("deleteRecordResult").innerHTML = res.data;
    }
    document.getElementById("deleteRecordResultImage").innerHTML = "";    
  })

}

const clearDeleteRecordForm = document.querySelector("#clearDeleteRecordForm");
clearDeleteRecordForm.onsubmit = async function(event) {
  event.preventDefault();
  document.getElementById("deleteRecordResult").innerHTML = "";
}

const getCrimesForm = document.querySelector("#get-crimes-Form");
let getCrimesURLPrefix = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords/crimes/";

getCrimesForm.onsubmit = async function(evt) {
  evt.preventDefault();

  document.getElementById("getCrimesResultImage").innerHTML = 
    "<img src='images/loading.gif'>";
  
  console.log("Getting list of crimes...");
  const given_SSN = document.querySelector("#getCrimesForSSN").value;
  console.log(given_SSN);
  const getCrimesURL = getCrimesURLPrefix + given_SSN;

  axios.get(getCrimesURL, headers).then((res) => {
    console.log(res);

    if ("errorMessage" in res.data) {
      document.getElementById("getCrimesResult").innerHTML = res.data.errorMessage;
    }
    else {
      if (res.data.length === 0) {
        document.getElementById("getCrimesResult").innerHTML = "No crimes added to record yet."
      }
      else {
        let result = "";

        for (const element of res.data) {
          console.log(element);

          let tempResult = 
          "Case number: " + element.caseNumber + "<br>" +
          "SSN: " + element.ssn + "<br>" +
          "Charge: " + element.charge + "<br>" +
          "Offense level: " + element.offenseLevel + "<br>" +
          "Status: " + element.status + "<br>" + 
          "Date: " + element.date + "<br>" +
          "Sentence in days: " + element.sentenceInDays + "<br>" + "---------------------------" + "<br>";
          
          result += tempResult;
        }

        document.getElementById("getCrimesResult").innerHTML = result;
      }      
    }
    document.getElementById("getCrimesResultImage").innerHTML = "";
  })
  
}

const clearCrimesRecordForm = document.querySelector("#clearCrimesRecordForm");
clearCrimesRecordForm.onsubmit = async function(event) {
  event.preventDefault();
  document.getElementById("getCrimesResult").innerHTML = "";
}

const addCrimeToRecordForm = document.querySelector("#add-crime-to-record-Form");
let addCrimesURLPrefix = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords/crimes/";

addCrimeToRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();

  document.getElementById("addCrimesResultImage").innerHTML = 
    "<img src='images/loading.gif'>";

  console.log("Adding crime to criminal record...");
  const given_SSN = document.querySelector("#addCrimeSSN").value;
  const addCrimeURL = addCrimesURLPrefix + given_SSN;
  const givenCaseNumber = document.querySelector("#addCrimeCaseNumber").value;
   
  let crimeObj = {
    "caseNumber": givenCaseNumber
  }

  axios.put(addCrimeURL, crimeObj, headers).then((res) => {
    console.log(res);

    if ("errorMessage" in res.data) {
      document.getElementById("addCrimesResult").innerHTML = res.data.errorMessage;
    }
    else {

      let crimeList = res.data.crimes;
      let crimeAdded = crimeList[crimeList.length - 1];
      console.log(crimeAdded);

      document.getElementById("addCrimesResult").innerHTML = 
      "Criminal record: " + "<br>" + "<br>" +
      "SSN: " + res.data.ssn + "<br>" + 
      "Name: " + res.data.name + "<br>" +
      "DOB: " + res.data.dob + "<br>" +
      "State: " + res.data.state + "<br>" +
      "Crime count: " + res.data.crimeCount + "<br>" + "<br>" +
      "---------------------------" + "<br>" + "<br>" +
      "Case added to record: " + "<br>" + "<br>" +
      "Case number: " + crimeAdded.caseNumber + "<br>" + 
      "SSN: " + crimeAdded.ssn + "<br>" +
      "Charge: " + crimeAdded.charge + "<br>" +
      "Offense level: " + crimeAdded.offenseLevel + "<br>" +
      "Status: " + crimeAdded.status + "<br>" + 
      "Date: " + crimeAdded.date + "<br>" +
      "Sentence in days: " + crimeAdded.sentenceInDays + "<br>";
    }

    document.getElementById("addCrimesResultImage").innerHTML = "";
  })
}

const clearAddCrimesRecordForm = document.querySelector("#clearAddCrimesRecordForm");
clearAddCrimesRecordForm.onsubmit = async function(event) {
  event.preventDefault();
  document.getElementById("addCrimesResult").innerHTML = "";
}