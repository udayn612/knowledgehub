import { Component, OnInit } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { userInfo} from '../domain/login-info';
import { TokenService } from '../service/token.service';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user:userInfo;
  form:any={};
  isLogin:boolean;
  username=new FormControl('');
  password=new FormControl('');
  isLoginFailed:boolean=false;
  errorMessage:string;
  constructor(private auth:AuthService ,private token:TokenService,private router: Router) { }

   //This method checks for token on when you load the component.
  ngOnInit() {
    
    if(this.token.getToken()){
      this.isLogin=true;
    }
    else{
      this.isLogin=false;
    }
  }

  //This method is to post login credentials to backend and save response.
  validate(){
       this.user = {"username":this.username.value,"password":this.password.value}
      console.log(this.user.username);
    this.auth.auth(this.user).subscribe(data => 
      {this.token.saveToken(data.accessToken),
      this.token.saveUsername(data.username),
      console.log(data.accessToken),
      this.navigate() },
      
     
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isLoginFailed = true;
      })
  }

  reloadPage(){
    window.location.reload();
  }
    // This method is used to navigate to home component. 
  navigate(){
    this.router.navigate(['/home']);
  }


}
