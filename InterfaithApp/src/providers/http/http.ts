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

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';

/*
  Generated class for the HttpProvider provider.

  See https://angular.io/docs/ts/latest/guide/dependency-injection.html
  for more info on providers and Angular DI.
*/
@Injectable()
export class HttpProvider {

  constructor(public http: Http) {
    console.log('Hello HttpProvider Provider');

  }

  getJsonData(url){
    if (url == null) {
      return this.http.get('https://api.myjson.com/bins/11zpmh').map(res => res.json());
    } else {
      return this.http.get(url).map(res => res.json());
    }
  }

}
