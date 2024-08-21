import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { QuizGridComponent } from "../quiz-grid/quiz-grid.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, QuizGridComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
