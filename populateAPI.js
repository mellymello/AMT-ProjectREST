var querystring = require('querystring');
var http = require('http');
var fs = require('fs');


var port = 8080; 
var hostname = '10.192.86.146';  
var pathPOSTObs = '/amtProject/api/observations'; 

var postObs = function(id){
	var post_data = '{"time":"'+new Date().toJSON()+'", "value":'+Math.floor((Math.random() * 100) + 1)+',"sensor":'+null+'}'; 
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
for (var i = 0; i < 1000; i++)
{
	postObs(i);
}