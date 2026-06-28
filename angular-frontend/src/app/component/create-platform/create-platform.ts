import { Component, inject, signal } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { PlatformService } from '../../service/platform.service';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-create-platform',
  imports: [ReactiveFormsModule, NgClass],
  templateUrl: './create-platform.html',
  styleUrl: './create-platform.css',
})
export class CreatePlatform {
  errorMessage = signal('');

  private formBuilder = inject(FormBuilder);

  private platformService = inject(PlatformService);

  platformForm: FormGroup = this.formBuilder.group({
    name: ['', Validators.required],
    manufacturer: ['', Validators.required],
  });

  createPlatform() {
    this.platformService.createPlatform(this.platformForm.value).subscribe({
      next: () => {
        this.platformForm.reset();
      },
      error: (err) => {
        if (err.error.fieldErrors) {
          for (const validationError of err.error.fieldErrors) {
            const formControl = this.platformForm.get(validationError.fieldError);
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
