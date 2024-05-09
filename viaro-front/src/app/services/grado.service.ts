import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.development';
import { Grado } from '../models/grado';
import { ResponseDTO } from '../models/response';

@Injectable({
  providedIn: 'root',
})
export class GradoService {
  private baseURL = `${environment.apiBase}${environment.gradoBase}`;

  constructor(private http: HttpClient) {}

  list(): Observable<Grado[]> {
    return this.http.get<Grado[]>(this.baseURL);
  }

  get(id: number): Observable<Grado> {
    return this.http.get<Grado>(`${this.baseURL}${id}`);
  }

  save(object: Grado): Observable<ResponseDTO<Grado>> {
    return this.http.post<ResponseDTO<Grado>>(this.baseURL, object);
  }

  update(object: Grado): Observable<ResponseDTO<Grado>> {
    return this.http.put<ResponseDTO<Grado>>(`${this.baseURL}${object.id}`, object);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseURL}${id}`);
  }
}
