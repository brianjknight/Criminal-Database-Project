const headers = {
    authorization: {
      'x-api-key': 'rMqcFCIbdc9NKWaNqxzY34AfYvXdKnoD8vyneoBn'
    }
  }
  
  window.onload = sayHello("again Brian");
  window.onload = sayHello("you are console logging...");
  
  function sayHello(name) {
    console.log("Hello " + name);
  }
  
  const getRecordsByStateForm = document.querySelector("#get-records-by-state-Form");
  let getURLPrefix = "https://rj3uvek7qk.execute-api.us-west-2.amazonaws.com/dev/criminalrecords/filter/";

  getRecordsByStateForm.onsubmit = async function(evt) {
    evt.preventDefault();
    console.log("Getting criminal records by state...");
    const givenState = document.querySelector("#getState").value;
    let getURL = getURLPrefix + givenState;

    let minCrimes = document.querySelector("#getMinNumCrimes").value;
    let maxCrimes = document.querySelector("#getMaxNumCrimes").value;

    if (minCrimes != null && maxCrimes != null) {
        getURL = getURL + "?" + "minNumCrimes=" + minCrimes + "&" 
        + "maxNumCrimes=" + maxCrimes;
    }
    else if (minCrimes != null) {
        getURL = getURL + "?" + "minNumCrimes=" + minCrimes;
    }
    else if (maxCrimes != null) {
        getURL = getURL + "?" + "maxNumCrimes=" + maxCrimes;
    }

    axios.get(getURL, headers).then((res) => {
        console.log(res.data);
    })

  }