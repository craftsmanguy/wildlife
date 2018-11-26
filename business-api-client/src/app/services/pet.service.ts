import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pet, Race } from '../pet/model';

import { map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  private petUrl = 'api/v1/pets/';
  private raceUrl = 'api/v1/races/';

  constructor(
    private http: HttpClient
  ) { }

  searchRaceByName(filter: { name: string } = { name: '' }, page = 1) {
    return this.http.get<Race[]>(`${this.raceUrl}?name=` + name)
      .pipe(
      tap((response: Race[]) => {
        response = response
          .map(race => new Race(race.code, race.name))
          .filter(race => race.name.includes(filter.name.toUpperCase()))
        return response;
      })
      );
  }

  getPetById(id: string) {
    return this.http.get<Pet>(`${this.petUrl}` + id);
  }

  save(pet: Pet) {
    return this.http.post<Pet>(`${this.petUrl}`, pet);
  };

}
