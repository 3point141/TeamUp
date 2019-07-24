import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-create-team',
  templateUrl: './create-team.component.html',
  styleUrls: ['./create-team.component.css']
})
export class CreateTeamComponent implements OnInit {

  teamDetails:TeamDetails={
    numberOfPlayers:null,
    numberOfTeams:null
  };

  message:string=null;
  further:boolean=false;

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit() {
  }


  checkPossibility(): void {
    let url = "https://lets-teamup.herokuapp.com/createTeam";
    this.http.post<TeamDetails>(url,this.teamDetails).subscribe(
      res => {
        if(res) {
          this.message = "Team Formation Is Possible";
          this.further=true;
          sessionStorage.setItem('player',this.teamDetails.numberOfPlayers.toString());
          sessionStorage.setItem('teams',this.teamDetails.numberOfTeams.toString());
        }
        else {
          this.message = "Team Formation Not Possible";
          this.further=false;
          sessionStorage.clear();
        }
      },
      err=>{
        alert("Not able to Communicate with server! Please try again after sometime");
      }
    )
  }
}

export interface TeamDetails {
  numberOfPlayers:number;
  numberOfTeams:number;
}
