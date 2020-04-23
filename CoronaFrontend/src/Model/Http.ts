
export class Http
{
    private host : string;

    public async getJson(url : string) : Promise<any>
    {
        let response = await fetch(this.host + url);
        let jsonFile = await response.json();
        console.log(jsonFile);
        return jsonFile;
    }

    public async getCountry(url : string, country: string)
    {
        let response = await fetch(this.host = url);
        let jsonFile = await response.json();
        if(jsonFile.countriesAndTerritories == country)
        {
            return jsonFile;
        }
        return null;
        
    }
}
