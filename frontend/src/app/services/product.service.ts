import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = environment.API_PRODUCTS;

  constructor(private http: HttpClient) {}

  createProduct(product: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, product);
  }

  getAllProducts(page: number = 0, pageSize: number = 10): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}?page=${page}&pageSize=${pageSize}`);
  }

  getProductById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  updateProduct(id: number, product: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, product);
  }

  deleteProduct(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  } 

  
}
