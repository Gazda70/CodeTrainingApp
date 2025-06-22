import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root',
})
export class ResultService {
    private result: number = 0;

    constructor(private http: HttpClient) {}

    setResult(value: number): void {
        this.result = value;
    }

    getResult(): number {
        return this.result;
    }

    getResultsForUserAndQuiz(userId: string, quizId: string): Observable<Object> {
        return this.http.get<Object>(`http://localhost:8080/api/quiz_solution/{userId}/{quizId}`)
    }

}