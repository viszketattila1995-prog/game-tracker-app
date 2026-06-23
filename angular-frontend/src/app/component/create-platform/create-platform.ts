import {Component, inject, signal} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {PlatformService} from '../../service/platform.service';
import {Router} from '@angular/router';
import {HttpErrorResponse} from '@angular/common/http';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-create-platform',
  imports: [
    ReactiveFormsModule,
    NgClass
  ],
  templateUrl: './create-platform.html',
  styleUrl: './create-platform.css',
})
export class CreatePlatform {

  errorMessage = signal('')

  private formBuilder = inject(FormBuilder)

  private platformService = inject(PlatformService)

  private router = inject(Router)

  platformForm: FormGroup = this.formBuilder.group({
    name: ['', Validators.required],
    manufacturer: ['', Validators.required]
  })

  createPlatform() {
    this.platformService.createPlatform(this.platformForm.value).subscribe({
      next: () => {
        this.platformForm.reset()
        this.router.navigate(['/platform-list'])
      },
      error: (err: HttpErrorResponse) => {
        this.errorMessage.set(err.error.details)
      }
    })
  }
}
