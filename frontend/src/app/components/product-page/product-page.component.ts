import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { FluidModule } from 'primeng/fluid';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button'
import { HttpClientModule } from '@angular/common/http';

// //services
import { ProductService } from '../../services/product.service';
import { MessageService } from 'primeng/api';  // Para exibir mensagens de sucesso/erro
import { inject } from "@angular/core";

@Component({
  selector: 'app-product-page',
  standalone: true,
  imports: [FormsModule, InputTextModule, FloatLabelModule, FluidModule, ButtonModule, DropdownModule, HttpClientModule],
  providers: [MessageService, ProductService],
  templateUrl: './product-page.component.html',
  styleUrl  : './product-page.component.css'
})

export class ProductPageComponent {
  value = {
    code: '',
    description: '',
    status: ''  // Definindo um valor inicial para o status
  };

  constructor(private productService: ProductService, private messageService: MessageService) {}
  statusOptions = [{ label: 'Ativo', value: 'Ativo' }, { label: 'Inativo', value: 'Inativo' }];


  saveProduct() {
    this.productService.createProduct(this.value).subscribe({
      next: (response) => {
        console.log('Produto salvo com sucesso:', response);
        this.messageService.add({ severity: 'success', summary: 'Sucesso', detail: 'Produto salvo!' });
        this.value = { code: '', description: '', status: '' }; // Resetando o formulário
      },
      error: (err) => {
        console.error('Erro ao salvar produto:', err);
        this.messageService.add({ severity: 'error', summary: 'Erro', detail: 'Falha ao salvar produto' });
      }
    });
  }
}
