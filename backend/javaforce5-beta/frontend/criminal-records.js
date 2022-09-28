
window.onload = sayHello("Brian");
window.onload = sayHello("again Brian");

function sayHello(name) {
  console.log("Hello " + name);
}

let getURL="https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords/999-77-5555";

let getHeaders = {
  authorization: {
    'x-api-key': 'rMqcFCIbdc9NKWaNqxzY34AfYvXdKnoD8vyneoBn'
  }
}

async function getCriminalRecord() {
  axios.get(getURL, getHeaders).then((res) => {
    console.log(res);
  })
}

window.onload = getCriminalRecord();

let postURL = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords"
let putHeaders = {
  authorization: {
    'x-api-key': 'rMqcFCIbdc9NKWaNqxzY34AfYvXdKnoD8vyneoBn'
  }
}

const createCriminalRecordForm = document.querySelector("#create-Criminal-Record-Form");

createCriminalRecordForm.onsubmit = async function(event) {
  event.preventDefault();
  let newSsn = document.querySelector("#ssn").value;
  let newName = document.querySelector("#name").value;
  let newDob = document.querySelector("#dob").value;
  let newState = document.querySelector("#state").value;

  let criminalRecordObj = {
    "ssn": newSsn,
    "name": newName,
    "dob": newDob,
    "state": newState
  }

  axios.post(postURL, criminalRecordObj, putHeaders).then((res) => {
    console.log(res);
    window.location.reload();
  })


}