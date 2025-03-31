import { Component, OnInit } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { InputTextModule } from 'primeng/inputtext';
import { FloatLabelModule } from 'primeng/floatlabel';
import { RadioButtonModule } from 'primeng/radiobutton';
import { DataViewModule } from 'primeng/dataview';
import { FluidModule } from 'primeng/fluid';
import { DropdownModule } from 'primeng/dropdown';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-product-page',
  imports: [FormsModule, InputTextModule, FloatLabelModule, FluidModule, ButtonModule, DropdownModule],
  templateUrl: './product-page.component.html',
  styleUrl: './product-page.component.css'
})

export class ProductPageComponent {
  value = {
    code: '',
    description: '',
    status: ''  // Definindo um valor inicial para o status
  };

  statusOptions = [{ label: 'Ativo', value: 'Ativo' }, { label: 'Inativo', value: 'Inativo' }];

  saveProduct() {
    console.log('Product saved', this.value);
  }
}
