const express = require('express')
const request = require('request');
const app = express();
const port = 3000;
const env = process.env.COPILOT_ENVIRONMENT_NAME
const backendSvcDiscovery = process.env.COPILOT_SERVICE_DISCOVERY_ENDPOINT
const backendPort = 8080;


const backendEndpoint = "http://copilot-backend." + backendSvcDiscovery + ":" + backendPort; // this is a full endpoint url for invoking backend app
console.log("Backend Endpoint: " + backendEndpoint);

// Display Frontend hello-nodejs root response (when uri match: '/')
app.get('/', (req, res) => {
  // console.log("Hello Get is called from client (" + req.socket.remoteAddress + ")")
  res.send('This is AWS Copilot Hello App! (*Environment: ' + env + ")")
});

// Display Backend hello-java root response (when uri match: '/call-backend')
app.get('/call-backend', (req, res) => {
  request(backendEndpoint, function (error, response, body) {
    if (!error && response.statusCode == 200) {
        console.log(body)
        res.send(body)
     }
  })
});

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
});