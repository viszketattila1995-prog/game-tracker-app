import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { GameCreateCommandModel } from '../model/game-create-command.model';
import { GameListModel } from '../model/game-list.model';
import { GameItemModel } from '../model/game-item.model';

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

  public getAllGames() {
    return this.httpClient.get<GameListModel[]>(this.BASE_URL)
  }

  public getGameById(id: number) {
    return this.httpClient.get<GameItemModel>(`${this.BASE_URL}/${id}`)
  }
}
