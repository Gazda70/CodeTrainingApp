import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Question } from "../model/question";
import { AuthService } from "./auth.service";

@Injectable({
    providedIn: "root"
})
export class QuestionService {

    constructor(private http: HttpClient, private auth: AuthService) { }

    getQuestions(): Observable<any> {
        return this.http.get<Question>('http://127.0.0.1:8080/api/questions', {
            headers: new HttpHeaders({
            'Access-Control-Allow-Origin': '*',
            'Authorization': `Bearer ${this.auth.extractToken(localStorage.getItem('currentUser'))}`
            }),
        });
    }
}