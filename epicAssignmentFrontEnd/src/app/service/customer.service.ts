import { Injectable } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  addCusURL : string;
  updateCusURL : string;
  getCusURL : string;
  deleteCusURL : string;

  constructor(private http : HttpClient) { 
    
    this.addCusURL = 'http://localhost:8080/epicAssignment_1_war/saveCustomer';
    this.getCusURL = 'http://localhost:8080/epicAssignment_1_war/getAllCustomers';
    this.updateCusURL = 'http://localhost:8080/epicAssignment_1_war/editCustomer';
    this.deleteCusURL = 'http://localhost:8080/epicAssignment_1_war/deleteCustomers?id=';

  }

  addCustomer(cus : Customer) : Observable<Customer> {
      return this.http.post<Customer>(this.addCusURL,cus);
  }

  getAllCustomers() : Observable<Customer[]>{
    return this.http.get<Customer[]>(this.getCusURL);
  }

  updateCustomer(cus : Customer) : Observable<Customer>{
    return this.http.put<Customer>(this.updateCusURL,cus);
  } 

  deleteCustomer(cus : Customer) : Observable<Customer>{
    return this.http.delete<Customer>(this.deleteCusURL+cus.id);
  }
}
