import { Component, Input } from '@angular/core';

/**
 * Generated class for the CalloutComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'callout',
  templateUrl: 'callout.html'
})
export class CalloutComponent {
  
  @Input("title") title: string;
  @Input("src") src: string;
  @Input("leftLink") leftLink: string;
  @Input("rightLink") rightLink: string;
  @Input("text") text: string;
  @Input("count") count: number;
  @Input("outOf") outOf: number;

  constructor() {}

}
