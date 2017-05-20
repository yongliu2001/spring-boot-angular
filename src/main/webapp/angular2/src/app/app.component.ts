import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {Http, RequestOptions, Response, Headers} from '@angular/http';
import { Observable } from 'rxjs/Rx';
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  private baseUrl: string = "http://localhost:8080";
  public submitted: boolean;
  roomSearch: FormGroup;
  rooms: Room[];
  currentCheckin: string;
  currentCheckout: string;
  request: ReserveRoomRequest;

  constructor(private http: Http) {
  }

  ngOnInit(): void {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    const roomSearchValueChanges$ = this.roomSearch.valueChanges;
    roomSearchValueChanges$.subscribe(valueChange => {
      this.currentCheckin = valueChange.checkin;
      this.currentCheckout = valueChange.checkout;
    })
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
    this.request = new ReserveRoomRequest(roomId, this.currentCheckin, this.currentCheckout);
    this.createReservation(this.request);
  }

  createReservation(request: ReserveRoomRequest) {
    let body = JSON.stringify(request);
    let headers = new Headers({'Content-Type': 'application/json'});
    let option = new RequestOptions({headers: headers});

    this.http.post(this.baseUrl + "/room/reservation/v1", body, option)
      .subscribe(response => console.log(response));
  }

  getAll(): Observable<Room[]> {
    return this.http.get(
      this.baseUrl + "/room/reservation/v1?checkin="+this.currentCheckin+"&checkout="+ this.currentCheckout).map(this.mapRoom);
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

export class ReserveRoomRequest {
  roomId: string;
  checkin: string;
  checkout:string;

  constructor(roomId: string, checkin: string, checkout: string) {
    this.roomId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
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
