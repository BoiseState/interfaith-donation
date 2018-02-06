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
  @Input("text") text: string;

  constructor() {}

}
