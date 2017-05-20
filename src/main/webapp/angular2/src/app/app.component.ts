import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public submitted: boolean;
  roomSearch: FormGroup;
  rooms: Room[];
  private baseUrl: string = "http://localhost:8080";

  constructor(private http: Http) {
  }

  ngOnInit(): void {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
    // this.rooms = ROOMS;
  }

  onSubmit({value, valid}: {value: RoomSearch, valid:boolean}) {

    this.getAll()
        .subscribe(
          rooms => this.rooms = rooms,
          error => {
            console.log(error);
          }
        );
  }

  reserveRoom(roomId: string) {
    console.log("Room id for reservation "+ roomId);
  }

  getAll(): Observable<Room[]> {
    return this.http.get(this.baseUrl + "/room/reservation/v1?checkin=2017-03-10&checkout=2017-03-15").map(this.mapRoom);
  }

  mapRoom(response: Response): Room[] {
    return response.json().content;
  }
}

export interface RoomSearch {
  checkin: string;
  checkout: string;
}

export interface Room {
  id: string;
  roomNumber: string;
  price: string;
  links: string;
}

// var ROOMS: Room[] = [
//   {
//     "id": "1",
//     "roomNumber": "501",
//     "price": "120",
//     "links": ""
//   },
//   {
//     "id": "2",
//     "roomNumber": "502",
//     "price": "130",
//     "links": ""
//   },
//   {
//     "id": "3",
//     "roomNumber": "503",
//     "price": "150",
//     "links": ""
//   }];
