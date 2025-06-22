import { Component } from '@angular/core';
import { AuthService } from '../../services/auth.service';
import { QuizSolutionService } from '../../services/quiz-solution.service';
import { map, Observable, switchMap } from 'rxjs';
import { AsyncPipe, CommonModule } from '@angular/common';
import { QuizSolution } from '../../model/quiz_solution';

@Component({
  selector: 'app-results-list',
  standalone: true,
  imports: [AsyncPipe, CommonModule],
  templateUrl: './results-list.component.html',
  styleUrl: './results-list.component.scss'
})
export class ResultsListComponent {

    $results: Observable<QuizSolution[]>;
    constructor(private quizSolutionService: QuizSolutionService, private authService: AuthService) {
      this.$results = this.quizSolutionService.getSolutionsByUser();
    }
}
