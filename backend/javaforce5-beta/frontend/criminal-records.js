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

const getCriminalRecordForm = document.querySelector("#get-Criminal-Record-Form");
let getUrlPrefix="https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords";

getCriminalRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();
  console.log("Getting criminal record data...");
  const getSSN = document.querySelector("#getSSN").value;
  const getURL = getUrlPrefix + "/" + getSSN;

    axios.get(getURL, headers).then((res) => {
    console.log(res);
    let criminalRecord = res.data;
    console.log(criminalRecord);
    window.location.reload();
  })

}

const createCriminalRecordForm = document.querySelector("#create-Criminal-Record-Form");
const postURL = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords"

createCriminalRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();
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

  console.log(criminalRecordObj);

  axios.post(postURL, criminalRecordObj, headers).then((res) => {
    console.log(res);
    // window.location.reload();
  })
}

const deleteCriminalRecordForm = document.querySelector("#delete-Criminal-Record-Form");
let deleteURLPrefix="https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords";

deleteCriminalRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();
  console.log("Expunging/deleting criminal record data...");
  const ssnToDelete = document.querySelector("#deleteSSN").value;
  const deleteURL = deleteURLPrefix + "/" + ssnToDelete;

    axios.delete(deleteURL, headers).then((res) => {
    console.log(res);
    // window.location.reload();
  })

}

const getCrimesForm = document.querySelector("#get-crimes-Form");
let getCrimesURLPrefix = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords/crimes/";

getCrimesForm.onsubmit = async function(evt) {
  evt.preventDefault();
  console.log("Getting list of crimes...");
  const given_SSN = document.querySelector("#getCrimesForSSN").value;
  console.log(given_SSN.value);
  const getCrimesURL = getCrimesURLPrefix + given_SSN;

  axios.get(getCrimesURL, headers).then((res) => {
    console.log(res);
  })

}

const addCrimeToRecordForm = document.querySelector("#add-crime-to-record-Form");
let addCrimesURLPrefix = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords/crimes/";

addCrimeToRecordForm.onsubmit = async function(evt) {
  evt.preventDefault();
  console.log("Adding crime to criminal record...");
  const given_SSN = document.querySelector("#addCrimeSSN").value;
  const addCrimeURL = addCrimesURLPrefix + given_SSN;
  const givenCaseNumber = document.querySelector("#addCrimeCaseNumber").value;
   
  let crimeObj = {
    "caseNumber": givenCaseNumber
  }

  axios.put(addCrimeURL, crimeObj, headers).then((res) => {
    console.log(res);
    // window.location.reload();
  })
}