import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Answer } from '../../model/answer';
import { Question } from '../../model/question';
import { NgClass } from '@angular/common';

@Component({
  selector: 'app-question',
  standalone: true,
  imports: [NgClass],
  templateUrl: './question.component.html',
  styleUrl: './question.component.scss'
})
export class QuestionComponent implements OnInit {

  @Input({required: true})
  question: Question = {} as Question;

  @Output() answerId: EventEmitter<Answer> = new EventEmitter();

  public name: string = "";

  public changeColor: boolean[] = [];

  constructor() {

  }

  ngOnInit() {
    this.name = localStorage.getItem("name")!;
    this.question.answers.forEach( answ => this.changeColor.push(false));
  }

  setAnswer(answer: Answer, index:number) {
    this.changeColor[index]=!this.changeColor[index];
    if(this.changeColor[index] === true) {
      for(let i = 0; i < this.changeColor.length; i++) {
        if(i !== index) {
          this.changeColor[i] = false;
        }
      }
    }
    this.answerId.emit(answer);
  }

}
