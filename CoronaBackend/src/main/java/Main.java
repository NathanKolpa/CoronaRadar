import infrastructure.rivm.RivmWorldDataSource;
import org.springframework.boot.SpringApplication;
import webapi.WebApi;

public class Main
{
	public static void main(String[] args) throws Exception
	{
		SpringApplication.run(WebApi.class, args);
	}
}