import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { Profesor } from '../models/profesor';
import { AlumnoGrado } from '../models/alumno-grado';

@Injectable({
  providedIn: 'root',
})
export class AlumnoGradoService {
  private baseURL = `${environment.apiBase}${environment.alumnoGradoBase}`;

  constructor(private http: HttpClient) {}

  list(): Observable<AlumnoGrado[]> {
    return this.http.get<AlumnoGrado[]>(this.baseURL);
  }

  get(id: number): Observable<AlumnoGrado> {
    return this.http.get<AlumnoGrado>(`${this.baseURL}${id}`);
  }

  save(object: AlumnoGrado): Observable<void> {
    return this.http.post<void>(this.baseURL, object);
  }

  update(object: AlumnoGrado): Observable<void> {
    return this.http.put<void>(`${this.baseURL}${object.id}`, object);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseURL}${id}`);
  }
}
