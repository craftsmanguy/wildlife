import { HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import 'rxjs/add/operator/do';
import { AlertService } from '../services/alert.service';


@Injectable({
    providedIn: 'root',
})
export class ErrorResponseInterceptor implements HttpInterceptor {
    constructor(
        private alertService: AlertService,
    ) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next.handle(request).do((event: HttpEvent<any>) => {
        }, (err: any) => {
            if (err instanceof HttpErrorResponse) {
                if (err.status === 400 || err.status === 403 || err.status === 409) {
                    this.alertService.error(err.error);
                }
            }
        });
    }
}
