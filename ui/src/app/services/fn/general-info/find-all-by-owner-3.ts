/* tslint:disable */
/* eslint-disable */
/* Code generated by ng-openapi-gen DO NOT EDIT. */

import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { PageResponseProjectResponse } from '../../models/page-response-project-response';

export interface FindAllByOwner3$Params {
  page?: number;
  size?: number;
}

export function findAllByOwner3(http: HttpClient, rootUrl: string, params?: FindAllByOwner3$Params, context?: HttpContext): Observable<StrictHttpResponse<PageResponseProjectResponse>> {
  const rb = new RequestBuilder(rootUrl, findAllByOwner3.PATH, 'get');
  if (params) {
    rb.query('page', params.page, {});
    rb.query('size', params.size, {});
  }

  return http.request(
    rb.build({ responseType: 'json', accept: 'application/json', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<PageResponseProjectResponse>;
    })
  );
}

findAllByOwner3.PATH = '/project/owner';
