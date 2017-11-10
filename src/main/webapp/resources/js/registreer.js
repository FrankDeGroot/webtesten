var h1 = document.querySelector('h1');
var errorLabel = document.querySelector('.label-important');
var activatieformulier = document.getElementById('activatieformulier');
var registratieformulier = document.getElementById('registratieformulier');

function hide(element) {
	element.style.display = 'none';
}

function show(element) {
	element.style.display = '';
}

function onSubmit(element, handler) {
	element.addEventListener('submit', function(event) {
		event.preventDefault();
		handler(event.target);
	});
}

function post(url, body, handler) {
	var request = new XMLHttpRequest();
	request.onreadystatechange = function() {
		if (request.readyState === XMLHttpRequest.DONE
				&& request.status === 200) {
			handler(parseHtml(request.responseText));
		}
	};
	request.open('POST', url, true);
	request.setRequestHeader('Content-Type',
			'application/x-www-form-urlencoded; charset=UTF-8');
	console.log('Sending', body);
	request.send(body);
}

function parseHtml(response) {
	var html = document.createElement('html');
	html.innerHTML = response;
	return html;
}

function proceed(responseHtml, nextScreen) {
	var foutmelding = responseHtml.querySelector('.label-important');
	if (foutmelding) {
		console.log(foutmelding.textContent);
		errorLabel.textContent = foutmelding.textContent;
		show(errorLabel);
	} else {
		hide(errorLabel);
		nextScreen(responseHtml);
	}
}

document.title = 'Registreer cursist';
h1.textContent = 'Cursist registratie...';
hide(errorLabel);
hide(activatieformulier);

onSubmit(registratieformulier, function(form) {
	var registratieGebruikersnaam = form
			.querySelector('[name=registratieGebruikersnaam]').value;
	var registratieEmail = form.querySelector('[name=registratieEmail]').value;
	var body = "registratieGebruikersnaam="
			+ encodeURIComponent(registratieGebruikersnaam) + '&'
			+ "registratieEmail=" + encodeURIComponent(registratieEmail);
	post('/registreer', body, function(responseHtml) {
		proceed(responseHtml, function(responseHtml) {
			window.location.hash = 'activeer';
			hide(registratieformulier);
			show(activatieformulier);
			document.title = 'Activeer cursist';
			h1.textContent = 'Cursist activatie...';
		});
	});
});

onSubmit(activatieformulier, function(form) {
	var activatieGebruikersnaam = form
			.querySelector('[name=activatieGebruikersnaam]').value;
	var activatiecode = form.querySelector('[name=activatiecode]').value;
	var body = "activatieGebruikersnaam="
			+ encodeURIComponent(activatieGebruikersnaam) + '&'
			+ "activatiecode=" + encodeURIComponent(activatiecode);
	post('/activeer', body, function(responseHtml) {
		proceed(responseHtml, function(responseHtml) {
			window.location.hash = 'account';
			hide(activatieformulier);
			document.title = 'Account page';
			h1.textContent = responseHtml.querySelector('h1').textContent;
		});
	});
});
