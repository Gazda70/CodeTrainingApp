import { Component, computed, inject, input, OnInit } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { QuestionListComponent } from '../question-list/question-list.component';
import { Quiz } from '../../model/quiz';
import { QuizService } from '../../services/quiz.service';
import { map, Observable, of } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-quiz',
  standalone: true,
  imports: [QuestionListComponent, AsyncPipe],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.scss'
})
export class QuizComponent {

  private activatedRoute = inject(ActivatedRoute);

  $quizId = this.activatedRoute.params.pipe(map((p) => p['id']));

  $quiz: Observable<Quiz> = of();

  constructor(private quiz:QuizService, private router: Router){
    this.$quizId.subscribe(id => {
      this.$quiz = this.quiz.getQuiz(id);
    });
  }
}
