import { Injectable } from "@angular/core";
import { Http } from "@angular/http";
import { HttpModule } from "@angular/http";
import { File } from "@ionic-native/file";

import "rxjs/add/operator/map";

@Injectable()
export class CalloutService {
  constructor(
    private http: Http,
    private httpModule: HttpModule,
    private file: File
  ) {}

  getCalloutNeedsJSON() {
    let jsonObj;

    this.http
      .get("donation-api/calloutneeds")
      .map(res => res.json())
      .subscribe(data => {
        jsonObj = data;
      });

    return jsonObj;
  }

  // This is temporary until the donation-api call works and is reliable.
  getCalloutNeedsMockJSON() {
    let jsonObj;

    console.log(
      this.file.readAsText(
        "../../www/assets/mockData/mockCalloutNeeds",
        "data.json"
      )
    );

    //return jsonObj;
  }

  async getCalloutNeedsMockJSONHttp() {
    let jsonObj;
    //this.http.get('assets/mockData/mockCalloutNeeds.json').map(res => res.json()).subscribe(data => { jsonObj = data;});
    //console.log(this.http.get('assets/mockData/mockCalloutNeeds.json'));

    //console.log(this.http.get('assets/mockData/mockCalloutNeeds.json').map(data => data.json()));

    /* // WORKS!!!!
    let promise = new Promise((resolve, reject) => {
      let apiURL = 'assets/mockData/mockCalloutNeeds.json';
      this.http.get(apiURL)
        .toPromise()
        .then(
          res => {
            //res.json() // Contains the correct json object
            console.log("json response:");
            console.log(res.json());
            //jsonObj = JSON.parse(JSON.stringify(res.json()));
            resolve();
          }
        )
    });
*/

    console.log("response:");
    jsonObj = await this.doRequest();

    /* // works, gets the correct response but has issues with accessing body
    this.http.get("assets/mockData/mockCalloutNeeds.json").subscribe(data => {
      console.log(JSON.stringify(data));
    });
    */

    console.log("jsonObj:");
    console.log(jsonObj);
    return jsonObj;
  }

  private doRequest() {
    return new Promise((resolve, reject) => {
      let apiURL = "assets/mockData/mockCalloutNeeds.json";
      this.http
        .get(apiURL)
        .toPromise()
        .then(res => {
          res.json(); // Contains the correct json object
          //jsonObj = JSON.parse(JSON.stringify(res.json()));
          resolve(res.json());
        });
    });
  }
}
