import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import {ContactUs} from "../contact-us/contact-us.component";

@Component({
  selector: 'app-random-team',
  templateUrl: './random-team.component.html',
  styleUrls: ['./random-team.component.css']
})
export class RandomTeamComponent implements OnInit {

  demoPlayerDetails:PlayerDetails={
    playerName:'',
    playerRating:1
  };

  numberOfPlayers:number=+sessionStorage.getItem('player');
  numberOfTeams:number=+sessionStorage.getItem('teams');

  playerDetails:PlayerDetails[] = new Array(this.numberOfPlayers);

  constructor(private router:Router, private http:HttpClient) {
  }

  ngOnInit() {
    if(sessionStorage.length==0)
      this.router.navigate(['createTeam']);
    this.initialize();
  }

  initialize(){
    for(var i =0;i<this.numberOfPlayers;i++){
      this.playerDetails[i]=new class implements PlayerDetails {
        playerName: '';
        playerRating: 0;
      }
    }
  }

  showLoading:boolean=null;
  oneTeam:number=this.numberOfPlayers/this.numberOfTeams;
  count:number=-1;


  makeTeams(): void {
    let url = "http://localhost:8080/random";

    this.http.post<PlayerDetails[]>(url,this.playerDetails).subscribe(
      res => {
        console.log(res);
        this.playerDetails=res;
        sessionStorage.setItem('teamDetails',JSON.stringify(res));
        this.showLoading=true;
        this.changeLoading()
      },
      err=>{
        alert("An error has occurred while sending message");
      }
    )
  }

  changeLoading():void{
    setTimeout(()=>{
      this.showLoading=false;
    },3000);
  }

  increaseCount() {
    this.count++;
  }
}

export interface PlayerDetails {
  playerName:string;
  playerRating:number;
}
