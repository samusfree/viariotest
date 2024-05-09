import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { Profesor } from '../models/profesor';

@Injectable({
  providedIn: 'root',
})
export class ProfesorService {
  private baseURL = `${environment.apiBase}${environment.profesorBase}`;

  constructor(private http: HttpClient) {}

  list(): Observable<Profesor[]> {
    return this.http.get<Profesor[]>(this.baseURL);
  }

  get(id: number): Observable<Profesor> {
    return this.http.get<Profesor>(`${this.baseURL}${id}`);
  }

  save(object: Profesor): Observable<void> {
    return this.http.post<void>(this.baseURL, object);
  }

  update(object: Profesor): Observable<void> {
    return this.http.put<void>(`${this.baseURL}${object.id}`, object);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseURL}${id}`);
  }
}
