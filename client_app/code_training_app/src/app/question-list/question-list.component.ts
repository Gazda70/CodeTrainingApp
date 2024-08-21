import { AsyncPipe, NgFor, NgIf } from '@angular/common';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { Answer, Question } from '../types'
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-question-list',
  standalone: true,
  imports: [NgFor, NgIf, AsyncPipe, RouterLink],
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.scss']
})
export class QuestionListComponent implements OnInit {

  questions$: Observable<any> | undefined;

  result: string = "";

  questionIds: number[] = [];

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.questions$ = this.getQuestions().pipe(tap(ques => {
      this.questionIds = ques.map((q: Question) => q.questionId);
    }
    ));
  }

  getQuestions(): Observable<any> {
    return this.http.get<Question>('http://127.0.0.1:8080/api/questions');
  }

  selectAnswer(question: Question, answer: Answer) {
    question.chosenAnswer = answer;
    this.http.patch('http://127.0.0.1:8080/api/questions/setQuestionAnswer',
      { 'questionId': question.questionId, 'answerId': answer.answerId },
      {
        headers: new HttpHeaders({
          'Access-Control-Allow-Origin': '*'
        }),
        params: new HttpParams({
          fromObject: {
            'questionId': question.questionId,
            'answerId': answer.answerId
          }
        }),
        responseType: "text"
      }).subscribe(res => console.log(res));
  }

  submitForm() {
    this.http.get('http://127.0.0.1:8080/api/questions/calculateResult', {
      params: new HttpParams({
        fromObject: {
          questionIds: this.questionIds.join(',')
        }
      }),
    }).subscribe(res => this.result = res as string);
  }
}
