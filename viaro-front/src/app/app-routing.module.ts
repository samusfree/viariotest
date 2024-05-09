import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WelcomeComponent } from './components/welcome.component';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { ProfesorComponent } from './components/profesor/profesor.component';
import { GradoComponent } from './components/grado/grado.component';
import { AlumnoGradoComponent } from './components/alumno-grado/alumno-grado.component';

const routes: Routes = [
  { path: 'welcome', component: WelcomeComponent },
  { path: 'alumno', component: AlumnoComponent },
  { path: 'profesor', component: ProfesorComponent },
  { path: 'grado', component: GradoComponent },
  { path: 'alumno-grado', component: AlumnoGradoComponent },
  { path: '', redirectTo: '/welcome', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
