import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable, of } from 'rxjs';
import { Quiz } from '../model/quiz';

@Injectable({
    providedIn: "root"
})
export class QuizService {

    constructor(private http: HttpClient) {}

    getQuizzes(): Observable<Quiz[]> {
        return this.http.get<Quiz[]>("http://localhost:8080/api/quiz/all");
    }
}