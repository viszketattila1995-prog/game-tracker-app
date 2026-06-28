import { Component, inject, OnInit, signal } from '@angular/core';
import { GameService } from '../../service/game.service';
import { PlatformService } from '../../service/platform.service';
import { Router } from '@angular/router';
import { PlatformDropdownModel } from '../../model/platform-dropdown.model';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgClass, TitleCasePipe } from '@angular/common';

@Component({
  selector: 'app-game-create',
  imports: [ReactiveFormsModule, NgClass, TitleCasePipe],
  templateUrl: './game-create.html',
  styleUrl: './game-create.css',
})
export class GameCreate implements OnInit {
  private gameService = inject(GameService);

  private platformService = inject(PlatformService);

  private router = inject(Router);

  private formBuilder = inject(FormBuilder);

  platformDropdown = signal<PlatformDropdownModel[] | undefined>(undefined);

  status = signal<string[] | undefined>(undefined);

  errorMessage = signal('');

  gameForm: FormGroup = this.formBuilder.group({
    title: ['', Validators.required],
    developer: ['', Validators.required],
    releaseYear: ['', [Validators.required, Validators.min(1970), Validators.max(2030)]],
    platformId: ['', Validators.required],
    status: ['', Validators.required],
    coverUrl: [''],
  });

  ngOnInit(): void {
    this.platformService.getPlatforms().subscribe({
      next: (data) => {
        this.platformDropdown.set(data);
      },
    });
    this.gameService.getStatus().subscribe({
      next: (data) => {
        this.status.set(data);
      },
    });
  }

  createGame() {
    this.gameService.createGame(this.gameForm.value).subscribe({
      next: () => {
        this.gameForm.reset();
        this.router.navigate(['game-list']);
      },
      error: (err) => {
        if (err.error.fieldErrors) {
          for (const validationError of err.error.fieldErrors) {
            const formControl = this.gameForm.get(validationError.fieldError);
            if (formControl) {
              formControl.setErrors({ serverError: validationError.message });
            }
          }
        } else {
          this.errorMessage.set(err.error.details);
        }
      },
    });
  }
}
