var querystring = require('querystring');
var http = require('http');
var fs = require('fs');


var port = 80; 
var hostname = 'http://localhost'; 
var pathGETObs = '/api/observations'; 
var pathPOSTObs = '/api/observations'; 


var post_data =[{"_id":ids[i]._id+}, {"date":new Date().getTime()}, {"value":Math.floor((Math.random() * 100) + 1)}]; 
  // An object of options to indicate where to post to
  var post_options = {
      host: hostname,
      port: port,
      path: pathPOSTObs,
      method: 'POST',
      headers: {
          'Content-Type': 'application/json',
          'Content-Length': post_data.length
      }
  };

  // Set up the request
  var post_req = http.request(post_options, function(res) {
      res.setEncoding('utf8');
      res.on('data', function (chunk) {
          console.log('Response: ' + chunk);
      });
  });

  // post the data
  post_req.write(post_data);
  post_req.end();

}