import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { QuizGridComponent } from "../quiz-grid/quiz-grid.component";
import { NavbarComponent } from "../navbar/navbar.component";
import { FooterComponent } from "../footer/footer.component";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink, QuizGridComponent, NavbarComponent, FooterComponent],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {

}
