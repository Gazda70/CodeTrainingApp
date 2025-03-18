import { Question } from './question';

export interface Quiz {
    quizId: number;
    quizName: string;
    questions: Array<Question>;
    image: string;
}