import { Quiz } from "./quiz";

export interface QuizSolution {
    quizSolutionId: number;
    quiz: Quiz;
    questionAnswers: [];
    appUser: any;
    result: number;
}
