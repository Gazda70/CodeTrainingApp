import { Component } from '@angular/core';
import { ResultService } from '../../services/result.service';

@Component({
  selector: 'app-results',
  standalone: true,
  templateUrl: './results.component.html',
  styleUrl: './results.component.scss'
})
export class ResultsComponent {
  result: number = 0;
  
  constructor(private resultService: ResultService) {
    this.result = this.resultService.getResult();
  }

}
