import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Lunch} from "../model/lunch.model";

@Component({
  selector: 'app-hello-angular',
  templateUrl: './hello-angular.component.html',
  styleUrls: ['./hello-angular.component.scss']
})
export class HelloAngularComponent implements OnInit {

  lunchList :Array<Lunch> =[];
   title: string = "安哥拉便當";
  url ="http://localhost:8080/products";
  selectedLunch:Lunch=new Lunch();

  constructor(private httpClient: HttpClient) {
  }


  getLunchList() {
    this.httpClient.get(this.url + "/getAll").subscribe((res : any) =>{
      this.lunchList =res;
      console.log(res);
    });
  }

  buyLunch(amount: string) {
    const body = {"amount": amount};
    var buyUrl: string = this.url + "/put/" + this.selectedLunch.id.toString();
    this.httpClient.put(buyUrl, body).subscribe((res: any) =>{
      this.getLunchList();
    });
  }
changeSelectedLunch(event : any){
     console.log(this.selectedLunch);
}
   ngOnInit(): void { //初始化之後會執行的程式碼
    this.getLunchList()
     }
  }

