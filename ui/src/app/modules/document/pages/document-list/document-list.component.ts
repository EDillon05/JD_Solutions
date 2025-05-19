import {Component, OnInit} from '@angular/core';
import {GeneralInfoService} from "../../../../services/services/general-info.service";
import {Router} from "@angular/router";
import {AdministrativeService} from "../../../../services/services/administrative.service";
import {PageResponseAdministrativeResponse} from "../../../../services/models/page-response-administrative-response";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-document-list',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './document-list.component.html',
  styleUrl: './document-list.component.scss'
})
export class DocumentListComponent implements  OnInit{
  administrativeResponse: PageResponseAdministrativeResponse = {};
  page = 0;
  size = 5;
  constructor(
    private administrativeService: AdministrativeService,
    private router: Router,
  ) {
  }

  ngOnInit(): void {
    this.findAllAdministrative();
  }


  private findAllAdministrative() {
    this.administrativeService.findAllByOwner6({
      page: this.page,
      size: this.size,
    }).subscribe({
      next: (administrative) => {
        this.administrativeResponse = administrative;
      }
    })
  }
}
