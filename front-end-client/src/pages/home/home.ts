import { Component } from "@angular/core";
import { NavController } from "ionic-angular";
import { AccountPage } from "../account/account";

@Component({
  selector: "page-home",
  templateUrl: "home.html"
})
export class HomePage {
  order: boolean = true;

  constructor(public navCtrl: NavController) {}

  pushAccountPage() {
    this.navCtrl.push(AccountPage);
  }

  toggleOrdering() {
    console.log("changeOrder button has been clicked");
    this.order = !this.order;
  }
}
