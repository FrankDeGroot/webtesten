document.title = 'Registreer cursist';
document.querySelector('h1').textContent = 'Cursist registratie...';
document.querySelector('.label-important').style.display = 'none';
document.getElementById('activatieformulier').style.display = 'none';

document
		.getElementById('registratieformulier')
		.addEventListener(
				'submit',
				function(event) {
					event.preventDefault();
					var request = new XMLHttpRequest();
					var form = document.getElementById('registratieformulier');
					var registratieGebruikersnaam = form
							.querySelector('[name=registratieGebruikersnaam]').value;
					var registratieEmail = form
							.querySelector('[name=registratieEmail]').value;
					console.log('Registratie gebruiker',
							registratieGebruikersnaam, 'email',
							registratieEmail);
					request.onreadystatechange = function() {
						if (request.readyState === XMLHttpRequest.DONE
								&& request.status === 200) {
							var response = request.responseText;
							console.log('Registratie response', response);
							var html = document.createElement('html');
							html.innerHTML = response;
							console.log('HTML', html);
							var foutmelding = html
									.querySelector('.label-important');
							console.log('foutmelding', foutmelding);
							if (foutmelding) {
								console.log(foutmelding.textContent);
								document.querySelector('.label-important').textContent = foutmelding.textContent;
								document.querySelector('.label-important').style.display = '';
							} else {
								document.querySelector('.label-important').style.display = 'none';
								document.getElementById('registratieformulier').style.display = 'none';
								document.getElementById('activatieformulier').style.display = '';
								document.title = 'Activeer cursist';
								document.querySelector('h1').textContent = 'Cursist activatie...';
							}
						}
					};
					request.open('POST', '/registreer', true);
					request.setRequestHeader('Content-Type',
							'application/x-www-form-urlencoded; charset=UTF-8');
					request.send("registratieGebruikersnaam="
							+ encodeURIComponent(registratieGebruikersnaam)
							+ '&' + "registratieEmail="
							+ encodeURIComponent(registratieEmail));
				});

document
		.getElementById('activatieformulier')
		.addEventListener(
				'submit',
				function(event) {
					event.preventDefault();
					var request = new XMLHttpRequest();
					var form = document.getElementById('activatieformulier');
					var activatieGebruikersnaam = form
							.querySelector('[name=activatieGebruikersnaam]').value;
					var activatiecode = form
							.querySelector('[name=activatiecode]').value;
					console.log('Activatie gebruiker', activatieGebruikersnaam,
							'email', activatiecode);
					request.onreadystatechange = function() {
						if (request.readyState === XMLHttpRequest.DONE
								&& request.status === 200) {
							var response = request.responseText;
							console.log(response);
							var html = document.createElement('html');
							html.innerHTML = response;
							var foutmelding = html
									.querySelector('.label-important');
							if (foutmelding) {
								document.querySelector('.label-important').textContent = foutmelding.textContent;
								document.querySelector('.label-important').style.display = '';
							} else {
								document.querySelector('.label-important').style.display = 'none';
								document.getElementById('activatieformulier').style.display = 'none';
								document.title = 'Account page';
								document.querySelector('h1').textContent = html
										.querySelector('h1').textContent;
							}
						}
					};
					request.open('POST', '/activeer', true);
					request.setRequestHeader('Content-Type',
							'application/x-www-form-urlencoded; charset=UTF-8');
					request.send("activatieGebruikersnaam="
							+ encodeURIComponent(activatieGebruikersnaam) + '&'
							+ "activatiecode="
							+ encodeURIComponent(activatiecode));
				});
