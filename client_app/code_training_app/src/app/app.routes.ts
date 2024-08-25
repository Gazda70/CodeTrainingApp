import { Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { QuestionListComponent } from './question-list/question-list.component';
import { HomeComponent } from './home/home.component';
import { ResultsComponent } from './results/results.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
    { path: 'results', component: ResultsComponent },
    { path: 'question-list', component: QuestionListComponent },
    { path: 'login', component: LoginComponent },
];
