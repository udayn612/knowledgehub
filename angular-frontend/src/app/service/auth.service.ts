import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { userInfo } from '../domain/login-info';
import { Observable } from 'rxjs';
import { JwtResponse } from '../domain/jwt-response';
import { AuthInterceptor } from './auth-interceptor';
import { TokenService } from './token.service';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

//  const token = this.token.getToken();
//  const key={
//   headers: new HttpHeaders({'Authorization': 'Bearer '+token})
// };
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private url = 'http://localhost:8092/login-service/api/auth/signin';
  private url2 = 'http://localhost:8092/login-service/api/test/user';

  constructor( private http:HttpClient,private token: TokenService) {}
  //This method is to post login credentials to backend and get response.
  auth(credentials:userInfo):Observable<JwtResponse>{
    return this.http.post<JwtResponse>(this.url,credentials,httpOptions)
  }

  // interceptor():Observable<string>{
  //   return this.http.get<string>(this.url2,key)
  // }


}
