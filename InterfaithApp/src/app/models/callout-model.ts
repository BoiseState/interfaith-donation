export class CalloutModel{
  calloutTitle: String;




  constructor(public title:String, public pinned:boolean, public active:boolean, public calloutBody:String,
              public dateCreated:String, public url:String, public dateUpdated:String, public ID:Number){
    this.calloutTitle = title;

  }
  setTitle(title:String) {
    this.calloutTitle = title;
  }

  parseJsonCustom(fileName){
    var jsonData = JSON.parse(fileName);


  }
}
