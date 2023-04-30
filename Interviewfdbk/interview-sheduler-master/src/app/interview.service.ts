import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Interview } from './interview';

@Injectable({
  providedIn: 'root'
})
export class InterviewService {

  private baseUrl ='http://localhost:8080/reg';

  constructor(private http: HttpClient) { }

  createInterview(interview: Interview): Observable<Interview> {
    return this.http.post<Interview>(`${this.baseUrl}/addinterview`, interview);
  }

  getAllInterviews(): Observable<Interview[]> {
    return this.http.get<Interview[]>(`${this.baseUrl}/interview`);
  }

  getInterviewById(id: number): Observable<Interview> {
    return this.http.get<Interview>(`${this.baseUrl}/${id}`);
  }

}
