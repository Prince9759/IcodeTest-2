import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class FileService {

  private baseURL ="http://localhost:8082"

  constructor(private http:HttpClient) { }


  downloadTemplate(): Observable<Blob> {
    return this.http.get(`${this.baseURL}/download-template`, { responseType: 'blob' });
  }
  uploadTemplate(file: File): Observable<string> {
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    const headers = new HttpHeaders();
    return this.http.post(`${this.baseURL}/upload-template`, formData,{headers,responseType:"text"});
  }

  getAllUserFile():Observable<string>
  {
    return this.http.get(`${this.baseURL}/get`,{responseType:"text"})
  }
}
