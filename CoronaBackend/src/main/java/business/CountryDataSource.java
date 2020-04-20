package business;

import business.model.World;
import com.sun.istack.internal.NotNull;


public interface CountryDataSource
{
	@NotNull
	World getCountries() throws Exception;
}
