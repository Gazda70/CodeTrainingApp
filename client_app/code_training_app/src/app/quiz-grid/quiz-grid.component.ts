import { Component, signal } from '@angular/core';
import { CardContent } from '../types';
import { MatCardModule } from '@angular/material/card';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-quiz-grid',
  standalone: true,
  imports: [CommonModule, MatCardModule, MatToolbarModule, MatButtonModule, RouterLink],
  templateUrl: './quiz-grid.component.html',
  styleUrl: './quiz-grid.component.scss'
})
export class QuizGridComponent {
  cards = signal<CardContent[]>([]);

  images = [
    'alg_graph.png',
    'alg_quicksort.png',
    'ds_arr.png',
    'ds_tree.png'
  ]

  ngOnInit(): void {
    const cards: CardContent[] = [];
    for(let i = 0; i < this.images.length; i++) {
      cards.push({
        title: `Quiz ${i + 1}`,
        description: "Desc",
        imageUrl: this.images[i],
        routerLink: "question-list"
      })
    }
    this.cards.set(cards);
  }
}
