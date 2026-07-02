import { Component, inject, OnInit, signal } from '@angular/core';
import { GameService } from '../../service/game.service';
import { RouterLink } from '@angular/router';
import { GameListModel } from '../../model/game-list.model';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-game-list',
  imports: [NgClass, RouterLink],
  templateUrl: './game-list.html',
  styleUrl: './game-list.css',
})
export class GameList implements OnInit {
  private gameService = inject(GameService);

  gameList = signal<GameListModel[]>([]);

  ngOnInit(): void {
    this.gameService.getAllGames().subscribe({
      next: (data) => {
        this.gameList.set(data);
      },
    });
  }

  getStatusClass(status: string): string {
    switch (status) {
      case 'COMPLETED':
        return 'bg-success';
      case 'PLAYING':
        return 'bg-primary';
      case 'WISHLIST':
        return 'bg-secondary';
      case 'DROPPED':
        return 'bg-danger';
      default:
        return 'bg-secondary';
    }
  }
}
