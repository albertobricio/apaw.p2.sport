package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.api.SportResource;
import es.upm.miw.apiArchitectureTheme.api.UserResource;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureTheme.exceptions.InvalidThemeFieldException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {
	
	private SportResource sportResource = new SportResource();
	private UserResource userResource = new UserResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		// **/users
		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());
			// **/users/search?sport=*
		} else if ("themes".equals(request.paths()[0]) && request.paths()[1].startsWith("search?sport=")) {
			try {
				String sportName = request.paths()[1].split("=")[1];
				response.setBody(userResource.userListBySport(sportName).toString());
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		// POST **/sports body="Name"
		case "sports":
			// Injectar parámetros...
			try {
				sportResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidSportFieldException e) {
				this.responseError(response, e);
			}
			break;
		// POST users body="nick:email"
		case "users":
			String nick = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			try {
				userResource.createUser(nick,email);
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		//PUT /users/{nick}/sport body=sportName
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			try {
				String nick = request.paths()[1];
				String sportName = request.getBody();
				userResource.putSportToUser(nick, sportName);
			} catch (Exception e) {
				responseError(response, e);
			}
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
