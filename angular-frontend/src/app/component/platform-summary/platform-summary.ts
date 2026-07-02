import { Component, inject, OnInit, signal } from '@angular/core';
import { PlatformService } from '../../service/platform.service';
import { PlatformSummaryModel } from '../../model/platform-summary.model';

@Component({
  selector: 'app-platform-summary',
  imports: [],
  templateUrl: './platform-summary.html',
  styleUrl: './platform-summary.css',
})
export class PlatformSummary implements OnInit {

  private platformService = inject(PlatformService);

  platformSum = signal<PlatformSummaryModel[]>([]);

  ngOnInit(): void {
    this.platformService.getPlatformSummary().subscribe({
      next: (data) => {
        this.platformSum.set(data);
      }
    })
  }
}
