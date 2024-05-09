import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Alumno } from '../models/alumno';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root',
})
export class AlumnoService {
  private baseURL = `${environment.apiBase}${environment.alumnoBase}`;

  constructor(private http: HttpClient) {}

  list(): Observable<Alumno[]> {
    return this.http.get<Alumno[]>(this.baseURL);
  }

  getAlumno(id: number): Observable<Alumno> {
    return this.http.get<Alumno>(`${this.baseURL}${id}`);
  }

  save(alumno: Alumno): Observable<void> {
    return this.http.post<void>(this.baseURL, alumno);
  }

  update(alumno: Alumno): Observable<void> {
    return this.http.put<void>(`${this.baseURL}${alumno.id}`, alumno);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseURL}${id}`);
  }
}
