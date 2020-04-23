
export class Http
{
    public async getJson(url : string) : Promise<any>
    {
        let response = await fetch(url);
        let jsonFile = await response.json();
        console.log(jsonFile);
        return jsonFile;
    }

    public async getLand(url : string, country: string)
    {
        let response = await fetch(url);
        let jsonFile = await response.json();
        if(jsonFile.countriesAndTerritories == country)
        {
            console.log(jsonFile)
            return jsonFile;
        }
        return null;
        
    }
}
