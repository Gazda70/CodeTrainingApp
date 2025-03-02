import { Component, signal, input, OnInit, Input } from '@angular/core';
import { CardContent } from '../../model/card_content';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Quiz } from '../../model/quiz';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-quiz-grid',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatToolbarModule, MatButtonModule, RouterLink],
  templateUrl: './quiz-grid.component.html',
  styleUrl: './quiz-grid.component.scss'
})
export class QuizGridComponent implements OnInit {
  cards = signal<CardContent[]>([]);

  @Input()
  quizzes: Observable<Quiz[]> | undefined;

  images = [
    'alg_graph.png',
    'alg_quicksort.png',
    'ds_arr.png',
    'ds_tree.png'
  ]

  ngOnInit() {
    this.quizzes?.subscribe(quizzes =>
      {
        const cards: CardContent[] = [];
        quizzes.forEach(quiz =>cards.push({
        title: quiz.quizName,
        description: "Desc",
        imageUrl: 'url',
        routerLink: `/quiz/${quiz.quizId}`
      }
    ))
    this.cards.set(cards);
    });
  }
}
