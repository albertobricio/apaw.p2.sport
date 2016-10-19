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
		System.out.println("GET **/themes");
		System.out.println("POST **/themes   body=\"themeName\"");
		System.out.println("GET **/themes/{id}/overage");
		System.out.println("POST **/votes   body=\"themeId:vote\"");
		System.out.println("GET **/votes");
		System.out.println("#########################################");
	}

	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("themes");
		request.setBody("uno");
		this.request();
		request.setBody("dos");
		this.request();
		request.setPath("votes");
		request.setBody("1:4");
		this.request();
		request.setBody("1:5");
		this.request();
		request.setBody("2:5");
		this.request();
		request.setBody("2:6");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("votes");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setPath("themes");
		this.request();
		request.setPath("themes/1/overage");
		this.request();
		request.setPath("themes/2/overage");
		this.request();
		//Exceptions
		request.setPath("noValid");
		this.request();
		request.setPath("themes/x/overage");
		this.request();
		request.setPath("themes/99/overage");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("votes");
		request.setBody("99:4");
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
