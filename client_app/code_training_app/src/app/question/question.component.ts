import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Answer, Question } from '../types';

@Component({
  selector: 'app-question',
  standalone: true,
  imports: [],
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent implements OnInit {

  @Input({required: true})
  question: Question = {} as Question;

  @Output() answerId: EventEmitter<Answer> = new EventEmitter();

  public name: string = "";

  constructor() {

  }

  ngOnInit() {
    this.name = localStorage.getItem("name")!;
  }

  setAnswer(answer: Answer) {
    this.answerId.emit(answer);
  }

}
