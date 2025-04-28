import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root',
})
export class ResultService {
    private result: number = 0;

    constructor() {}

    setResult(value: number): void {
        this.result = value;
    }

    getResult(): number {
        return this.result;
    }
}