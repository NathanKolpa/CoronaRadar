
export class Http
{
    public async getJson(url : string) : Promise<any>
    {
        let response = await fetch(url);
        let jsonFile = await response.json();
        console.log(jsonFile);
        return jsonFile;
    }
}
