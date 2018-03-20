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

  getCalloutNeedsMockJSONHttp() {
    console.log("getting callout?");
    //let jsonObj;
    //this.http.get('assets/mockData/mockCalloutNeeds.json').map(res => res.json()).subscribe(data => { jsonObj = data;});
    //console.log(this.http.get('assets/mockData/mockCalloutNeeds.json'));

    //console.log(this.http.get('assets/mockData/mockCalloutNeeds.json').map(data => data.json()));

    console.log("response:");

    this.http.get("assets/mockData/mockCalloutNeeds.json").subscribe(data => {
      console.log(JSON.stringify(data));
    });

    //return jsonObj;
  }
}
