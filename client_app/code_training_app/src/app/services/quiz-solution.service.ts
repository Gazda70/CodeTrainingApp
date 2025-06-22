import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from './auth.service';
import { QuizSolution } from '../model/quiz_solution';

@Injectable({
    providedIn: 'root'
})
export class QuizSolutionService {
    private apiUrl = 'http://127.0.0.1:8080/api/quiz_solution';

    constructor(private http: HttpClient, private auth: AuthService) {}

    getSolutionsByUser(): Observable<QuizSolution[]> {
        console.log('Fetching quiz solutions for the current user');
        return this.http.get<QuizSolution[]>(`${this.apiUrl}/for_current_user`
            // , 
            // {
            //         headers: new HttpHeaders({
            //         'Access-Control-Allow-Origin': '*',
            //         'Authorization': `Bearer ${this.auth.extractToken(localStorage.getItem('currentUser'))}`
            //         }),
            //     }
            );
    }

    getSolutionForQuiz(userId: string, quizId: string): Observable<QuizSolution> {
        return this.http.get<QuizSolution>(`${this.apiUrl}/${quizId}/user/${userId}`);
    }
}