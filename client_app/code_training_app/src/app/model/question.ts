import { Answer } from './answer';

export interface Question {
    questionId:number,
    text:string,
    answers:Array<Answer>,
    chosenAnswer:Answer
}