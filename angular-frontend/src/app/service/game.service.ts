import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GameCreateCommandModel } from '../model/game-create-command.model';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  private httpClient = inject(HttpClient);

  private BASE_URL = 'http://localhost:8080/game';

  public createGame(data: GameCreateCommandModel) {
    return this.httpClient.post(this.BASE_URL, data);
  }

  public getStatus() {
    return this.httpClient.get<string[]>(`${this.BASE_URL}/status`);
  }
}
