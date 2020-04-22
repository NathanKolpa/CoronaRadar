import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import webapi.WebApi;

@SpringBootApplication
public class Main
{
	public static void main(String[] args) {
		SpringApplication.run(WebApi.class, args);
	}
}