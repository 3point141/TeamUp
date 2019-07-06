import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {timeout} from "rxjs/operators";

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  contact:ContactUs ={
    name:'',
    email:'',
    message:''
  };

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit() {
  }

  getBack:boolean=null;

  sendFeedback(): void {
    let url = "http://localhost:8080/contact";
    fetch(url)
      .then(response => response.text())
      .then(contents => console.log(contents))
      .catch(() => console.log("Can’t access " + url + " response. Blocked by browser?"));
    this.http.post<ContactUs>(url,this.contact).subscribe(
      res => {
        alert("Message Sent Successfully");
        this.contact.name=null;
        this.contact.message=null;
        this.contact.email=null;
        this.getBack=true;
      },
      err=>{
        console.log([this.contact]);
        alert("An error has occurred while sending message");
      }
    )
  }
}

export interface ContactUs {
  name:string;
  email:string;
  message:string;
}
