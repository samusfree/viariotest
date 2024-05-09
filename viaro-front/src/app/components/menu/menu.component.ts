import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
    selector: 'app-menu',
    templateUrl: './menu.component.html'
})
export class MenuComponent implements OnInit {
    items: MenuItem[] | undefined;

    ngOnInit() {
        this.items = [
            {
                label: 'Inicio',
                icon: 'pi pi-address-book',
                routerLink: '/welcome'
            },
            {
                label: 'Alumno',
                icon: 'pi pi-user',
                routerLink: '/alumno'
            },
            {
                label: 'Profesor',
                icon: 'pi-users',
                routerLink: '/profesor'
            },
            {
                label: 'Grado',
                icon: 'pi pi-graduation-cap',
                routerLink: '/grado'
            },
            {
                label: 'Alumno Grado',
                icon: 'pi pi-table',
                routerLink: '/alumno-grado'
            }
        ];
    }
}