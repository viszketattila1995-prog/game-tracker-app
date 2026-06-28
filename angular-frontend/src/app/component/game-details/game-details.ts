import { Component, inject, OnInit, signal } from '@angular/core';
import { GameService } from '../../service/game.service';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { GameItemModel } from '../../model/game-item.model';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-game-details',
  imports: [RouterLink, NgClass],
  templateUrl: './game-details.html',
  styleUrl: './game-details.css',
})
export class GameDetails implements OnInit {
  private gameService = inject(GameService);

  private route = inject(ActivatedRoute);

  gameDetails = signal<GameItemModel | undefined>(undefined);

  ngOnInit(): void {
    const id: number = +this.route.snapshot.paramMap.get('id')!;

    this.gameService.getGameById(id).subscribe({
      next: (data) => {
        this.gameDetails.set(data);
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
