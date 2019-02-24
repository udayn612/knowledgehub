import { Component, OnInit, ViewChild } from '@angular/core';
import { TokenService } from '../service/token.service';
import { Router } from '@angular/router';
import { userInfo } from '../domain/login-info';
import { AuthInterceptor } from '../service/auth-interceptor';
import { AuthService } from '../service/auth.service';
import { MatSidenav } from '@angular/material/sidenav';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  Islogged:string;
  user:any;
  info:any;
  add:boolean;

  constructor(public token:TokenService,private router:Router,private auth:AuthService) { }

  //This method checks for token on when you load the component.
  ngOnInit() {
    // window.sessionStorage.clear();
    if(this.token.getToken()){
       this.user=this.token.getUser();
       this.Islogged = "Log Out";
    }
    else{
      this.Islogged="Login"
    }
  }



  // This method is to signout or
  //  naviagte to login component based on whether admin logged in or not.
  logging() {
    if(this.token.getToken()){
       this.token.signout();
       window.location.reload();
    }
    else{
      this.router.navigate(['/login'])
    }
  }
  reloadPage(){
    window.location.reload();
  }

  // This method is used to navigate to home component. 
  navigate(){
    this.router.navigate(['/home']);
  }

  addfiles(){
    this.add = true;
  }
}



