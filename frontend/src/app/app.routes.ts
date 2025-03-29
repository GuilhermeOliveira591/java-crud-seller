import { Routes } from '@angular/router';
import { CustomerPageComponent } from './customer-page/customer-page.component';


export const routes: Routes = [
    {path: 'customer', component: CustomerPageComponent}
    // {path: '', redirectTo: '/customer', pathMatch: 'full'},

];
