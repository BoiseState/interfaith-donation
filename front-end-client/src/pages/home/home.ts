import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { AccountPage } from "../account/account";
import { CalloutService } from "../../services/calloutService";

@Component({
  selector: "page-home",
  templateUrl: "home.html"
})
export class HomePage {
  order: boolean = true;
  private callouts: any[];
  private needs: NeedObj[];

  constructor(
    public navCtrl: NavController,
    private calloutService: CalloutService
  ) {
    this.needs = [];
    this.receiveCallouts(); // Requests for a JSON object of calloutNeeds on startup
  }

  pushAccountPage() {
    this.navCtrl.push(AccountPage);
  }

  async receiveCallouts() {
    await this.calloutService
      .getCalloutNeedsJSON()
      .then(res => (this.callouts = res));
    console.log("callouts:");
    console.log(this.callouts);
    for (let callout in this.callouts["content"]) {
      // Iterates through all the callouts
      if (this.callouts["content"][callout]["active"]) {
        // If the callout is currently active
        const need = new NeedObj(
          this.callouts["content"][callout]["need"]["description"],
          this.callouts["content"][callout]["need"]["id"],
          this.callouts["content"][callout]["need"]["name"],
          this.callouts["content"][callout]["need"]["unitOfMeasurement"],
          this.callouts["content"][callout]["need"]["url"],
          this.callouts["content"][callout]["quantity"]
        );
        this.needs.push(need);
      }
    }
  }

  toggleOrdering() {
    console.log("changeOrder button has been clicked");
    this.order = !this.order;

    if (this.order) {
      // The most relavent card results should display at the top, descending order.
      // This is default behavior.
      // TODO: Provide the default order of cards. Note: they should be in this order
      // by default, but their order will have to be modified again if they have been
      // reversed at least once.
    } else {
      // TODO: Reverse order of cards, ascending order.
    }
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
