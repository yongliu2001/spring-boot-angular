import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public submitted: boolean;
  roomSearch: FormGroup;
  rooms: Room[];

  ngOnInit(): void {
    this.roomSearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
    this.rooms = ROOMS;
  }

  onSubmit({value, valid}: {value: RoomSearch, valid:boolean}) {
    console.log(value);
    console.log(valid);
  }

  reserveRoom(roomId: string) {
    console.log("Room id for reservation "+ roomId);
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

var ROOMS: Room[] = [
  {
    "id": "1",
    "roomNumber": "501",
    "price": "120",
    "links": ""
  },
  {
    "id": "2",
    "roomNumber": "502",
    "price": "130",
    "links": ""
  },
  {
    "id": "3",
    "roomNumber": "503",
    "price": "150",
    "links": ""
  }];
