import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {PlatformCreateCommandModel} from '../model/platform-create-command.model';

@Injectable({
  providedIn: 'root',
})
export class PlatformService {

  private BASE_URL = 'http://localhost:8080/platform'

  private httpClient = inject(HttpClient)

  public createPlatform(data: PlatformCreateCommandModel) {
    return this.httpClient.post(this.BASE_URL, data)
  }

}
