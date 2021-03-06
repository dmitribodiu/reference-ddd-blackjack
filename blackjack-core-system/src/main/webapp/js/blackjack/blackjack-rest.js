var registrationURI = 'http://localhost:9090/blackjack/register/'
var balanceURI = 'http://localhost:8080/blackjack-wallet/rest/wallet/account/balance/'

function getBalance(processBalanceResponse) {
	$.ajax({
		type : "GET",
		url : balanceURI + session.playerId,
		//contentType : 'application/json; charset=utf-8',
		crossDomain: true,
	    dataType: "text",
		data : {},
		success : function(balanceResponse) {
			console.log('get balance success ', balanceResponse)
			processBalanceResponse(balanceResponse)
		},
		failure : function(data) {
			console.log('failure', data);
		},
		error : function(request, status, error) {
			console.log("something went wrong \nrequest.responseText : "
					+ request.responseText + "\nstatus: " + status + "\nerror:"
					+ error);
		}
	});
}

function logger(some) {
	console.log('logger', some)
}


function callRegister(name, afterRegistration) {
	$.ajax({
		type : "GET",
		url : registrationURI + name,
		dataType: "text",
		success : function(anId) {
			console.log('registration success ', anId)
			afterRegistration(anId, name)
		},
		failure : function(data) {
			console.log('failure', data);
		},
		error : function(request, status, error) {
			console.log("something went wrong \nrequest.responseText : "
					+ request.responseText + "\nstatus: " + status + "\nerror:"
					+ error);
		}
	});
}

function restEchoTest() {
    $.ajax
    ({
        type: "GET",
        url: registrationURI + 'echo/test',
        dataType: "text",
        success: function (result) {
            console.log('echo success: ',result);
        },
		failure : function(data) {
			console.log('failure', data);
		},
		error : function(request, status, error) {
			console.log("something went wrong \nrequest.responseText : "
					+ request.responseText + "\nstatus: " + status + "\nerror:"
					+ error);
		}
    });
}

function restEchoTest2() {
	$.ajax({
		type : 'GET',
		url : 'http://localhost:9090/blackjack/register/echo/test',
		contentType : 'application/x-javascript',
		crossDomain: true,
	    dataType: 'jsonp',
	    responseencoding : JSON,
	    jsonp: 'callbackname',
		//data : {},
		xhrFields: {
		      withCredentials: true
		},
		callback : function(resp) { console.log('RESP',resp) },
		//beforeSend: setHeader,
		success : function(response) {
			console.log('echo response is ', response)
		},
		failure : function(data) {
			console.log('failure', data);
		},
		error : function(request, status, error) {
			console.log("something went wrong \nrequest.responseText : "
					+ request.responseText + "\nstatus: " + status + "\nerror:"
					+ error);
		}
	});	
}