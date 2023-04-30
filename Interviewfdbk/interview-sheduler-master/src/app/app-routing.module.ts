import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { InterviewFormComponent } from './interview-form/interview-form.component';
// import { InterviewListComponent } from './interview-list/interview-list.component';

const routes: Routes = [
  { path: '', redirectTo: 'interview-form', pathMatch: 'full' },
  { path: 'interview-form', component: InterviewFormComponent }
  // { path: 'interview-list', component: InterviewListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
