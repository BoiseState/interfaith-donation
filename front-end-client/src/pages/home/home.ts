import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { AccountPage } from "../account/account";
import { CalloutService } from "../../services/calloutService"; // REMOVE THIS!

@Component({
  selector: "page-home",
  templateUrl: "home.html"
})
export class HomePage {
  constructor(
    public navCtrl: NavController,
    public calloutService: CalloutService
  ) {}

  pushAccountPage() {
    this.navCtrl.push(AccountPage);
    console.log(this.calloutService.getCalloutNeedsMockJSONHttp()); // REMOVE THIS!
  }
}
