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

import {Component} from '@angular/core';
import {NavController, IonicPage} from 'ionic-angular';
import {CurrentNeeds} from '../current-needs/current-needs';
import {AuthService, User} from '../../providers/auth-service/auth-service';
import {Callouts} from "../callouts/callouts";
import {LoginPage} from "../login/login";

@IonicPage()
@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {
  username = '';
  email = '';

  constructor(private nav: NavController, private auth: AuthService) {
    let info = this.auth.getUserInfo();
    this.username = info['name'];
    this.email = info['email'];

  }

  openPageCallouts() {
    this.nav.push(Callouts);
  }
  openPageRegisterSignIn() {
    this.nav.push(LoginPage);
  }

  public isLoggedIn() {
    return (this.email !== 'Undefined' && this.username !== 'Undefined' && this.email !== '' && this.username !== '')
  }

  public logout() {
    this.auth.logout().subscribe(success => {
      //this.nav.setRoot('LoginPage')
      this.username = 'Guest';
      this.email = 'Guest';
    });
  }
}
