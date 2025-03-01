import { Component, ViewChild, ElementRef } from '@angular/core';
import { RouterLink } from '@angular/router';
import { QuizGridComponent } from "../../components/quiz-grid/quiz-grid.component";
import { NavbarComponent } from "../navbar/navbar.component";
import { FooterComponent } from "../footer/footer.component";
import {MatGridListModule} from '@angular/material/grid-list';
import { QuizService } from '../../services/quiz.service';
import { Observable } from 'rxjs';
import { Quiz } from '../../model/quiz';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, QuizGridComponent, NavbarComponent, 
    FooterComponent, MatGridListModule, CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

  @ViewChild('name') nameKey!: ElementRef;

  $quizzes: Observable<Quiz[]>;

  constructor(private quizService: QuizService) {
    this.$quizzes = this.quizService.getQuizzes();
  }

  startQuiz() {
    localStorage.setItem("name", this.nameKey.nativeElement.value);
  }
}
