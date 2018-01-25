/**Copyright (C) 1989, 1991 Free Software Foundation, Inc.
 *51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 *
 *Everyone is permitted to copy and distribute verbatim copies
 *of this license document, but changing it is not allowed.
 *
 *Charity Needs Organizer webservice and application for keeping track of
 *donation needs for a charitable organization.
 *
 *Copyright (C) 2017 Interfaith Sanctuary authored by Alex Hutchins, Wes Gruenberg, Zachary Priest,
 *Kevin Kirchoff , Tanner Brodt, Mary-Catherine Scott, Jordin Rausch,
 *Megan Arnett, Patrick Chapman, Justin Argyle
 *
 *This file is part of Charity Needs Organizer
 *
 *This program is free software; you can redistribute it and/or
 *modify it under the terms of the GNU General Public License
 *as published by the Free Software Foundation; either version 2
 *of the License, or (at your option) any later version.
 *
 *This program is distributed in the hope that it will be useful,
 *but WITHOUT ANY WARRANTY; without even the implied warranty of
 *MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *GNU General Public License for more details.
 *
 *You should have received a copy of the GNU General Public License
 *along with this program; if not, write to the Free Software
 *Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

import { Component, ViewChild } from '@angular/core';
import { Nav, Platform } from 'ionic-angular';
import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
import { CurrentNeeds } from '../pages/current-needs/current-needs';
import { LoginPage } from "../pages/login/login";
import { Callouts } from "../pages/callouts/callouts";
import { SettingsPage } from "../pages/settings/settings";
import { CashDonationsPage} from "../pages/cash-donations/cash-donations";
import { RegisterPage} from "../pages/register/register";


@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  @ViewChild(Nav) nav: Nav;

  rootPage: any = HomePage;

  pages: Array<{title: string, component: any}>;

  constructor(public platform: Platform, public statusBar: StatusBar, public splashScreen: SplashScreen) {
    this.initializeApp();

    // used for an example of ngFor and navigation
    this.pages = [
      { title: 'Home', component: HomePage },
      { title: 'Callouts', component: Callouts },
      { title: 'Login', component: LoginPage},
      { title: 'Settings', component: SettingsPage},
      { title: 'Cash Donations', component: CashDonationsPage}
    ];

  }

  initializeApp() {
    this.platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });
  }

  openPage(page) {
    // Reset the content nav to have just this page
    // we wouldn't want the back button to show in this scenario
    this.nav.setRoot(page.component);
  }
}
