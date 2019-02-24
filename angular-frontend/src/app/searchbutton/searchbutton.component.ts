import { Component, Injector, Inject, PLATFORM_ID, ViewChild } from '@angular/core';
import { isPlatformServer } from '@angular/common';
// @angular/platform-browser Supports delivery of Angular apps on different supported browsers.
//TransferState is a class- A key value store that is transferred from the application on the server side to the application on the client side.
//makeStateKey is a function that create a StateKey<T> that can be used to store value of type T with TransferState.
import { TransferState, makeStateKey } from '@angular/platform-browser';
import { Route } from '@angular/compiler/src/core';
import { Router } from '@angular/router';
const configKey = makeStateKey('CONFIG');
declare var webkitSpeechRecognition: any;

@Component({
  selector: 'app-searchbutton',
  templateUrl: './searchbutton.component.html',
  styleUrls: ['./searchbutton.component.css']
})
export class SearchbuttonComponent{

  public title : string;
  // viewChild- Property decorator that configures a view query
  // The change detector looks for the first element or the directive matching
  // the selector in the view DOM. If the view DOM changes, and a new child 
  // matches the selector, the property is updated.
  @ViewChild('gSearch') formSearch;
  @ViewChild('searchKey') hiddenSearchHandler;
  constructor(
    private injector: Injector,
    private state : TransferState,
    @Inject(PLATFORM_ID) private platformid: Object,private route:Router
  ){
    this.title = 'Voice Search POC';
    //isPlatformServer -Returns whether a platform id represents a server platform.
    if(isPlatformServer(this.platformid)){
      //this.injector.get - Retrieves an instance from the injector based on the provided token.
      //injector get - abstract get<T>(token: Type<T> | InjectionToken<T>, notFoundValue?: T, flags?: InjectFlags): T
      const envJson = this.injector.get('CONFIG')? this.injector.get('CONFIG'): {};
      //state of TransferState set method- set<T>(key: StateKey<T>, value: T): void
      this.state.set(configKey, envJson as any);
  }
}


public voiceSearch(){
  //we create the webkitSpeechRecognition object which provides the speech interface,
  // and set some of its attributes and event handlers.
  if('webkitSpeechRecognition' in window){
      const vSearch = new webkitSpeechRecognition();
      vSearch.continuous = false;
      vSearch.interimresults = false;
      vSearch.lang = 'en-US';
      // activate the speech recognizer by .start()
      vSearch.start();
      const voiceSearchForm = this.formSearch.nativeElement;
      const voiceHandler = this.hiddenSearchHandler.nativeElement;
      vSearch.onresult = function(event){
        //storing the result in value
        //returns a string containing the transcript of the recognised word(s).
        voiceHandler.value = event.results[0][0].transcript;
          vSearch.stop();
          //submitting the form with the value
          // voiceSearchForm.submit();
      }
      //if error is encountered, show error in console and stop the speech recognition
      vSearch.onerror = function(event){
          console.log(event);
          vSearch.stop();
      }
  } 
  //if browser does not have webkitspeechrecognition
  else {
    console.log("Your browser does not support voice recognition feature.");
    }
}


google(){
  this.route.navigateByUrl("https://www.google.com/search")
}

}


