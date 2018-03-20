import { BrowserModule } from "@angular/platform-browser";
import { ErrorHandler, NgModule } from "@angular/core";
import { IonicApp, IonicErrorHandler, IonicModule } from "ionic-angular";
import { SplashScreen } from "@ionic-native/splash-screen";
import { StatusBar } from "@ionic-native/status-bar";
import { HttpModule } from "@angular/http";
import { File } from "@ionic-native/file";

import { MyApp } from "./app.component";
import { HomePage } from "../pages/home/home";
import { AccountPage } from "../pages/account/account";

import { CalloutService } from "../services/calloutService";

import { CalloutComponent } from "../components/callout/callout";

@NgModule({
  declarations: [MyApp, HomePage, AccountPage, CalloutComponent],
  imports: [BrowserModule, IonicModule.forRoot(MyApp), HttpModule],
  bootstrap: [IonicApp],
  entryComponents: [MyApp, HomePage, AccountPage],
  providers: [
    StatusBar,
    SplashScreen,
    CalloutService,
    File,
    { provide: ErrorHandler, useClass: IonicErrorHandler }
  ]
})
export class AppModule {}
