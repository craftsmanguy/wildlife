import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { map } from 'rxjs/operators';
import { AdminService } from '../services/admin.service';

@Injectable()
export class AuthGuard implements CanActivate {

    returnUrl: string;
    redirection: boolean;
    private checkUrl = 'api/v1/checks/token';

    constructor(
        private router: Router,
        private adminService: AdminService
    ) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        return this.adminService.isLoggedIn().pipe(
            map(isActif => {
                if (isActif) {
                    return true;
                } else {
                    this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
                    return false;
                }
            }))
    };
}