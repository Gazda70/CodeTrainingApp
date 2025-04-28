import { Component } from '@angular/core';
import { ActivatedRoute, RouterOutlet } from '@angular/router';
import { QuestionListComponent } from './components/question-list/question-list.component';
import { AuthService } from './services/auth.service';
import { Router } from '@angular/router';
import { LoginComponent } from "./components/login/login.component";
import { HomeComponent } from "./components/home/home.component";
import { routeTransition } from './route-transitions';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, QuestionListComponent, LoginComponent, HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss',
  providers: [AuthService],
  animations: [
    routeTransition
  ]
})
export class AppComponent {
  title = 'code_training_app';

  constructor(private router: Router, protected route: ActivatedRoute) { }

  navigateToLogin() {
    this.router.navigate(['/login']);
  }
}
