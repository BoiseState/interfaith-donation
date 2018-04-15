import { Injectable } from "@angular/core";
import { Http } from "@angular/http";

@Injectable()
export class CalloutService {
  constructor(private http: Http) {}

  /**
   * Gets the calloutNeeds JSON from the donation-api endpoint.
   */
  async getCalloutNeedsJSON() {
    // TODO: Request the donation-api for calloutneeds. Currently does not work, is it a proxy issue?
    let jsonObj;
    await this.doRequest("donation-api/calloutneeds").then(
      data => (jsonObj = data)
    );
    return jsonObj;
  }

  /**
   * Gets the calloutNeeds JSON as local mock data.
   */
  async getCalloutNeedsMockJSON() {
    let jsonObj;
    await this.doRequest("assets/mockData/mockCalloutNeeds.json").then(
      data => (jsonObj = data)
    );
    return jsonObj;
  }

  async getAllCalloutsJSON() {
    let jsonObj;
    await this.doRequest("donation-api/callouts/all").then(
      data => (jsonObj = data)
    );
    return jsonObj;
  }

  /**
   * Performs the request of getting JSON data from an restful API endpoint.
   * @param apiUrl The api url endpoint the request from.
   */
  private doRequest(apiUrl: string) {
    return new Promise((resolve, reject) => {
      //let apiURL = "assets/mockData/mockCalloutNeeds.json";
      this.http
        .get(apiUrl)
        .toPromise()
        .then(res => {
          res.json(); // Contains the correct json object
          resolve(res.json());
        });
    });
  }
}
