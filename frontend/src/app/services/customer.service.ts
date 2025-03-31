import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private apiUrl = process.env.API_PRODUCTS; // Fallback caso a variável não esteja definida

  constructor(private http: HttpClient) {}

  // Método para criar um novo cliente
  createCustomer(customer: any): Observable<any> {
    return this.http.post<any>(this.apiUrl, customer);
  }

  getAllCustomers(page: number, pageSize: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}?page=${page}&pageSize=${pageSize}`);
  }

  // Método para obter um cliente pelo ID
  getCustomerById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${id}`);
  }

  // Método para atualizar um cliente existente
  updateCustomer(id: number, customer: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${id}`, customer);
  }

  // Método para deletar um cliente
  deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  } 

  
}
