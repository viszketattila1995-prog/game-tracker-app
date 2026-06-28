import { Routes } from '@angular/router';
import {CreatePlatform} from './component/create-platform/create-platform';
import { GameCreate } from './component/game-create/game-create';
import { GameList } from './component/game-list/game-list';
import { GameDetails } from './component/game-details/game-details';

export const routes: Routes = [
  {path: 'create-platform', component:CreatePlatform},
  {path: 'game-create', component:GameCreate},
  {path: 'game-list', component:GameList},
  {path: 'game-details/:id', component:GameDetails},
];
