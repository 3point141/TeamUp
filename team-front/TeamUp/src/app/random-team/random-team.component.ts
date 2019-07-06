import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-random-team',
  templateUrl: './random-team.component.html',
  styleUrls: ['./random-team.component.css']
})
export class RandomTeamComponent implements OnInit {

  constructor(private router:Router, private http:HttpClient) {
  }

  ngOnInit() {
    if(sessionStorage.length==0)
      this.router.navigate(['createTeam']);
  }

}
