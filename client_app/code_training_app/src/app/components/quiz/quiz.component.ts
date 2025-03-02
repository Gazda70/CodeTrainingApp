import { Component, input } from '@angular/core';
import { QuestionListComponent } from '../question-list/question-list.component';

@Component({
  selector: 'app-quiz',
  standalone: true,
  imports: [QuestionListComponent],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.scss'
})
export class QuizComponent {
  name = input<string>();
}
