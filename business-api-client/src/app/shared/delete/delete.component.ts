import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { DeleteService } from './delete.service';

import { PetMinimal } from '../model';


@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css'],
  providers: [DeleteService]
})
export class DeleteComponent {

  @Input('ressource')
  ressource: PetMinimal;

  @Input('uri')
  uri: string;

  @Output()
  deleteSucceeds: EventEmitter<PetMinimal> = new EventEmitter();

  constructor(
    private deleteService: DeleteService,
  ) { }

  delete() {
    if (this.ressource !== undefined && this.uri !== undefined) {
      this.deleteService.delete(this.uri, this.ressource.functionalIdentifier).subscribe((next) =>
        this.deleteSucceeds.emit(this.ressource)
      );
    }
  };

}
