import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { UserService } from '../services/user.service';

import { FlatTreeControl } from '@angular/cdk/tree';


import { FileNode, FileFlatNode } from './model';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css'],
  providers: [UserService]
})
export class ProfilComponent implements OnInit {

  profilId: string;
  profil: Object;


  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService,
  ) {
   
  }

  ngOnInit() {
    this.getAdvertById();
  };

  checkIdInUrlParam() {
    this.route.params.subscribe(params => {
      this.profilId = params['id'];
    });
  };

  getAdvertById() {
    this.checkIdInUrlParam();
    if (this.profilId !== undefined) {
      this.userService.getProfilById(this.profilId).subscribe(profil => { this.profil = profil });
    }
  };

}
