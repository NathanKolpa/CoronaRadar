
import {HttpClient, HttpResponseMessage} from 'aurelia-http-client';

export class Http
{
    public constructor(private httpClient : HttpClient = new HttpClient())
    {

    }

    public async httpGet() : Promise<HttpResponseMessage>
    {
        return this.httpClient.get("https://google.com");
    }
  
    public getJson() : void
    {
        this.httpClient.get("JSONFILE").then(data => {console.log(data)})
    }
}