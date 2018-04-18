import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { AccountPage } from "../account/account";
import { CalloutService } from "../../services/calloutService";

@Component({
  selector: "page-home",
  templateUrl: "home.html"
})
export class HomePage {
  private calloutNeeds: any[];
  private callouts: any[];
  private needs: NeedObj[];

  constructor(
    public navCtrl: NavController,
    private calloutService: CalloutService
  ) {
    this.callouts = [];
    this.needs = [];
    this.receiveCallouts(); // Requests for a JSON object of calloutNeeds on startup
  }

  pushAccountPage() {
    this.navCtrl.push(AccountPage);
  }

  async receiveCallouts() {
    await this.calloutService
      .getCalloutNeedsMockJSON() // TODO: Change this to getCalloutNeedsJSON() once donation-api endpoint requests work. Task #274.
      .then(res => (this.calloutNeeds = res));
    console.log("callouts:");
    console.log(this.calloutNeeds);
    for (let callout in this.calloutNeeds["content"]) {
      // Iterates through all the callouts
      if (this.calloutNeeds["content"][callout]["active"]) {
        // If the callout is currently active

        this.callouts.push(this.calloutNeeds["content"][callout]["id"]);

        const need = new NeedObj(
          this.calloutNeeds["content"][callout]["need"]["description"],
          this.calloutNeeds["content"][callout]["need"]["id"],
          this.calloutNeeds["content"][callout]["need"]["name"],
          this.calloutNeeds["content"][callout]["need"]["unitOfMeasurement"],
          this.calloutNeeds["content"][callout]["need"]["url"],
          this.calloutNeeds["content"][callout]["quantity"]
        );

        this.needs.push(need);
      }
    }
  }

  toggleOrdering() {
    this.needs.reverse();
  }
}

class NeedObj {
  description: any;
  id: any;
  name: any;
  unitOfMeasurement: any;
  url: any;
  quantity: any;

  constructor(
    description: any,
    id: any,
    name: any,
    unitOfMeasurement: any,
    url: any,
    quantity: any
  ) {
    this.description = description;
    this.id = id;
    this.name = name;
    this.unitOfMeasurement = unitOfMeasurement;
    this.url = url;
    this.quantity = quantity;
  }
}
