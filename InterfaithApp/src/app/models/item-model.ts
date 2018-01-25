export class ItemModel{

itemName: String;
itemUrl: String;
itemTotalNeeded: number;
itemDescription: String;
itemTotalReceived:number;
//url:String;

  constructor (public name: String, public url:String, public totalNeeded:number, public description:String,
               public totalReceived:number){
    this.itemName = name;
    this.itemUrl = url;
    this.itemTotalNeeded = totalNeeded;
    this.itemDescription = description;
    this.itemTotalReceived = totalReceived;
  }

  getDescription(){
    return this.itemDescription;
  }



  setUrl(url) {
    this.url = url;
  }
}
