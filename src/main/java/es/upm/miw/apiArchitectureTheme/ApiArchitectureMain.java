package es.upm.miw.apiArchitectureTheme;

import es.upm.miw.apiArchitectureTheme.daos.DaoFactory;
import es.upm.miw.apiArchitectureTheme.daos.memory.DaoFactoryMemory;
import es.upm.miw.web.http.HttpMethod;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;

public class ApiArchitectureMain {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();

	public void help() {
		System.out.println("##############AYUDA######################");
		System.out.println("POST **/users   body=nick:email");
		System.out.println("POST **/sports   body=name");
		System.out.println("PUT **/users/{nick}/sport   body:sportName");
		System.out.println("GET **/users");
		System.out.println("GET **/users/search?sport=*");
		System.out.println("#########################################");
	}

	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.request();
		request.setBody("dos:dos@gmail.com");
		this.request();
		request.setBody("uno:tres@gmail.com");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("users");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.request();
		request.setBody("tenis");
		this.request();
		request.setBody("ajedrez");
		this.request();
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("tenis");
		this.request();
		request.setPath("users/uno/sport");
		request.setBody("");
		request.clearQueryParams();
		this.request();
		request.setPath("users/dos/sport");
		request.setBody("tenis");
		this.request();
		request.setPath("users/dos/sport");
		request.setBody("ajedrez");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search?sport=tenis");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("");
		request.clearQueryParams();
		request.setBody("");
		this.request();
	}

	public void request() {
		System.out.println(request.toString());
		HttpResponse response = server.request(request);
		System.out.println(response);
		System.out.println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
		ApiArchitectureMain main = new ApiArchitectureMain();
		DaoFactory.setFactory(new DaoFactoryMemory());
		main.help();
		main.demo();
	}
}
