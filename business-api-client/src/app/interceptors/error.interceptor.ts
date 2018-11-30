import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpErrorResponse, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { AlertService } from '../alert/alert.service';

import 'rxjs/add/operator/do';


import { ConnectionService } from '../services/connection.service';

import { Router } from '@angular/router';

@Injectable()
export class ErrorInterceptor implements HttpInterceptor {
    constructor(
        private connectionService: ConnectionService,
        private alertService: AlertService,
    ) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).do((event: HttpEvent<any>) => {
            if (event instanceof HttpResponse) {
                this.alertService.success("success");
            }
        }, (err: any) => {
            if (err instanceof HttpErrorResponse) {
                if (err.status == 400 || err.status == 403 || err.status == 409) {
                    this.alertService.error(err.error);
                }
            }
        });
    }
}