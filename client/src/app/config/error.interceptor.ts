import { Injectable } from '@angular/core';
import {HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpClient} from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import {SecuriteService} from '../services/securite/securite.service';
import {Router} from '@angular/router';


@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
  constructor(private securiteService: SecuriteService,
              private router: Router,
              private http: HttpClient) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(catchError(err => {
        this.router.navigate(['error' , err.status , err.error.message , err.statusText ]);

      const error = err.error.message || err.statusText;
      return throwError(error);
    }));
  }
}
