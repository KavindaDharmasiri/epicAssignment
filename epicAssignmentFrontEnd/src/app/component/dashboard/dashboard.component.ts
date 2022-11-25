import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { Customer } from 'src/app/model/customer';
import { CustomerService } from 'src/app/service/customer.service';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  cusDetail !: FormGroup;
  cusObj : Customer = new Customer()
  cusList : Customer[] = [];

  constructor(private formBuilder : FormBuilder, private cusService : CustomerService) { }

  ngOnInit(): void {

    this.getAllCustomers();

    this.cusDetail = this.formBuilder.group({

      id : [''],
      name : [''],
      address : [''],
      age : ['']
    });

  }

  addCustomer(){
    console.log('====================================');
    console.log(this.cusDetail);
    console.log('====================================');

    this.cusObj.id = this.cusDetail.value.id;
    this.cusObj.name = this.cusDetail.value.name;
    this.cusObj.address = this.cusDetail.value.address;
    this.cusObj.age = this.cusDetail.value.age;

    this.cusService.addCustomer(this.cusObj).subscribe(res=>{
      console.log('====================================');
      console.log(res);
      console.log('====================================');
      this,this.getAllCustomers();
    },err=>{
      console.log('====================================');
      console.log(err);
      console.log('====================================');
    });
  }

  editCustomer(cus : Customer){
    this.cusDetail.controls['id'].setValue(cus.id);
    this.cusDetail.controls['name'].setValue(cus.name);
    this.cusDetail.controls['address'].setValue(cus.address);
    this.cusDetail.controls['age'].setValue(cus.age);
  }

  getAllCustomers(){
      this.cusService.getAllCustomers().subscribe(res=>{
        console.log('====================================');
        console.log(res);
        console.log('====================================');
        this.cusList = res;
      },err=>{
        console.log('====================================');
        console.log(err);
        console.log('====================================');
      });
  }

  updateCustomer(){
    this.cusObj.id = this.cusDetail.value.id;
    this.cusObj.name = this.cusDetail.value.name;
    this.cusObj.address = this.cusDetail.value.address;
    this.cusObj.age = this.cusDetail.value.age;
    this.cusService.updateCustomer(this.cusObj).subscribe(res=>{
      console.log('====================================');
      console.log(res);
      console.log('====================================');
      this.getAllCustomers();
    },err=>{
      console.log('====================================');
      console.log(err);
      console.log('====================================');
    })

  }

  deleteCustomer(cus : Customer ){
      this.cusService.deleteCustomer(cus).subscribe(res=>{
        console.log('====================================');
        console.log(res);
        alert('Customer deleted..!')
        this.getAllCustomers();
        console.log('====================================');
      },err=>{
        console.log('====================================');
        console.log(err);
        console.log('====================================');
      })
  }

}
