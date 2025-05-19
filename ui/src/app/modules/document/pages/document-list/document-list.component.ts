import {Component, OnInit} from '@angular/core';
import {GeneralInfoService} from "../../../../services/services/general-info.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-document-list',
  standalone: true,
  imports: [],
  templateUrl: './document-list.component.html',
  styleUrl: './document-list.component.scss'
})
export class DocumentListComponent implements  OnInit{
  constructor(
    private generalInfoService: GeneralInfoService,
    private router: Router,
  ) {
  }


}
