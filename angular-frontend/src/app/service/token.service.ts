import { Injectable } from '@angular/core';

const TOKEN_KEY = "KEY";
const USER_NAME = "NAME";
@Injectable({
  providedIn: 'root'
})
export class TokenService {

  
  constructor() { }

  //this method will remove all the tokens in session storage.
  signout(){
    window.sessionStorage.clear();
  }

//this method will save response token in session storage. 
  saveToken(token:any){
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem((TOKEN_KEY),token);
}

//this method will save the username present in token in session storage.
saveUsername(username:string){
  window.sessionStorage.removeItem(USER_NAME);
  window.sessionStorage.setItem((USER_NAME),username);
}

//this method is used to get token present in session storage.
  getToken(){
   return  window.sessionStorage.getItem("KEY");
  }

  //this method is used to get username present in session storage.
  getUser(){
   return window.sessionStorage.getItem(USER_NAME);
  }

}
