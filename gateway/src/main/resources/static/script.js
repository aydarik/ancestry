////////////////////////////////////////////////
/////////////// AUTHORIZATION //////////////////
////////////////////////////////////////////////

function addUser() {
	var username = document.getElementById('user_login').value;
	var password = document.getElementById('user_password').value;

	$.ajax({
		url: 'users/signup',
		datatype: 'json',
		type: "POST",
		async: false,
		headers: {'Authorization': 'Basic YnJvd3Nlcjo='},
		// headers: {'Authorization': 'Basic ' + btoa("browser:")},
		contentType: "application/json",
		data: JSON.stringify({
			username: username,
			password: password
		}),
		success: function (data) {
			log("OK: " + data.name);
		},
		error: function (xhr, ajaxOptions, thrownError) {
			log("ERROR: " + xhr.responseText);
		}
	});
}

function dropUser() {
	var token = localStorage.getItem('token');

	if (token) {
		$.ajax({
			url: 'users/current',
			datatype: 'json',
			type: 'DELETE',
			headers: {'Authorization': 'Bearer ' + token},
			async: false,
			success: function () {
				log("OK: user dropped");
				logout();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				log("ERROR: " + xhr.responseText);
			}
		});
	} else {
		log("WARN: not logged in");
	}
}

function login() {
	var username = document.getElementById('user_login').value;
	var password = document.getElementById('user_password').value;

	$.ajax({
		url: 'users/oauth/token',
		datatype: 'json',
		type: 'POST',
		async: false,
		headers: {'Authorization': 'Basic YnJvd3Nlcjo='},
		// headers: {'Authorization': 'Basic ' + btoa("browser:")},
		data: {
			scope: 'ui',
			username: username,
			password: password,
			grant_type: 'password'
		},
		success: function (data) {
			log("OK: " + data.access_token);
			localStorage.setItem('token', data.access_token);
			getCurrentAccount();
		},
		error: function (xhr, ajaxOptions, thrownError) {
			log("ERROR: " + xhr.responseText);
		}
	});
}

function getCurrentAccount() {
	var token = localStorage.getItem('token');

	if (token) {
		$.ajax({
			url: 'users/current',
			datatype: 'json',
			type: 'GET',
			headers: {'Authorization': 'Bearer ' + token},
			async: false,
			success: function (data) {
				log("OK: logged in");
				$("#user").html(data.name);
			},
			error: function (xhr, ajaxOptions, thrownError) {
				log("ERROR: " + xhr.responseText);
			}
		});
	} else {
		log("WARN: not logged in");
	}
}

function logout() {
	removeOauthTokenFromStorage();
	$("#user").html("<i>Not logged in</i>");
	log("OK: logged out");
}

function removeOauthTokenFromStorage() {
	localStorage.removeItem('token');
}

function log(message) {
	var id = Math.floor(Math.random() * 10000).toString();

	var style;
	if (message.startsWith('OK')) {
		style = "alert-success";
	} else if (message.startsWith('WARN')) {
		style = "alert-warning";
	} else if (message.startsWith('ERROR')) {
		style = "alert-danger";
	} else {
		style = "alert-info";
	}

	$("#messages").prepend("<div class=\"alert " + style + " alert-dismissable fade in\" id=\"" + id + "\">" +
		"<a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">&times;</a>" +
		message +
		"</div>");

	setTimeout(function () {
		$("#" + id).alert("close")
	}, 30000);
}
