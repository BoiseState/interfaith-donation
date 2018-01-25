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
import { NavController, NavParams } from 'ionic-angular';
import { DetailPage } from '../detail/detail'
import { Http, Response } from '@angular/http';
import { ItemModel } from '../../app/models/item-model.ts';

/**
 * Generated class for the CurrentNeeds page.
 *
 * See http://ionicframework.com/docs/components/#navigation for more info
 * on Ionic pages and navigation.
 */

@Component({
  selector: 'page-current-needs',
  templateUrl: 'current-needs.html',
})

export class CurrentNeeds {
  selectedItem: any;
  //items: Array<{title: string, needed: number, rec: number, done: boolean, url: string}>;
  //items: Array<{title: string}>;
  items: Array<{ItemModel}>;
  models: Array<{ItemModel}>;
  constructor(public navCtrl: NavController, public navParams: NavParams, public http:Http,) {
    // If we navigated to this page, we will have an item available as a nav param
    var link = "https://api.myjson.com/bins/u62fn";

    this.selectedItem = navParams.get('CallOuts');
    this.items = [];
    this.models = [];
    var p = this.http.get(link).forEach(response => {
      let json = response.json();
      for (let result of json) {
       var num = Math.floor(Math.random() * 6) + 1
        var itemModel = new ItemModel(result.need_name, result.need_url, result.need_quantity, result.need_description,
        num);

        // this.items.push({title:result.callout_title});
        // console.log(result.need_description);
        //modeler.setTitle(result.callout_title);
        // this.items.push(itemModel);
        if (result.need_description == this.selectedItem.title) {
          console.log("hooray")
          this.items.push(itemModel);
        }
        this.models.push(itemModel);
        // console.log(itemModel.itemName);
      }
      console.log(this.models.length);
      console.log(this.selectedItem.title);

      console.log("model1");
      this.models.forEach(function (model) {


      });
      for (let model in this.models) {

        //console.log(model.);
        //console.log(callout.title)
        // console.log(model.ItemModel.itemName);

        // if(model.ItemModel.itemName == callout.title){
        //   console.log("hooray");
        //   this.items.push(model);
        // }
      }
    });
  }



  itemTapped(event, item) {
    // That's right, we're pushing to ourselves!
    this.navCtrl.push(DetailPage, {
      item: item
    });
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad CurrentNeeds');
  }

}
