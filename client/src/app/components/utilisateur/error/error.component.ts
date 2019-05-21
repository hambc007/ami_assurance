import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  error = this.route.snapshot.params.status;
  message = this.route.snapshot.params.message;
  text = this.route.snapshot.params.text;
  date = new Date();

  ngOnInit() {

  }

}
