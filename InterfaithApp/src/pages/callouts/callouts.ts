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

import { Component } from '@angular/core';
import { CalloutModel } from '../../app/models/callout-model.ts';
import { Http, Response } from '@angular/http';
import { NavController, NavParams } from 'ionic-angular';
import { DetailPage } from '../detail/detail'
import { CurrentNeeds} from '../current-needs/current-needs';


@Component({
  selector: 'page-callouts',
  templateUrl: 'callouts.html'
})

export class Callouts {

 // items: Array<{title: string, active: boolean, list: {}}>;
  //items: Array<{title: string}>;
  callOuts: Array<{CalloutModel}>;
  selectedItem: any;
  // items: Array<{title: string, note: string}>;


  constructor(public navCtrl: NavController, public http:Http, public navParams: NavParams) {

  // var link = "http://charityserver-env.us-west-2.elasticbeanstalk.com/ws/callouts/list";
   // var link = "https://api.myjson.com/bins/1hcm6n";
   var link = " https://api.myjson.com/bins/bxzlv";
    this.callOuts = [];
    //this.items = [];
    var p = this.http.get(link).forEach(response=> {
      let json = response.json();
      for(let result of json) {
        var modeler = new CalloutModel(result.callout_title, false, true, result.callout_body, result.create_date,
          result.callout_url, result.update_date, result.callout_id);

       // this.items.push({title:result.callout_title});
        console.log(result.callout_title);

        //modeler.setTitle(result.callout_title);
        this.callOuts.push(modeler);
      }
    });





   // this.selectedItem = navParams.get('item');
    // var p = this.http.get('assets/json/callouts.json').forEach(response=> {
    //   let json = response.json();
    //   this.items = [];
    //   for(let result of json) {
    //     this.items.push({title: result.callout, active: result.active, list: result.list});
    //
    //     //this.items.concat({title: result.list}); // TODO: put a nested list into items
    //     //console.log(result.list);
    //   }
    // });
   }

  itemTapped(event, callout) {
    //push to a current needs page
    this.navCtrl.push(CurrentNeeds, {
      CallOuts: callout
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad Callouts');
  }



}
