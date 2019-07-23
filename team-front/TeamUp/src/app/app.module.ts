import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import {Router, RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './home/home.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { CreateTeamComponent } from './create-team/create-team.component';
import { RandomTeamComponent } from './random-team/random-team.component';
import { TeamDivComponent } from './team-div/team-div.component';
import { WavesComponent } from './waves/waves.component';
import { NotFoundComponent } from './not-found/not-found.component';

const appRoutes:Routes =[
  {path:'',
  component:HomeComponent},
  {path:'home',
    component:HomeComponent},
  {path:'contactUs',
  component:ContactUsComponent},
  {path:'createTeam',
  component:CreateTeamComponent},
  {path:'randomTeam',
  component:RandomTeamComponent},
  {path:'teamDiv',
  component:TeamDivComponent},
  {path:'**',
  component:NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    AboutUsComponent,
    ContactUsComponent,
    CreateTeamComponent,
    RandomTeamComponent,
    TeamDivComponent,
    WavesComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes,{useHash:true}),
    NgbModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
