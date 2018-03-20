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

  constructor(
    public navCtrl: NavController,
    private calloutService: CalloutService
  ) {}

  pushAccountPage() {
    this.navCtrl.push(AccountPage);
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
