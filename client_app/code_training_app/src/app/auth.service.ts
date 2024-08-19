import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private apiUrl = 'https://your-api-url.com'; // Replace with your API endpoint

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    // Replace this with actual API call
    return this.http.post<any>(`${this.apiUrl}/login`, { username, password })
      .pipe(
        map(user => {
          if (user && user.token) {
            localStorage.setItem('currentUser', JSON.stringify(user));
          }
          return user;
        })
      );
  }

  logout() {
    localStorage.removeItem('currentUser');
  }

  public get currentUserValue() {
    return JSON.parse(localStorage.getItem('currentUser')!);
  }
}
