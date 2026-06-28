import { Routes } from '@angular/router';
import {CreatePlatform} from './component/create-platform/create-platform';
import { GameCreate } from './component/game-create/game-create';

export const routes: Routes = [
  {path: 'create-platform', component:CreatePlatform},
  {path: 'game-create', component:GameCreate},
];
