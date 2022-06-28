import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from './account/account';

@Injectable({
  providedIn: 'root'
})

export class AccountService 
{

  BASEURL="http://localhost:8080/account/";

  constructor(private myHttp: HttpClient) 
  { 

  }

  loadAccountObjectFromSpring(accountId: number) : Observable<Account>
  {
    return this.myHttp.get<Account>(this.BASEURL+"getAccount/"+accountId);
  }
  
 
  
}