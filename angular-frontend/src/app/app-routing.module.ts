import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { UploadComponent } from './upload/upload.component';

const routes: Routes = [
  {
    path:"home",
    component:HomeComponent
},
  {
    path:"login",
    component:LoginComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
},
{
  path: 'addfiles',

  component: UploadComponent
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
