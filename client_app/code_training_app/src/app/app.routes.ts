import { Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { HomeComponent } from './components/home/home.component';
import { ResultsComponent } from './components/results/results.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuizService } from './services/quiz.service';
import { ResultsListComponent } from './components/results-list/results-list.component';

export const routes: Routes = [
    { path: '', redirectTo: 'login', pathMatch: 'full'},
    { path: 'login', component: LoginComponent },
    { path: 'home', component: HomeComponent },
    { path: 'results', component: ResultsComponent },
    { path: 'question-list', component: QuestionListComponent },
    { path: 'quiz/:id', component: QuizComponent},
    { path: 'results-list', component: ResultsListComponent}
];
