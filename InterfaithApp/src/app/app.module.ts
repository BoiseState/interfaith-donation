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

import { BrowserModule } from '@angular/platform-browser';
import { HttpModule } from '@angular/http';
import { InAppBrowser } from '@ionic-native/in-app-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';

import {MyApp} from './app.component';
import {HomePage} from '../pages/home/home';
import {DetailPage} from '../pages/detail/detail';
import {CurrentNeeds} from '../pages/current-needs/current-needs';
import {LoginPage} from "../pages/login/login";
import {RegisterPage} from "../pages/register/register";
import {Callouts} from '../pages/callouts/callouts';
import {SettingsPage} from "../pages/settings/settings";
import {CashDonationsPage} from "../pages/cash-donations/cash-donations";

import {StatusBar} from '@ionic-native/status-bar';
import {SplashScreen} from '@ionic-native/splash-screen';
import {SocialSharing} from '@ionic-native/social-sharing';
import {AuthService} from '../providers/auth-service/auth-service';
import {HomePageModule} from "../pages/home/home.module";
import {RegisterPageModule} from "../pages/register/register.module";

@NgModule({
  declarations: [
    MyApp,
    DetailPage,
    CurrentNeeds,
    LoginPage,
    Callouts,
    SettingsPage,
    CashDonationsPage
  ],
  imports: [
    BrowserModule,
    HttpModule,
    IonicModule.forRoot(MyApp),
    HomePageModule,
    RegisterPageModule
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    HomePage,
    DetailPage,
    CurrentNeeds,
    LoginPage,
    RegisterPage,
    Callouts,
    SettingsPage,
    CashDonationsPage
  ],
  providers: [
    SocialSharing,
    StatusBar,
    SplashScreen,
    InAppBrowser,
    {provide: ErrorHandler, useClass: IonicErrorHandler},
    AuthService
  ]
})
export class AppModule {
}
