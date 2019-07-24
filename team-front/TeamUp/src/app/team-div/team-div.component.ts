import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-team-div',
  templateUrl: './team-div.component.html',
  styleUrls: ['./team-div.component.css']
})
export class TeamDivComponent implements OnInit {



  numberOfPlayers:number=+sessionStorage.getItem('player');
  numberOfTeams:number=+sessionStorage.getItem('teams');

  team:inputTeam[]=new Array(this.numberOfPlayers);

  constructor(private router:Router, private http:HttpClient) { }

  ngOnInit() {
    if(sessionStorage.length==0)
      this.router.navigate(['createTeam']);
    this.initialize();
  }

  oneTeam:number=this.numberOfPlayers/this.numberOfTeams;

  initialize(){
    for(var i =0;i<this.numberOfPlayers;i++){
      this.team[i]=new class implements inputTeam {
        playerName:'';
        playerRating:0;
      }
    }
  }

  showLoading:boolean=null;
  makeTeams() {
    const formData= new FormData();
    this.http.post<inputTeam[]>("https://lets-teamup.herokuapp.com/teamdiv/"+this.numberOfTeams,this.team).subscribe(
      res=>{
        console.log(res);
        this.team=res;
        console.log(this.team);
        sessionStorage.setItem('teamDetails',JSON.stringify(res));
        this.showLoading=true;
        this.changeLoading()
      }
    )
  }

  changeLoading():void{
    setTimeout(()=>{
      this.showLoading=false;
    },3000);
  }
}

export interface inputTeam {
  playerName:string;
  playerRating:number;
}
